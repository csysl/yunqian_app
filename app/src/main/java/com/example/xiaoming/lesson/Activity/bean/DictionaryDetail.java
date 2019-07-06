package com.example.xiaoming.lesson.Activity.bean;

import java.io.Serializable;

public class DictionaryDetail {

    private static final long serialVersionUID = 1L;

    private Integer Id;
    private Integer DictionaryId;
    /**
     * 一类dictionary下唯一
     */
    private Integer ItemKey;
    private String ItemValue;
    private Boolean IsDefault;
    /**
     * 排序
     */
    private Integer Position;
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

    public Integer getDictionaryId() {
        return DictionaryId;
    }

    public void setDictionaryId(Integer DictionaryId) {
        this.DictionaryId = DictionaryId;
    }

    public Integer getItemKey() {
        return ItemKey;
    }

    public void setItemKey(Integer ItemKey) {
        this.ItemKey = ItemKey;
    }

    public String getItemValue() {
        return ItemValue;
    }

    public void setItemValue(String ItemValue) {
        this.ItemValue = ItemValue;
    }

    public Boolean isIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(Boolean IsDefault) {
        this.IsDefault = IsDefault;
    }

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer Position) {
        this.Position = Position;
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