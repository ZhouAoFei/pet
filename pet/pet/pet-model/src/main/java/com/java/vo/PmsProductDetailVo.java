package com.java.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author pet.team
 * @Description 商品详情 Dto
 */
public class PmsProductDetailVo implements Serializable {
    /** 商品spu信息 */
   private PmsSpuVo spu;
    /** 商品分类数组 */
    private List<Map<String,Object>> categories;
    /** 商品sku列表 */
    private List<PmsSkuVo> skuList;

    public List<PmsSkuVo> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<PmsSkuVo> skuList) {
        this.skuList = skuList;
    }

    public List<Map<String, Object>> getCategories() {
        return categories;
    }

    public void setCategories(List<Map<String, Object>> categories) {
        this.categories = categories;
    }

    public PmsSpuVo getSpu() {
        return spu;
    }

    public void setSpu(PmsSpuVo spu) {
        this.spu = spu;
    }
}
