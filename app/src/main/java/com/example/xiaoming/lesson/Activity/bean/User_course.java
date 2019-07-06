package com.example.xiaoming.lesson.Activity.bean;

import java.io.Serializable;

public class User_course {

    private static final long serialVersionUID = 1L;

    private Integer Id;

    private Integer CourseId;

    private Integer UserId;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getCourseId() {
        return CourseId;
    }

    public void setCourseId(Integer CourseId) {
        this.CourseId = CourseId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    protected Serializable pkVal() {
        return this.Id;
    }

}