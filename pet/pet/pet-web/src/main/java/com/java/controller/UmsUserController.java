package com.java.controller;

import com.java.constant.Constants;
import com.java.result.Result;
import com.java.result.ResultEnum;
import com.java.service.UmsUserService;
import com.java.thirdpartservice.redis.RedisService;
import com.java.utils.ResultUtils;
import com.java.utils.UmsUtils;
import com.java.vo.UmsUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/ums/user")
@RestController
public class UmsUserController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private UmsUserService umsUserService;

    @RequestMapping("/login")
    public Result login(String phone,String sms){
        //1.判断手机号
        if (!UmsUtils.checkPhone(phone)){
            return ResultUtils.returnResult(ResultEnum.FAIL_UMS_PHONE_ERROR);
        }

        //2.判断验证码（第一验证码必须存在，第二验证码必须是自己的）根据key从redis获取
        if (!checkedSmsCode(phone,sms)){
            return ResultUtils.returnResult(ResultEnum.FAIL_UMS_SMS_CODE_ERROR);
        }

        //3.调用service登录，返回token
        String login = umsUserService.login(phone);
        if (login!=null && login.trim().length()>0){
            Map map=new HashMap();
            map.put(Constants.Auth.HEADER_TOKEN_KEY_NAME,login);
            return ResultUtils.returnDataSuccess(map);
        }

        return ResultUtils.returnFail("登录失败");

    }

    /**
     *通过token获取用户信息   登录成功之后一个对象对应一个token（登录）
     *                      根据token查询用户信息(查询之前必须把token和对应的UmsUser对象存起来)
     * @param request
     * @return
     */
    @GetMapping("/getUserByToken")
    public Result getUserByToken(HttpServletRequest request){ //通过headers（请求头）传参,获取参数通过请求对象 request
        //获取headers中的参数 key-->token
        String token = request.getHeader(Constants.Auth.HEADER_TOKEN_KEY_NAME);
        //System.out.println(token);
        UmsUserVo umsUserByToken = umsUserService.getUmsUserByToken(token);
        if (umsUserByToken!=null){
            return ResultUtils.returnDataSuccess(umsUserByToken);
        }
        return ResultUtils.returnFail();
    }

    @GetMapping("/replaceToken")
    public Result replaceToken(HttpServletRequest request){
        String token = request.getHeader(Constants.Auth.HEADER_TOKEN_KEY_NAME);
        String newToken = umsUserService.replaceToken(token);
        if (StringUtils.isEmpty(newToken) || newToken.trim().length()<=0){
            return ResultUtils.returnFail();
        }
        Map map=new HashMap();
        map.put(Constants.Auth.HEADER_TOKEN_KEY_NAME,newToken);
        return ResultUtils.returnDataSuccess(map);
    }

    /**
     * 检验登录的时候填写验证码是否和redis中的验证码是否一致
     * @param phone
     * @param sms
     * @return
     */
    private boolean checkedSmsCode(String phone,String sms){
        //1.获取验证码对应的key
        String key = UmsUtils.generateSmsRedisKey(Constants.Sms.TYPE_REGISTER_OR_LOGIN.toString(), phone);
        //2.根据key获取redis的验证码
        String code = redisService.getValue(key);
        return sms.equals(code);
    }
}
