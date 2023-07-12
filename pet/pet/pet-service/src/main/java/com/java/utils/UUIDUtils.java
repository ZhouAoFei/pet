package com.java.utils;

import java.util.UUID;

/**
 * @author pet.team
 * @Description UUID工具类
 */
public class UUIDUtils {

    /**
     * 返回一个没有中划线的32位字符串
     * @return
     */
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
