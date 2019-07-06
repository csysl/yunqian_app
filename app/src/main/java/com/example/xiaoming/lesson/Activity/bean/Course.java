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
public class Course implements Serializable{




    private static final long serialVersionUID = 1L;

    private Integer Id;
    private String ClassName;
    private String CourseName;

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    private String Num;


    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    private User creater;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    /**
     * 所属学期
     */
    private String Semester;
    /**
     * 学习要求
     */
    private String Demand;
    /**
     * “教学进度”
     */
    private String Process;
    /**
     * 考试安排
     */
    private String Exam;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getDemand() {
        return Demand;
    }

    public void setDemand(String Demand) {
        this.Demand = Demand;
    }

    public String getProcess() {
        return Process;
    }

    public void setProcess(String Process) {
        this.Process = Process;
    }

    public String getExam() {
        return Exam;
    }

    public void setExam(String Exam) {
        this.Exam = Exam;
    }


    protected Serializable pkVal() {
        return this.Id;
    }

    public Course(Integer Id,String ClassName, String CourseName, User creater){
        this.Id = Id;
        this.ClassName = ClassName;
        this.CourseName = CourseName;
        this.creater = creater;
    }

    public Course() {
    }


}