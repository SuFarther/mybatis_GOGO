package com.company.domain;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName MyStudent
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月07日 21:24:24
 */
public class MyStudent {
    private  Integer stuid;
    private  String  stuname;
    private String  stuemail;
    private String  stuage;

    public MyStudent(){

    }

    public MyStudent(Integer stuid, String stuname, String stuemail, String stuage) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stuemail = stuemail;
        this.stuage = stuage;
    }


    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuemail() {
        return stuemail;
    }

    public void setStuemail(String stuemail) {
        this.stuemail = stuemail;
    }

    public String getStuage() {
        return stuage;
    }

    public void setStuage(String stuage) {
        this.stuage = stuage;
    }


    @Override
    public String toString() {
        return "MyStudent{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stuemail='" + stuemail + '\'' +
                ", stuage='" + stuage + '\'' +
                '}';
    }
}
