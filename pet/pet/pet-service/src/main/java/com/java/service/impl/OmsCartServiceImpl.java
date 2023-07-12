package com.java.service.impl;

import com.alibaba.fastjson.JSON;
import com.java.constant.Constants;
import com.java.po.PmsSku;
import com.java.service.OmsCartService;
import com.java.thirdpartservice.redis.RedisService;
import com.java.utils.RedisKeyUtils;
import com.java.vo.OmsCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class OmsCartServiceImpl implements OmsCartService {
    @Autowired
    private RedisService redisService;

    @Override
    public boolean addCart(Integer num, PmsSku sku, Long id) {
        String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_CART, id.toString());
        //1.1 获取hash（用来表示商品id-->同一个商品两次添加购物车，需要再原先的商品基础上增加数量）
        String hashkey = sku.getId().toString();

        String value = redisService.getHash(key, hashkey);
        if (!StringUtils.isEmpty(value)){
            OmsCartVo omsCartVo = JSON.parseObject(value, OmsCartVo.class);
            num+=omsCartVo.getNum();
        }
        //把购物车存入redis
        OmsCartVo omsCartVo = new OmsCartVo(sku,num,id);
        String cartValue = JSON.toJSONString(omsCartVo);
        boolean b = redisService.putHash(key, hashkey, cartValue);
        return b;
    }
}
