package com.java.service;

import com.java.po.PmsSku;
import com.java.vo.PmsProductCategoryVo;
import com.java.vo.PmsProductDetailVo;
import com.java.vo.PmsSkuVo;

import java.util.List;

public interface PmsProductService {
    public List<PmsProductCategoryVo> getAllProductCategoryList();

    public PmsProductDetailVo getProductDetailBySpuId(Integer spuId);

    public PmsSku getSkuBySkuId(Integer skuId);
}
