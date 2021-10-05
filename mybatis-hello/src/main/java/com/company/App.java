package com.company;


import com.company.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 苏东坡
 * Hello world!
 *
 * 说下坑点:
 *   <groupId>com.company</groupId>
 *   <artifactId>mybatis-hello</artifactId>
 *   <version>1.0-SNAPSHOT</version>
 *   后面要加一个语句<packaging>jar</packaging>
 *   要不打包会出错,少一个mybatis.xml
 *
 *  打包时候install之前记得在pom中加入
 *  <build>
 *      加载xml里面的代码
 *  </build>
 *
 *  清理maven下的target用clean命令，打包时候记得看打包后的配置文件是否包含
 *  maven下的install会出现target-classes-包名就会出现mybatis.xml,不行的话多试几遍,clean----install直到引入mybatis.xml为止
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称, 从类路径的根开始（target/classes）
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //6.【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "com.company.dao.StudentDao.selectStudents";
        //7. 重要】执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
         studentList.forEach(stu -> System.out.println("查询的学生:"+stu));
        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
