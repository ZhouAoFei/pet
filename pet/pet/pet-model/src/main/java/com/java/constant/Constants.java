package com.java.constant;

/**
 * @author pet.team
 * @Description 常量类
 */
public class Constants {

    /** 否 */
    public static Integer PET_NOT = 0;
    /** 是 */
    public static Integer PET_YESE = 1;

    /**
     * 默认有效时间
     */
    public static class Time {
        /** Token默认有效时间：30分钟 */
        public final static Integer TOKEN_EFFECTIVE_TIME = 1800;
        /** 阿里云短信默认有效时间：5分钟 */
        public final static Integer ALI_SMS_EFFECTIVE_TIME = 300;
        /** 阿里云短信发送频率校验 */
        public final static long ALI_SMS_CHECK_TIME = 240;
        /** 阿里云OSS文件软连接有效时间：6个小时 */
        public final static Integer ALI_OSS_TEMP_PATH_TIME = 1 * 60 * 60 * 1000;
        /** 阿里云OSS文件软连接缓存与Redis中的有效时间：比软连接时间短 */
        public final static Integer ALI_OSS_REDIS_PATH_TIME =  1 * 60 * 59;
        /** 订单默认保留时间 */
        public final static Integer ORDER_KEEP_TIME = 30 * 60 * 1000;
        /** 订单默认超时时间 */
        public final static String ORDER_OVER_TIME = "10000";
    }
    /**
     * Redis
     */
    public static class Redis {
        /** 项目公共 前缀 */
        public final static String PREFIX = "pet";
        /** 校验相关 */
        public final static String PREFIX_TOKEN = "token";
        /** 阿里云短信相关 */
        public final static String PREFIX_SMS = "sms";
        /** 购物车相关 */
        public final static String PREFIX_CART = "cart";
        /** 行政区 */
        public final static String PREFIX_PCD = "pcd";
        /** 商品分类 */
        public final static String PREFIX_CATEGORY = "category";
        /** 商品属性 */
        public final static String PREFIX_ATTRIBUTE = "attribute";

        /** 文件 */
        public static String FILE = "file";
    }
    /**
     * 权限校验
     */
    public static class Auth {
        /** Header中 Token-key名称 */
        public final static String HEADER_TOKEN_KEY_NAME = "token";
        /** Header中 TimeStamp-key名称 */
        public final static String HEADER_TIME_STAMP_KEY_NAME = "time-stamp";
        /** Header中 SourceType-key名称 */
        public final static String HEADER_SOURCE_TYPE_KEY_NAME = "source-type";
    }
    /**
     * 分隔符
     */
    public static class Sign{
        /** 冒号 */
        public final static String COLON = ":";
        /** 下划线 */
        public final static String UNDERLINE = "_";
        /** 逗号 */
        public final static String COMMA = ",";
        /** 点 */
        public final static String FULL_STOP = ".";
    }
    /**
     * 阿里云短信相关
     */
    public static class Sms{
        /** 阿里云短信服务 Message信息 */
        public final static String ALI_SMS_RESULT = "OK";
        /** 阿里云短信服务 Code key */
        public final static String ALI_SMS_CODE = "OK";

        /** 短信类型--注册或登录验证码 */
        public final static Integer TYPE_REGISTER_OR_LOGIN = 1;
    }
    /**
     * 正则表达式
     */
    public static class Regular{
        /** 手机号简单正则 */
        public static String PHONE_REGULAR_EXPRESSION = "^[1][0-9]{10}$";
    }
    /**
     * 正则表达式
     */
    public static class WeChat{
        /** 获取微信用户信息：用户名 key */
        public static String WECHAT_NIKE_NAME_KEY = "nickname";
        /** 获取微信用户信息：用户头像 key */
        public static String WECHAT_HEAD_IMAGE_URL_KEY = "headimgurl";
        /** 获取微信用户信息：性别 key */
        public static String WECHAT_SEX_KEY = "sex";
    }
    public static class Sys{
        /** 格式化BigDecimal，默认保留两位小数 */
        public static Integer DECIMAL_DIGITS = 2;
    }

