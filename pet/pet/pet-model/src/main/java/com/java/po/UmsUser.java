package com.java.po;
import java.io.Serializable;
import java.util.Date;

/**
* @author pet.team
* @Description 用户表
*/
public class UmsUser {
    /**  */
    private Long id;
    /** 账号 */
    private String account;
    /** 微信openId */
    private String openId;
    /** 用户名 */
    private String userName;
    /** 用户头像URL */
    private String headUrl;
    /** 性别 0->保密，1->男性，2->女性 */
    private Integer sex;
    /** 密码 */
    private String password;
    /** 创建时间 */
    private Date createdTime;
    /** 修改时间 */
    private Date updatedTime;
    /** get set 方法 */
    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setAccount (String  account){
        this.account=account;
    }
    public  String getAccount(){
        return this.account;
    }
    public void setOpenId (String  openId){
        this.openId=openId;
    }
    public  String getOpenId(){
        return this.openId;
    }
    public void setUserName (String  userName){
        this.userName=userName;
    }
    public  String getUserName(){
        return this.userName;
    }
    public void setHeadUrl (String  headUrl){
        this.headUrl=headUrl;
    }
    public  String getHeadUrl(){
        return this.headUrl;
    }
    public void setSex (Integer  sex){
        this.sex=sex;
    }
    public  Integer getSex(){
        return this.sex;
    }
    public void setPassword (String  password){
        this.password=password;
    }
    public  String getPassword(){
        return this.password;
    }
    public void setCreatedTime (Date  createdTime){
        this.createdTime=createdTime;
    }
    public  Date getCreatedTime(){
        return this.createdTime;
    }
    public void setUpdatedTime (Date  updatedTime){
        this.updatedTime=updatedTime;
    }
    public  Date getUpdatedTime(){
        return this.updatedTime;
    }
}
