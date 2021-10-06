package com.company.dao.impl;

import com.company.dao.StudentDao;
import com.company.domain.Student;
import com.company.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName StudentDaoImpl
 * @company 公司
 * @Description StudentDao实现类接口
 * @createTime 2021年10月06日 16:40:40
 */
public class StudentDaoImpl implements StudentDao {


    @Override
    public List<Student> selectAllStudents() {

        //创建SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId ="com.company.dao.StudentDao.selectAllStudents";
        //执行sql语句,使用sqlSession方法
        List<Student> students = sqlSession.selectList(sqlId);
        MybatisUtils.closeSqlSession();
        return students;
    }

    @Override
    public int addStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession2();
        String sqlId ="com.company.dao.StudentDao.addStudent";
        int result = sqlSession.insert(sqlId, student);
        MybatisUtils.closeSqlSession();
        return result;
    }

    @Override
    public int updateStudentById(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession2();
        String sqlId ="com.company.dao.StudentDao.updateStudentById";
        int result = sqlSession.update(sqlId, student);
        MybatisUtils.closeSqlSession();
        return result;
    }

    @Override
    public int deleteStudentsById(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession2();
        String sqlId ="com.company.dao.StudentDao.deleteStudentsById";
        int result = sqlSession.delete(sqlId, student);
        MybatisUtils.closeSqlSession();
        return result;
    }
}
