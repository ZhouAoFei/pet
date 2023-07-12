package com.java.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
* @author pet.team
* @Description 商品spu Dto
*/
public class PmsSpuVo implements Serializable {
    /** 主键ID */
    private Long id;
    /** 品牌ID(对应品牌表主键ID) */
    private Long brandId;
    /** 一级分类ID(对应商品分类表主键ID) */
    private Long cid1;
    /** 二级分类ID(对应商品分类表主键ID) */
    private Long cid2;
    /** 商品名称 */
    private String name;
    /** 副标题 */
    private String subTitle;
    /** 商品总销量 */
    private Integer sale;
    /** 商品评价数量 */
    private Integer commentAmount;
    /** 评价总评分 */
    private Double commentTotalScore;
    /** 商品规格(json格式，用于商品详情页展示商品所有规格) */
    private String productSpecification;
    /** 商品默认价格 */
    private BigDecimal defaultPrice;
    /** 商品默认图片URL */
    private String defaultPicUrl;
    /** 上架状态：0->下架；1->上架 */
    private Integer publishStatus;
    /** 审核状态：0->未审核；1->审核通过 */
    private Integer verifyStatus;
    /** 是否有效，0->已删除；1->有效 */
    private Integer valid;

    /** 商品详情图片列表 */
    private List<PmsProductDetailPicVo> productDetailPicList;

    /** get set 方法 */
    public List<PmsProductDetailPicVo> getProductDetailPicList() {
        return productDetailPicList;
    }
    public void setProductDetailPicList(List<PmsProductDetailPicVo> productDetailPicList) {
        this.productDetailPicList = productDetailPicList;
    }
    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setBrandId (Long  brandId){
        this.brandId=brandId;
    }
    public  Long getBrandId(){
        return this.brandId;
    }
    public void setCid1 (Long  cid1){
        this.cid1=cid1;
    }
    public  Long getCid1(){
        return this.cid1;
    }
    public void setCid2 (Long  cid2){
        this.cid2=cid2;
    }
    public  Long getCid2(){
        return this.cid2;
    }
    public void setName (String  name){
        this.name=name;
    }
    public  String getName(){
        return this.name;
    }
    public void setSubTitle (String  subTitle){
        this.subTitle=subTitle;
    }
    public  String getSubTitle(){
        return this.subTitle;
    }
    public void setSale (Integer  sale){
        this.sale=sale;
    }
    public  Integer getSale(){
        return this.sale;
    }
    public void setCommentTotalScore (Double  commentTotalScore){
        this.commentTotalScore=commentTotalScore;
    }
    public  Double getCommentTotalScore(){
        return this.commentTotalScore;
    }
    public void setCommentAmount (Integer  commentAmount){
        this.commentAmount=commentAmount;
    }
    public  Integer getCommentAmount(){
        return this.commentAmount;
    }
    public void setProductSpecification (String  productSpecification){
        this.productSpecification=productSpecification;
    }
    public  String getProductSpecification(){
        return this.productSpecification;
    }
    public void setDefaultPrice (BigDecimal  defaultPrice){
        this.defaultPrice=defaultPrice;
    }
    public  BigDecimal getDefaultPrice(){
        return this.defaultPrice;
    }
    public void setDefaultPicUrl (String  defaultPicUrl){
        this.defaultPicUrl=defaultPicUrl;
    }
    public  String getDefaultPicUrl(){
        return this.defaultPicUrl;
    }
    public void setPublishStatus (Integer  publishStatus){
        this.publishStatus=publishStatus;
    }
    public  Integer getPublishStatus(){
        return this.publishStatus;
    }
    public void setVerifyStatus (Integer  verifyStatus){
        this.verifyStatus=verifyStatus;
    }
    public  Integer getVerifyStatus(){
        return this.verifyStatus;
    }
    public void setValid (Integer  valid){
        this.valid=valid;
    }
    public  Integer getValid(){
        return this.valid;
    }
}
