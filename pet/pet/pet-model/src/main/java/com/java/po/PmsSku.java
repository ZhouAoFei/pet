package com.java.po;

import java.math.BigDecimal;
import java.util.Date;

public class PmsSku {    /** 主键ID */
   private Long id;
    /** 商品spuID(对应商品spu表主键ID) */
    private Long spuId;
    /** 商品标题 */
    private String title;
    /** 价格 */
    private BigDecimal price;
    /** 商品单位 */
    private String unit;
    /** 库存 */
    private Integer stock;;
    /** 销量 */
    private Integer sale;
    /** spu中商品规格的对应下标组合 */
    private String indexes;
    /** 商品sku规格(json格式，反序列化时请使用linkedHashMap，保证有序) */
    private String productSkuSpecification;
    /** 默认规格：0->不是；1->是 */
    private Integer isDefault;
    /** 是否有效，0->无效；1->有效 */
    private Integer valid;
    private Date createdTime;
    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    public String getProductSkuSpecification() {
        return productSkuSpecification;
    }

    public void setProductSkuSpecification(String productSkuSpecification) {
        this.productSkuSpecification = productSkuSpecification;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
