package com.java.service;

import com.java.result.Result;

public interface UmsSmsService {
    //发送短信验证码
    public boolean sendSms(Integer codeType,String phone);
}
