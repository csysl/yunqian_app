package com.example.xiaoming.lesson.Activity.bean;

import java.io.Serializable;

public class Role{

    private static final long serialVersionUID = 1L;

    private Integer Id;
    private String Name;
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

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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