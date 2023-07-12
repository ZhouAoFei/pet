package com.java.service.impl;

import com.java.constant.Constants;
import com.java.service.UmsSmsService;
import com.java.thirdpartservice.AliYunService;
import com.java.thirdpartservice.redis.RedisService;
import com.java.utils.MathUtils;
import com.java.utils.UmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmsSmsServiceImpl implements UmsSmsService {
    @Autowired
    private AliYunService aliYunService;

    @Autowired
    private RedisService redisService;

    //发送短信
    @Override
    public boolean sendSms(Integer codeType,String phone) {
        //1.调用工具类生成验证码
        String code = MathUtils.random();

        //2.调用阿里云service发送验证码
        //boolean b = aliYunService.sendSms(phone, code);
        boolean b=true;
        //3.用户接收到验证码，存入redis
        if (b){
            //生成redis中存放验证码的key
            String key = UmsUtils.generateSmsRedisKey(codeType.toString(), phone);
            //验证码存入redis
            redisService.putValue(key,code, Constants.Time.ALI_SMS_EFFECTIVE_TIME);
        }

        return b;
    }
}
