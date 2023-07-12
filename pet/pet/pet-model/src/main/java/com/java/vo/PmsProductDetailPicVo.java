package com.java.vo;
import java.io.Serializable;

/**
* @author pet.team
* @Description 商品详情图片表Dto
*/
public class PmsProductDetailPicVo implements Serializable {
    /** 主键ID */
    private Long picId;
    /** 图片URL */
    private String picUrl;
    /** get set 方法 */
    public Long getPicId() {
        return picId;
    }
    public void setPicId(Long picId) {
        this.picId = picId;
    }
    public void setPicUrl (String  picUrl){
        this.picUrl=picUrl;
    }
    public  String getPicUrl(){
        return this.picUrl;
    }
}
