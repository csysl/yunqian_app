package com.example.xiaoming.lesson.Activity.bean;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2019-05-11
 */
public class Department  {

    private static final long serialVersionUID = 1L;

    private Integer Id;
    private String Name;
    private Integer SchoolId;


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

    public Integer getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(Integer SchoolId) {
        this.SchoolId = SchoolId;
    }

    protected Serializable pkVal() {
        return this.Id;
    }

}