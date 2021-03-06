package com.company.dao;

import com.company.entity.Student;

import java.util.List;

/**
 * @author 数据库持久层对象
 * @version 1.0
 * @ClassName StudentDao
 * @company 公司
 * @Description StudentDao
 * @createTime 2021年10月05日 22:15:15
 */
public interface StudentDao {
    /**
     * 查询Student所有数据
     * @return selectStudents
     */
    List<Student> selectStudents();

    /**
     * 增加Student全部数据
     * @param student
     * @return  insertStudent
     */
    int insertStudent(Student student);


    /**
     * 修改Student数据
     * @param student
     * @return  updateStudent
     */
    int updateStudent(Student student);


    /**
     * 根据ID删除student数据
     * @param student
     * @return  deleteStudentById
     */
     int deleteStudentById(Student student);
}
