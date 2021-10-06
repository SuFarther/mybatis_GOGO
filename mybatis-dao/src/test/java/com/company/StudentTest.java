package com.company;

import com.company.dao.StudentDao;
import com.company.dao.impl.StudentDaoImpl;
import com.company.domain.Student;
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
     * com.company.dao.StudentDao
     * StudentDao dao = new StudentDaoImpl();
     *
     * List<Student> students = dao.selectAllStudents(); 调用
     * 1、dao对象,类型是StudentDao,全限定名称是:  com.company.dao.StudentDao
     * 全限定名称和namespace是一样的
     *
     * 2、方法名称.selectAllStudents这个方法就是mapper文件中的id值selectStudents
     *
     *  3、通过dao中方法的返回值也可以确定Mybatis要调用SqlSession方法
     *   如果返回值是list,调用的是SqlSession.selectList()方法
     *   如果返回值int,或者非list的,看mapper文件中的标签是<insert>，<update>就会调用
     *   SqlSession的insert，update等方法
     *
     *   mybatis的动态代理: mybatis根据dao的方法调用,获取执行sql语句的信息
     *   mybatis根据你的dao接口,创建出一个dao接口的实现类,并创建这个类的对象
     *   完成SqlSession调用方法,访问数据库
     *
     */
    @Test
    public void selectTest(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectAllStudents();
        studentList.forEach(stu -> System.out.println("查询的学生: "+stu));
    }


    @Test
    public void addTest(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(2);
        student.setName("琪琪");
        student.setEmail("qq@qq.com");
        student.setAge(27);
        int result = dao.addStudent(student);
        System.out.println("增加"+result+"条数据成功");
    }

    @Test
    public void updateTest(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setName("猫咪");
        student.setEmail("mm@163.com");
        student.setAge(17);
        student.setId(2);
        int result = dao.updateStudentById(student);
        System.out.println("修改"+result+"条数据成功");
    }

    @Test
    public void deleteTest(){
        StudentDao dao =  new StudentDaoImpl();
        Student student = new Student();
        student.setId(2);
        int result = dao.deleteStudentsById(student);
        System.out.println("删除"+result+"条数据成功");
    }
}
