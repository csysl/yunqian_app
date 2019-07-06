package com.example.xiaoming.lesson.Activity.bean;

import java.io.Serializable;

public class Passport {

    private static final long serialVersionUID = 1L;

    private Integer Id;
    private String Username;
    private String Password;
    private Integer UserId;
    /**
     * 登陆用户类型:手机号、邮箱
     */
    private Integer Type;
    private String CreateDate;
    private Integer CreateBy;
    private String ModifyDate;
    private Integer ModifyBy;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer Type) {
        this.Type = Type;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public Integer getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(Integer CreateBy) {
        this.CreateBy = CreateBy;
    }

    public String getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(String ModifyDate) {
        this.ModifyDate = ModifyDate;
    }

    public Integer getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(Integer ModifyBy) {
        this.ModifyBy = ModifyBy;
    }

    protected Serializable pkVal() {
        return this.Id;
    }

}