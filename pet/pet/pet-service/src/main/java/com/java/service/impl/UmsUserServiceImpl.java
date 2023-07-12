package com.java.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.java.constant.Constants;
import com.java.mapper.UmsUserMapper;
import com.java.po.UmsUser;
import com.java.service.UmsUserService;
import com.java.thirdpartservice.redis.RedisService;
import com.java.utils.UUIDUtils;
import com.java.utils.UmsUtils;
import com.java.vo.UmsUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UmsUserServiceImpl implements UmsUserService {
    @Autowired
    private UmsUserMapper umsUserMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public String login(String phone) {
        UmsUser umsUserByPhone = umsUserMapper.getUmsUserByPhone(phone);
        //判断当前用户是否第一次登录（根据手机号查询的用户是否为null，为null第一次）
        if (umsUserByPhone==null){
            UmsUser umsUser = new UmsUser();
            umsUser.setAccount(phone);
            umsUser.setUserName(phone);
            //第一次登录，自动注册
            int i = umsUserMapper.addUmsUser(umsUser);
            if (i!=1){
                return null;
            }
        }
        //登录成功，(注册)返回token   （把登录成功的对象和它的token存起来，存redis  token--》key  对象--》value）
      return setToken(umsUserByPhone);
    }




    /**
     * 通过token获取redis中的UmsUser对象  （需要是UmsUserVo四个字段的对象）
     * @param token
     * @return
     */
    public UmsUserVo getUmsUserByToken(String token){
        String key = UmsUtils.generateTokenRedisKey(token);
        String value = redisService.getValue(key);
        //把json字符串对象转化成java对象，类型不能是JsonObject
        UmsUser umsUser = JSONObject.parseObject(value, UmsUser.class);

        UmsUserVo umsUserVo=new UmsUserVo();
        BeanUtils.copyProperties(umsUser,umsUserVo);
        System.out.println(umsUserVo);
        return umsUserVo;
    }

    /**
     * 根据旧token查询redis中UmsUser对象,存在，生成新token绑定UmsUser对象
     * @param token
     * @return
     */
    @Override
    public String replaceToken(String token) {
        //1.根据旧token查询umsUser对象
        String key = UmsUtils.generateTokenRedisKey(token);
        String value = redisService.getValue(key);//UmsUser的json字符串形式
        //2.判断旧token是否有对应的UmsUser字符串
        if (StringUtils.isEmpty(value)){
            return null;//不用生成新token
        }
        //3.旧token有对应的UmsUser对象(生成新token,绑定UmsUser对象)
        UmsUser umsUser = JSONObject.parseObject(value, UmsUser.class);

        //4.删除旧token（一个用户同时只能登录一次同一个网站，对应的token必须唯一）
        redisService.delete(key);

        return setToken(umsUser);
    }

    /**
     * 把token和对象存入redis,并返回token
     * @param umsUserByPhone
     * @return
     */
    public String setToken(UmsUser umsUserByPhone){
        //把token和对应的UmsUser对象存入redis
        String uuid32 = UUIDUtils.getUUID32();
        String key = UmsUtils.generateTokenRedisKey(uuid32);
        //  JSON.toJSON（）把java的对象转化成json的对象
        redisService.putValue(key, JSON.toJSON(umsUserByPhone).toString(), Constants.Time.TOKEN_EFFECTIVE_TIME);

        return uuid32;
    }
}
