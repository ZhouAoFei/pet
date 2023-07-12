package com.java.utils;


import com.java.constant.Constants;
import org.springframework.util.StringUtils;

/**
 * @author pet.team
 * @Description Redis key工具类
 **/
public class RedisKeyUtils {

    /**
     * 根据出入的参数创建一个Redis key
     * @return 如果参数为空，那么返回null
     */
    public static String formatKeys(String ... args){
        if (args != null && args.length > 0){
            StringBuilder key = new StringBuilder();
            for (String s: args){
                key.append(s).append(Constants.Sign.UNDERLINE);
            }
            return key.toString();
        }
        return null;
    }

    /**
     * 根据参数创建一个Redis key，自动拼接公共前缀  pet:sms:  (pet:cart:)
     * @return 如果参数为空，那么返回null
     */
    public static String formatKeyWithPrefix(String ... args){
        if(args == null && args.length <= 0){
            return  null;
        }
        // 初始化项目公共前缀
        StringBuilder key = new StringBuilder(Constants.Redis.PREFIX).append(Constants.Sign.COLON);
        for (String str: args){
            if(!StringUtils.isEmpty(str)){
                key.append(str).append(Constants.Sign.COLON);
            }
        }
        // 删除最后的分隔符
        key = key.deleteCharAt(key.lastIndexOf(Constants.Sign.COLON));
        return key.toString();
    }

    /**
     * 生成Redis key：商品相关文件
     * @param filePath
     * @return
     */
    public static String generateFileRedisKey(String filePath){
        return RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.FILE, filePath);
    }
}
