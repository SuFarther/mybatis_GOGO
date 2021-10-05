package com.company.po;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName StudentPO
 * @company 公司
 * @Description StudentPO实体类,对应数据库里面的字段
 * @createTime 2021年10月05日 22:09:09
 */
public class StudentPO {
    private  Integer id;
    private  String name;
    private  String email;
    private  Integer age;

    public StudentPO(){

    }

    public StudentPO(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
