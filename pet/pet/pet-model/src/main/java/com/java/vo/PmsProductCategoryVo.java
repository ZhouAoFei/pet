package com.java.vo;

import java.io.Serializable;
import java.util.List;

/**
* @author pet.team
* @Description 商品分类 DTO
*/
public class PmsProductCategoryVo implements Serializable {
    /** 主键ID */
    private Long id;
    /** 分类名称 */
    private String name;

    /** 分类级别：0->1级；1->2级 */
    private Integer level;
    /** 显示状态：0->不显示；1->显示 */
    private Integer showStatus;
    /** 图标 */
    private String icon;
    /** 商品二级分类列表 */
    private List<PmsSonProductCategoryVo> secProductCategoryList;


    public List<PmsSonProductCategoryVo> getSecProductCategoryList() {
        return secProductCategoryList;
    }

    public void setSecProductCategoryList(List<PmsSonProductCategoryVo> secProductCategoryList) {
        this.secProductCategoryList = secProductCategoryList;
    }

    /** get set 方法 */

    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setName (String  name){
        this.name=name;
    }
    public  String getName(){
        return this.name;
    }
    public void setLevel (Integer  level){
        this.level=level;
    }
    public  Integer getLevel(){
        return this.level;
    }
    public void setShowStatus (Integer  showStatus){
        this.showStatus=showStatus;
    }
    public  Integer getShowStatus(){
        return this.showStatus;
    }
    public void setIcon (String  icon){
        this.icon=icon;
    }
    public  String getIcon(){
        return this.icon;
    }
}
