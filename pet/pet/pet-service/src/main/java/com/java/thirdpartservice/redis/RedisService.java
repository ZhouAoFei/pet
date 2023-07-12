package com.java.thirdpartservice.redis;

import com.java.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 把验证码存入redis
     * @param key  key
     * @param value  value值
     * @param       timeout 有效时间
     */
    public void putValue(String key,String value,long timeout){
        try{
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            //set方法，没有返回值，怎样判断redis存入数据成功？（根据key查询，判断查询结构是否有值）
            stringStringValueOperations.set(key,value, timeout, TimeUnit.SECONDS);
            System.out.println("存入字符串成功"+value);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("存入字符串失败");
        }
    }

    /**
     * 通过key获取有效时间
     * @param key
     * @return
     */
    public long getCodeTime(String key){
        Long expire = stringRedisTemplate.getExpire(key);
        return expire;
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public String getValue(String key){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String s = stringStringValueOperations.get(key);
        return s;
    }

    /**
     * 根据key去redis删除数据
     * @param key
     */
    public void delete(String key){
        try {
            stringRedisTemplate.delete(key);
            System.out.println("redis删除成功"+key);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 通过key hashkey获取value值
     * @param key  redis购车key
     * @param hashkey  商品的id
     * @return
     */
    public String getHash(String key,String hashkey){
        try {
            HashOperations<String, String, String> hash = stringRedisTemplate.opsForHash();
            String s = hash.get(key, hashkey);
            return s;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean putHash(String key,String hashkey,String value){
        try {
            HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
            hash.put(key,hashkey,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
