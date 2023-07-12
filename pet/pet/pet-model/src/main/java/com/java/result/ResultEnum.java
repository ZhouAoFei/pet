package com.java.result;

/**
 * @author pet.team
 * @Description 状态码列表
 */
public enum ResultEnum {
    SUCCESS("200", "成功"),
    FAIL("0","失败"),
    COMMON_EXCEPTION("500", "系统异常"),
    // 权限校验
    AUTH_TOKEN_EMPTY("401","Token空！"),
    AUTH_USER_NOT_LOGIN("401", "未登录！"),
    AUTH_TIME_STAMP_EMPTY("401", "时间戳(time-stamp)空！"),
    AUTH_SOURCE_TYPE_EMPTY("401", "访问来源(source-type)空！"),

    // 参数校验
    FAIL_PARAM_EMPTY("0", "必传参数未传！"),

    // Ums相关
    FAIL_UMS_PHONE_ERROR("10001", "手机号错误"),
    FAIL_UMS_SMS_CODE_TYPE_ERROR("10002", "短信类型错误"),
    FAIL_UMS_SMS_CODE_ERROR("10003", "短信验证码错误或已失效"),
    // Pms相关
    FAIL_PRODUCT_SEC_CATEGORY_ID_EMPTY("20001","商品二级分类ID为空"),
    PRODUCT_ATTRIBUTE_EMPTY("20002","该商品二级分类下无商品属性"),
    PRODUCT_SPU_EMPTY("20003","查询不到商品"),
    PRODUCT_STATUS_OFF("20004","商品已下架"),
    // 商品评论
    PRODUCT_COMMENT_STAR_ERROR("21001","评分规则错误"),
    PRODUCT_COMMENT_NOT_BUY("21002","要评论的商品未曾购买"),
    PRODUCT_COMMENT_CONTENT_LENGTH_MAX_ERROR("21001","评论内容过长字"),

    // 购物车
    ADD_CART_MIN_NUM_ERROR("30001","至少需要向购物车中加入1件商品"),
    ADD_CART_LOW_STOCK_ERROR("30002","库存不足"),

    // 订单相关
    ORDER_NOT_EXIST("40001","订单不存在"),
    ORDER_STATUS_ERROR("40002","订单状态错误"),
    RECEIVER_ADDRESS_MAX_ERROR("41001","最多可以添加20个个人收收货地址"),
    RECEIVER_ADDRESS_USERNAME_TO_LANG_ERROR("41002","收货人姓名应保持在10个字符之内"),
    RECEIVER_ADDRESS_DETAIL_TO_LANG_ERROR("41003","详细收货地址应保持在200个字符之内"),
    RECEIVER_ADDRESS_NOT_EXIST_ERROR("41004","当前收货地址不存在"),
    REDUCE_INVENTORY_ERROR("40003","扣减商品sku库存失败"),
    DELETE_CART_ERROR("40004","清空购物车失败"),

    // 订单支付
    PAY_ERROR("50001","支付失败"),

    // 其他
    PARAM_ERROR("91001", "请求参数错误！"),
    OTHER_FILE_SIZE_MAX_ERROR("91002","上传文件过大"),
    OTHER_FILE_NOT_EMPTY_ERROR("91003","不能上传空文件");
    String code;
    String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    public static ResultEnum getByCode(String code) {
        if (code == null) {
            return COMMON_EXCEPTION;
        }
        for (ResultEnum outputEnum : ResultEnum.values()) {
            if (code.equals(outputEnum.code)) {
                return outputEnum;
            }
        }
        return COMMON_EXCEPTION;
    }
}
