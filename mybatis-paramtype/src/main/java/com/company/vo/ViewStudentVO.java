package com.company.vo;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName ViewStudentVO
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月07日 15:13:13
 */
public class ViewStudentVO {
    private Integer id;
    private String name;

    public ViewStudentVO(){

    }

    public ViewStudentVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ViewStudentVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
