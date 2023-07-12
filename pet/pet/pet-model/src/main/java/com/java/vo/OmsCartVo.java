package com.java.vo;


import com.java.po.PmsSku;
import com.java.utils.DateUtils;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 购物车出参数据包装类
 * @Author pet.team
 **/
public class OmsCartVo implements Serializable, Comparable<OmsCartVo>{

    private Long userId;

    private Long spuId;

    private Long skuId;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品默认图片URL
     */
    private String picUrl;

    /**
     * 库存信息
     */
    private String stockMsg;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 单位
     */
    private String unit;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 每类商品的总价
     */
    private BigDecimal price;

    private String addTime;

    public OmsCartVo() {}

    public OmsCartVo(PmsSku pmsSku, int num, Long userId) {
        this.userId = userId;
        this.skuId = pmsSku.getId();
        this.spuId = pmsSku.getSpuId();
        this.title = pmsSku.getTitle();
        this.unitPrice = pmsSku.getPrice();
        this.unit = pmsSku.getUnit();
        this.num = num;
        this.price = unitPrice.multiply(new BigDecimal(num));
        this.addTime = DateUtils.parseCurrentDate(DateUtils.YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 价格，每种商品的总价，unit * num
     */
//    private BigDecimal price;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getStockMsg() {
        return stockMsg;
    }

    public void setStockMsg(String stockMsg) {
        this.stockMsg = stockMsg;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int compareTo(OmsCartVo cart) {
        return cart.getAddTime().compareTo(this.getAddTime());
    }
}
