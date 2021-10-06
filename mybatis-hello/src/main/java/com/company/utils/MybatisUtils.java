package com.company.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName MybatisUtils
 * @company 公司
 * @Description MybatisUtils工具类
 * @createTime 2021年10月06日 15:35:35
 */
public class MybatisUtils {

    public static SqlSessionFactory factory = null;
    public static SqlSession sqlSession = null;

    static {
        String config = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建SqlSession对象方法
     * @return sqlSession
     */
    public static SqlSession getSqlSession(){
        sqlSession = null;
        if(factory !=null){
            sqlSession = factory.openSession();
        }
        return  sqlSession;
    }

    public static  void closeSqlSession(){
        sqlSession.close();
    }
}
