package com.company;

import com.company.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.management.openmbean.SimpleType;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @version 1.0
 * @ClassName StudentTest
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月06日 14:42:42
 */
public class StudentTest {
    @Test
    public  void testInsert() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //默认是非自动提交事务
//        SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession = factory.openSession(true);
        String sqlId = "com.company.dao.StudentDao.insertStudent";
        Student student = new Student();
        student.setId(4);
        student.setName("小芳");
        student.setEmail("xf@qq.com");
        student.setAge(24);
        int result = sqlSession.insert(sqlId, student);
        //mybatis默认不是自动提交事务,所以在insert,update,delete要手动提交事务
//        sqlSession.commit();
        System.out.println("增加"+result+"条数据成功");
        sqlSession.close();
    }


    @Test
    public void testUpdate() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId = "com.company.dao.StudentDao.updateStudent";
        Student student = new Student();
        student.setName("艾虎");
        student.setEmail("ah@qq.com");
        student.setAge(29);
        student.setId(2);
        int result = sqlSession.update(sqlId,student);
        sqlSession.commit();
        System.out.println("修改"+result+"条数据成功");
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlId = "com.company.dao.StudentDao.deleteStudentById";
        Student student = new Student();
        student.setId(2);
        int result = sqlSession.delete(sqlId,student);
        sqlSession.commit();
        System.out.println("删除"+result+"条数据成功");
        sqlSession.close();
    }
}
