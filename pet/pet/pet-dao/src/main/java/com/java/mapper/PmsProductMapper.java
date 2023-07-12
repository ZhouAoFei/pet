package com.java.mapper;

import com.java.po.PmsSku;
import com.java.vo.PmsProductCategoryVo;
import com.java.vo.PmsSkuVo;
import com.java.vo.PmsSpuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PmsProductMapper {
    //查询商品分类，分类在pms_product_category表中,一级分类，二级分类都是这一张表,自关联查询
    public List<PmsProductCategoryVo> getAllProductCategoryList();

    public PmsSpuVo getSpuBySpuId(Integer supId);

    public List<String> getCategoryNameById(List ids);

    public List<PmsSkuVo> getSkuBySpuId(Integer spuId);

    public PmsSku getSkuBySkuId(Integer skuId);
}
