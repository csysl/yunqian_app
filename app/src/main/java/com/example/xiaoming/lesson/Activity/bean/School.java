package com.example.xiaoming.lesson.Activity.bean;

import java.io.Serializable;

public class School {

    private static final long serialVersionUID = 1L;

    private Integer Id;
    private String Name;


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

    protected Serializable pkVal() {
        return this.Id;
    }

}