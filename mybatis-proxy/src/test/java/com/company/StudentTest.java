package com.company;

import com.company.dao.StudentDao;
import com.company.domain.Student;
import com.company.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @version 1.0
 * @ClassName StudentTest
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月06日 16:45:45
 */
public class StudentTest {


    /**
     *
     * 使用mybatis动态代理机制,使用SqlSession.getMapper(dao接口)
     * getMapper 能获取dao接口对于的实现类对象
     *
     */
    @Test
    public void selectTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectAllStudents();
        studentList.forEach(stu -> System.out.println("查询的学生: "+stu));
        MybatisUtils.closeSqlSession();
    }


    @Test
    public void addTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession2();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(2);
        student.setName("小明");
        student.setEmail("xm@qq.com");
        student.setAge(30);
        int result = dao.addStudent(student);
        System.out.println("增加"+result+"条数据成功");
        MybatisUtils.closeSqlSession();
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession2();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("猫咪");
        student.setEmail("mm@163.com");
        student.setAge(17);
        student.setId(2);
        int result = dao.updateStudentById(student);
        System.out.println("修改"+result+"条数据成功");
        MybatisUtils.closeSqlSession();
    }

    @Test
    public void deleteTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession2();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(2);
        int result = dao.deleteStudentsById(student);
        System.out.println("删除"+result+"条数据成功");
        MybatisUtils.closeSqlSession();
    }
}
