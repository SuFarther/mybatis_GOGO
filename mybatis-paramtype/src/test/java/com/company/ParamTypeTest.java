package com.company;

import com.company.dao.StudentDao;
import com.company.domain.Student;
import com.company.utils.MybatisUtils;
import com.company.vo.QueryParamsVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName ParamTypeTest
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月06日 21:58:58
 */
public class ParamTypeTest {
    @Test
    public void testSelectStudentById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1001);
        System.out.println("学生信息:"+student);
        MybatisUtils.closeSqlSession();
    }


    @Test
    public void testSelectNameOrAgeParams(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectNameOrAgeParams("赵六", 20);
        for (Student stu: students){
            System.out.println("学生的信息:"+stu);
        }
        MybatisUtils.closeSqlSession();
    }


    @Test
    public void testSelectParamNameOrParamAge(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParamsVO paramsVO = new QueryParamsVO();
        paramsVO.setParamName("张三");
        paramsVO.setParamAge(20);
        dao.selectParamNameOrParamAge(paramsVO);
        MybatisUtils.closeSqlSession();
    }

    @Test
    public void testSelectPosition(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectPosition("赵六", 20);
        for (Student stu: students){
            System.out.println("学生的信息:"+stu);
        }
        MybatisUtils.closeSqlSession();
    }

    
    @Test
    public void testSelectMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("myName","张三");
        data.put("myAge",20);
        List<Student> students = dao.selectMap(data);
        for (Student stu: students){
            System.out.println("学生的信息:"+stu);
        }
        MybatisUtils.closeSqlSession();
    }
}
