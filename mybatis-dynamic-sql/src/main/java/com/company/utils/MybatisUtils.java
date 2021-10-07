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
 * @createTime 2021年10月06日 16:19:19
 */
public class MybatisUtils {

    public static  SqlSessionFactory factory = null;
    public static  SqlSession session = null;

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
     * 创建sqlSession方法
     */
     public static SqlSession getSqlSession(){
         if(factory!=null){
             session = factory.openSession();
         }
         return session;
     }

    /**
     * 创建sqlSession自动提交事务的方法
      * @return
     */
    public static SqlSession getSqlSession2(){
        if(factory!=null){
            session = factory.openSession(true);
        }
        return session;
    }


    /**
     * 关闭session的方法
     */
    public static  void closeSqlSession(){
        session.close();
    }
}
