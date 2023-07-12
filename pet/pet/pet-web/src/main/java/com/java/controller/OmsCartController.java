package com.java.controller;

import com.alibaba.fastjson.JSON;
import com.java.constant.Constants;
import com.java.exception.BaseException;
import com.java.po.PmsSku;
import com.java.result.Result;
import com.java.result.ResultEnum;
import com.java.service.OmsCartService;
import com.java.service.PmsProductService;
import com.java.service.UmsUserService;
import com.java.thirdpartservice.redis.RedisService;
import com.java.utils.RedisKeyUtils;
import com.java.utils.ResultUtils;
import com.java.vo.OmsCartVo;
import com.java.vo.UmsUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/api/oms/cart")
@RestController
public class OmsCartController {
    @Autowired
    private PmsProductService pmsProductService;
    @Autowired
    private UmsUserService umsUserService;
    @Autowired
    private RedisService redisService;

    @Autowired
    private OmsCartService omsCartService;
    @PostMapping("/add")
    public Result addCart(Integer skuId, Integer num, HttpServletRequest request){
        String token = request.getHeader(Constants.Auth.HEADER_TOKEN_KEY_NAME);
        //1.根据skuId查询库存商品
        PmsSku sku = pmsProductService.getSkuBySkuId(skuId);
        if (StringUtils.isEmpty(sku)){//购买商品不存在
            return ResultUtils.returnResult(ResultEnum.PRODUCT_SPU_EMPTY);
        }
        //2.表示商品存在，判断num（负数：购物车商品减少，正数：购物车商品增加--》判断num是否大于商品库存）
        //根据token获取用户信息
        UmsUserVo umsUser = umsUserService.getUmsUserByToken(token);
        Long id = umsUser.getId();
        checkedProduct(num,sku,id);

        //3.添加购物车 存入redis(数据结构hash  Map<key,Map<hashKey,Object>>) pet:cart:用户id
        boolean b = omsCartService.addCart(num, sku, id);
        if (b){
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail();


    }

    /**
     * 判断当前需要添加到购物车中的这个商品在购物车中是否存在
     * @param num
     * @param sku
     * @param id
     */
    private void checkedProduct(Integer num,PmsSku sku,Long id){
        //1.判断当前需要添加到购物车中的这个商品在购物车中是否存在
        //1.1生成购物车key
        String key = RedisKeyUtils.formatKeyWithPrefix(Constants.Redis.PREFIX_CART, id.toString());
        //1.1 获取hash（用来表示商品id-->同一个商品两次添加购物车，需要再原先的商品基础上增加数量）
        String hashkey = sku.getId().toString();
        //1.2根据key hashkey获取购物车的商品,如果获取到商品，表示商品已经添加购物车，增加数量，否则添加商品
        String value = redisService.getHash(key, hashkey);
        if (!StringUtils.isEmpty(value)){ //修改购车中商品的数量
            OmsCartVo omsCartVo = JSON.parseObject(value, OmsCartVo.class);
            num+=omsCartVo.getNum()+num;//1<=购物车最终的商品数量必须<=商品的库存
        }

        //2.num最少是1
        if (num<Constants.Cart.NUM_MIN){
            throw new BaseException(ResultEnum.ADD_CART_MIN_NUM_ERROR);
        }

        //3.判断num<=商品库存
        if (num>sku.getStock()){
            throw new BaseException(ResultEnum.ADD_CART_LOW_STOCK_ERROR);
        }
    }

}