    /**
     * 评论相关常量
     */
    public static class Comment{

        /**
         * 评论列表默认起始页
         */
        public static Integer DEFAULT_PAGE_NO = 1;
        /**
         * 评论列表默认页长
         */
        public static Integer DEFAULT_PAGE_SIZE = 20;

        /**
         * 最低评分
         */
        public static Integer STAR_MIN = 1;
        /**
         * 最高评分
         */
        public static Integer STAR_MAX = 5;

        /**
         * 评论内容最大字符数
         */
        public static Integer CONTENT_SIZE_MAX = 400;

        /**
         * 是否有图评论
         */
        public static class isPic{
            /**
             * 全部评论
             */
            public static Integer ALL = 1;

            /**
             * 有图评论
             */
            public static Integer YES = 2;

            /**
             * 无图评论
             */
            public static Integer NOT = 3;
        }


    }

    /**
     * 购物车相关常量
     */
    public static class Cart{

        /**
         * 购物车中，每件商品的最小数量
         */
        public static Integer NUM_MIN = 1;

        /**
         * 购物车中，商品种类的最大数量
         */
        public static Integer SKU_NUM_MAX = 99;

    }


    /**
     * 订单相关常量
     */
    public static class Order{

        /** 个人最大收货地址数量 */
        public static Integer RECEIVER_ADDRESS_MAX = 20;
        /** 收货人姓名长度限制 */
        public static Integer USERNAME_LENGTH_MAX = 10;
        /** 收货详细地址长度限制 */
        public static Integer ADDRESS_LENGTH_MAX = 200;

        /** 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->超时 */
        public static class Status{
            /** 待付款 */
            public static Integer OBLIGATION = 0;
            /** 待发货  */
            public static Integer WAIT_DELIVERY  = 1;
            /** 已发货  */
            public static Integer DELIVERY = 2;
            /** 已完成  */
            public static Integer FINISH = 3;
            /** 已关闭  */
            public static Integer CLOSE = 4;
            /** 超时  */
            public static Integer TIMEOUT = 5;
        }

        /** 支付状态 */
        public static class PayStatus{
            /** 待支付 */
            public static Integer WAIT = 0;
            /** 支付成功 */
            public static Integer SUCCESS = 1;
            /** 支付失败  */
            public static Integer FAIL = 2;
        }

        /** 支付方式  */
        public static class PayWay{
            /** 在线支付 */
            public static Integer ONLINE = 0;
            /** 货到付款 */
            public static Integer CASH_ON_DELIVERY = 1;
        }


    }

    /**
     * 支付相关常量
     */
    public static class Pay{
        /**
         * 支付订单号追加字符长度
         */
        public static int ORDER_NO_APPEND_SIZE = 6;

        /** 支付方式  */
        public static class PayWay{
            /** 阿里支付 */
            public static Integer ALI = 1;
            /** 微信支付 */
            public static Integer WECHAT = 2;
        }

        /** 支付状态 */
        public static class PayStatus{
            /** 待支付 */
            public static Integer WAIT = 0;
            /** 支付成功 */
            public static Integer SUCCESS = 1;
            /** 支付失败  */
            public static Integer FAIL = 2;
        }

        /** 支付记录状态  */
        public static class PayLogStatus{
            /** 成功  */
            public static Integer SUCCESS = 1;
            /** 失败 */
            public static Integer FAIL = 2;
        }
    }

    /**
     * 商品相关常量
     */
    public static class Spu{

        /**
         * 状态 - 下架
         */
        public static Integer PUBLISH_STATUS_OFF = 0;
        /**
         * 状态 - 上架
         */
        public static Integer PUBLISH_STATUS_ON = 1;
    }

    /**
     * 商品相关常量
     */
    public static class Files{

        /**
         * 文件最小限制
         */
        public static Integer SIZE_MIN = 0;

        /**
         * 文件最大限制
         */
        public static Integer SIZE_MAX = 5 * 1024 * 1024;
    }

}
