package com.java.controller;

import com.java.result.Result;
import com.java.service.PmsProductService;
import com.java.utils.ResultUtils;
import com.java.vo.PmsProductCategoryVo;
import com.java.vo.PmsProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.misc.ReflectUtil;

import java.util.List;

@RequestMapping("/api/pms/product")
@RestController
public class PmsProductController {
    @Autowired
    private PmsProductService pmsProductService;
    /**
     * 查询所有商品分类
     * @return
     */
    @GetMapping("/category/list")
    public Result getProductCategoryList(){
        List<PmsProductCategoryVo> allProductCategoryList = pmsProductService.getAllProductCategoryList();
        if (allProductCategoryList!=null && allProductCategoryList.size()>0){
            return ResultUtils.returnDataSuccess(allProductCategoryList);
        }
        return ResultUtils.returnFail();
    }

    /**
     * 根据商品id(spuId)查询商品详情
     * @param spuId
     * @return
     */
    @GetMapping("/detail")
    public Result getProductBySpuId(Integer spuId){
        PmsProductDetailVo productDetailBySpuId = pmsProductService.getProductDetailBySpuId(spuId);
        if (productDetailBySpuId!=null){
            return ResultUtils.returnDataSuccess(productDetailBySpuId);
        }
        return ResultUtils.returnFail();

    }
}
