package com.java.controller;


import com.java.constant.Constants;
import com.java.result.Result;
import com.java.result.ResultEnum;
import com.java.service.UmsSmsService;
import com.java.thirdpartservice.redis.RedisService;
import com.java.utils.ResultUtils;
import com.java.utils.UmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ums/sms")
public class UmsSmsController {

    @Autowired
    private UmsSmsService umsSmsService;

    @Autowired
    private RedisService redisService;

    @PostMapping("/sendSms")
    //发送短信验证码 返回值json字符串，
    public Result sendSms(String phone,Integer codeType){

        //手机号验证
        if (!UmsUtils.checkPhone(phone)){//手机号不符合要求
            return ResultUtils.returnResult(ResultEnum.FAIL_UMS_PHONE_ERROR);
        }
        //验证码类型
        if (codeType!= Constants.Sms.TYPE_REGISTER_OR_LOGIN){
            return ResultUtils.returnResult(ResultEnum.FAIL_UMS_SMS_CODE_TYPE_ERROR);
        }

        //验证码发送是否到一分钟（不够一分钟提示等待一分钟）
        if (!checkedSmsCode(codeType.toString(),phone)){
            return ResultUtils.returnFail("验证码发送不足一分钟，请等待一分钟之后在发送");
        }

        //调用service，发送验证码
        boolean b = umsSmsService.sendSms(codeType,phone);
        if (b){
            //验证码发送成功
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail();
    }

    /**
     * 判断验证码发送是否到一分钟
     * @param codeType
     * @param phone
     * @return
     */
    private boolean checkedSmsCode(String codeType,String phone){
        String key = UmsUtils.generateSmsRedisKey(codeType, phone);
        //1.去redis获取有效时间
        long codeTime = redisService.getCodeTime(key);
        //2.判断有效时间(key5分钟有效)是否>4
        if (codeTime>Constants.Time.ALI_SMS_CHECK_TIME){
            return false;
        }
        return true;


    }
}
