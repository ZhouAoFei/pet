package com.java.vo;

import java.io.Serializable;

/**
* @author pet.team
* @Description 商品二级分类 DTO
*/
public class PmsSonProductCategoryVo implements Serializable {
    /** 主键ID */
    private Long secId;
    /** 分类名称 */
    private String secName;
    /** 分类级别：0->1级；1->2级 */
    private Integer secLevel;
    /** 显示状态：0->不显示；1->显示 */
    private Integer secShowStatus;
    /** 图标 */
    private String secIcon;

    /** get set 方法 */
    public String getSecIcon() {
        return secIcon;
    }

    public void setSecIcon(String secIcon) {
        this.secIcon = secIcon;
    }
    public Long getSecId() {
        return secId;
    }

    public void setSecId(Long secId) {
        this.secId = secId;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public Integer getSecLevel() {
        return secLevel;
    }

    public void setSecLevel(Integer secLevel) {
        this.secLevel = secLevel;
    }

    public Integer getSecShowStatus() {
        return secShowStatus;
    }

    public void setSecShowStatus(Integer secShowStatus) {
        this.secShowStatus = secShowStatus;
    }
}
