package com.java.mapper;

import com.java.po.UmsUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsUserMapper {
    public UmsUser getUmsUserByPhone(String phone);

    public int addUmsUser(UmsUser umsUser);
}
