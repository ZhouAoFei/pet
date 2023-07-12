package com.java.service.impl;

import com.java.mapper.PmsProductMapper;
import com.java.po.PmsSku;
import com.java.service.PmsProductService;
import com.java.vo.PmsProductCategoryVo;
import com.java.vo.PmsProductDetailVo;
import com.java.vo.PmsSkuVo;
import com.java.vo.PmsSpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PmsProductServiceImpl implements PmsProductService {

    @Autowired
   private PmsProductMapper pmsProductMapper;
    @Override
    public List<PmsProductCategoryVo> getAllProductCategoryList() {

        return pmsProductMapper.getAllProductCategoryList();
    }

    @Override
    public PmsProductDetailVo getProductDetailBySpuId(Integer spuId) {
        //1.创建商品详情对象
        PmsProductDetailVo pmsProductDetailVo = new PmsProductDetailVo();

        //2.获取到商品信息，给pmsProductDetailVo设置spu（商品属性）
        PmsSpuVo spu = pmsProductMapper.getSpuBySpuId(spuId);

        //3.获取查询到的商品的分类信息
        //3.1获取商品中的分类id  cid1 cid2
        Long cid1 = spu.getCid1();
        Long cid2 = spu.getCid2();
        //3.2根据分类id查询分类信息
        List<Long> ids = Arrays.asList(cid1, cid2);
        List<String> name = pmsProductMapper.getCategoryNameById(ids);
        //3.3把查询的数据封装成list<map>
        List<Map<String,Object>> categories=new ArrayList<>();
        for (int i=0;i<ids.size();i++){
            Map<String,Object> map=new HashMap<>();
            map.put("name",name.get(i));
            map.put("id",ids.get(i));
            categories.add(map);
        }

        //4.根据商品id查询库存信息（包含多个图片，一对多）
        List<PmsSkuVo> skuBySpuId = pmsProductMapper.getSkuBySpuId(spuId);

        //5.给pmsProductDetailVo设置属性值
        pmsProductDetailVo.setSpu(spu);
        pmsProductDetailVo.setCategories(categories);
        pmsProductDetailVo.setSkuList(skuBySpuId);

        return pmsProductDetailVo;
    }

    @Override
    public PmsSku getSkuBySkuId(Integer skuId) {
        PmsSku sku = pmsProductMapper.getSkuBySkuId(skuId);
        return sku;
    }
}
