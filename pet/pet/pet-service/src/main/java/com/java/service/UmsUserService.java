package com.java.service;

import com.java.vo.UmsUserVo;

public interface UmsUserService {
    public String login(String phone);

    public UmsUserVo getUmsUserByToken(String token);

    public String replaceToken(String token);
}
