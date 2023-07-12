package com.java.utils;


import com.java.constant.Constants;
import com.java.exception.BaseException;

/**
 * @author pet.team
 * @Description Ums相关工具类
 */
public class UmsUtils {
    /**
     * 验证手机号
     *
     * @param phone
     */
    public static boolean checkPhone(String phone) throws BaseException {
        return phone.matches(Constants.Regular.PHONE_REGULAR_EXPRESSION);
    }

    /**
     * 验证短信类型
     *
     * @param codeType
     */
    public static boolean checkCodeType(Integer codeType) {
        // 如果是不已定义的短信类型，不允许发送
        return codeType.equals(Constants.Sms.TYPE_REGISTER_OR_LOGIN);
    }

    /**
     * 生成Redis key：短信验证码
     *
     * @param codeType 短信类型
     * @param phone    手机号
     * @return
     */
    public static String generateSmsRedisKey(String codeType, String phone) {
        return RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_SMS, codeType, phone);
    }

/*    *
     * 生成Redis key：token
     * @param token
     * @return*/

    public static String generateTokenRedisKey(String token){
        return RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_TOKEN, token);
    }

}
