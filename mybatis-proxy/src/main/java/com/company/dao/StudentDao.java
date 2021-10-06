package com.company.dao;

import com.company.domain.Student;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName StudentDao
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月06日 16:16:16
 */
public interface StudentDao {
    /**
     * 查询所有Student数据
     * @return  selectAllGoodStudents
     */
    List<Student> selectAllStudents();


    /**
     * 增加Student数据
     * @param  student
     *  @return  int addStudent
     */
    int addStudent(Student student);



    /**
     * 修改student数据
     * @param  student
     *  @return  int updateStudentById
     */
    int updateStudentById(Student student);


    /**
     * 删除student数据
     * @param  student
     *  @return  int deleteStudentsById
     */
    int deleteStudentsById(Student student);
}
