package com.java.vo;
import java.io.Serializable;

/**
* @author pet.team
* @Description 商品sku图片 Dto
*/
public class PmsSkuPicVo implements Serializable {
    /** 主键ID */
    private Long id;
    /** 商品skuID(对应商品sku表主键ID) */
    private Long skuId;
    /** 图片URL */
    private String picUrl;
    /** 默认展示：0->否；1->是 */
    private Integer isDefault;
    /** get set 方法 */
    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setSkuId (Long  skuId){
        this.skuId=skuId;
    }
    public  Long getSkuId(){
        return this.skuId;
    }
    public void setPicUrl (String  picUrl){
        this.picUrl=picUrl;
    }
    public  String getPicUrl(){
        return this.picUrl;
    }
    public void setIsDefault (Integer  isDefault){
        this.isDefault=isDefault;
    }
    public  Integer getIsDefault(){
        return this.isDefault;
    }
}
