package com.example.xiaoming.lesson.Activity.bean;

import java.io.Serializable;

public class User extends Entity implements Serializable {

    public User(String Name, String Phone , String No){
        this.Name = Name;
        this.Phone = Phone;
        this.No = No;
    }
    public User(){

    }

    private static final long serialVersionUID = 1L;

    private Integer Id;
    /**
     * 学号和工号
     */
    private String No;
    private String Name;
    /**
     * 角色
     */
    private Integer RoleId;
    private String Sex;
    private String Phone;
    private String Email;
    private  Integer DepartmentId;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Password;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String No) {
        this.No = No;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer RoleId) {
        this.RoleId = RoleId;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Integer getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        DepartmentId = departmentId;
    }
}