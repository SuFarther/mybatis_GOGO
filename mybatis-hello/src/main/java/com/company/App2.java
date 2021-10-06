package com.company;


import com.company.entity.Student;
import com.company.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName App2
 * @company 公司
 * @Description 使用mybatis工具类
 * @createTime 2021年10月06日 15:44:44
 */
public class App2 {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.company.dao.StudentDao.selectStudents";
        //7. 重要】执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        studentList.forEach(stu -> System.out.println("查询的学生:"+stu));
        //9.关闭SqlSession对象
        MybatisUtils.closeSqlSession();
    }
}
