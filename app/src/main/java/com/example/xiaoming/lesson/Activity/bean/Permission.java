package com.example.xiaoming.lesson.Activity.bean;

import java.io.Serializable;

public class Permission {

    private static final long serialVersionUID = 1L;

    private Integer Id;
    private String Name;
    /**
     * 菜单排序
     */
    private Integer Position;
    /**
     * 父节点ID
     */
    private Integer ParentId;
    /**
     * 等级
     */
    private Integer Level;
    /**
     * 链接
     */
    private String Router;
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

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer Position) {
        this.Position = Position;
    }

    public Integer getParentId() {
        return ParentId;
    }

    public void setParentId(Integer ParentId) {
        this.ParentId = ParentId;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer Level) {
        this.Level = Level;
    }

    public String getRouter() {
        return Router;
    }

    public void setRouter(String Router) {
        this.Router = Router;
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


    public String toString() {
        return "Permission{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Position=" + Position +
                ", ParentId=" + ParentId +
                ", Level=" + Level +
                ", Router='" + Router + '\'' +
                ", CreateDate='" + CreateDate + '\'' +
                ", CreateBy=" + CreateBy +
                ", ModifyDate='" + ModifyDate + '\'' +
                ", ModifyBy=" + ModifyBy +
                '}';
    }
}