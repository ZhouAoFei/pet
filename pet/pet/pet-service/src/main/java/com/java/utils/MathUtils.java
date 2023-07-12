package com.java.utils;


import com.java.constant.Constants;

import java.math.BigDecimal;

/**
 * @Author pet.team
 * @Description 数字相关工具类
 **/
public class MathUtils {

    /**
     * 返回一个4位随机数
     * @return
     */
    public static String random(){
        int random = (int) ((Math.random() * 9 + 1) * 1000);
        return random + "";
    }


    /**
     * 返回一个指定长度的位随机数
     * @return
     */
    public static String random(int size){
        double pow = Math.pow(10, size) / 10;
        int random = (int) ((Math.random() * 9 + 1) * pow);
        return random + "";
    }

    /**
     * 格式化BigDecimal，返回保留相应的小数
     * @param decimal
     * @param num
     * @return
     */
    public static BigDecimal formatDecimal(BigDecimal decimal, int num){
        BigDecimal result = decimal.setScale(num,BigDecimal.ROUND_HALF_UP);
        return result;
    }

    /**
     * 格式化BigDecimal，默认保留两位小数
     * @param decimal
     * @return
     */
    public static BigDecimal formatDecimal(BigDecimal decimal){
        BigDecimal result = formatDecimal(decimal, Constants.Sys.DECIMAL_DIGITS);
        return result;
    }

}
