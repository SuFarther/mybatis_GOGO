package com.company.dao;


import com.company.domain.Student;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName StudentDao
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月06日 21:42:42
 */
public interface StudentDao {

    /**
     * 动态sql,使用java对象作为参数
     * @param student
     * @return   List<Student>
     */
    List<Student> selectStudentIf(Student student);


    /**
     * <where>用来包含多个<if>的,当多个if有一个成立的,<where>会自动增加一个where关键字,并去掉if多余的and,or等
     * @param student
     * @return List<Student>
     */
    List<Student> selectStudentWhere(Student student);


    /**
     * for each循环遍历方式一 属性id
     * @param idList
     * @return
     */
    List<Student> selectForeachById(List<Integer> idList);


    /**
     * for each循环遍历方式二 遍历对象
     * @param stuList
     * @return
     */
    List<Student> selectForeachByStudent(List<Student> stuList);


    /**
     * 使用PageHelper分页数据
     */
    List<Student> selectAll();
}
