package com.company.dao;

import com.company.domain.MyStudent;
import com.company.domain.Student;
import com.company.vo.QueryParamsVO;
import com.company.vo.ViewStudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName StudentDao
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月06日 21:42:42
 */
public interface StudentDao {

    /**
     * 通过Student的id查找
     * 一个简单类型的参数:
     *    简单类型: mybatis把java的基本数据类型和String都叫简单类型
     *    在mapper文件获取简单类型的一个参数的值,使用#{任意字符}
     * @param id
     * @return  Student selectStudentById
     */
    Student selectStudentById(Integer id);


    /**
     *   命名参数
     *  当Dao接口方法多个参数,需要通过名称使用参数,在方法形参前面加入@Param("自定义参数") 参数类型 名称
     *  mapper文件使用#{自定义参数}
     */
     List<Student> selectNameOrAgeParams(@Param("myName") String name, @Param("myAge") Integer age);


    /**
     * 对象传参
     * 多个参数,使用java对象作为接口方法中的参数
     */
     List<Student> selectParamNameOrParamAge(QueryParamsVO paramsVO);


    /**
     * 位置传参
     * 多个参数-简单类型的,按位置 传值
     * mybatis.3.4之前,使用#{0},#{1}
     * mybatis.3.4之后,使用#{arg0},#{arg1}
     * @param name
     * @param age
     * @return
     */
    List<Student> selectPosition(String name,Integer age);


    /**
     * 多个参数,使用Map存放多个值
     * @param map
     * @return List<Student>
     */
    List<Student> selectMap(Map<String,Object> map);

    /**
     * resultType结果类型,指sql语句执行完毕后,数据转为java对象
     *
     * @param id
     * @return  ViewStudentVO selectViewStudentVO
     */
    ViewStudentVO selectViewStudentVO(@Param("sid") Integer id);




    /**
     * resultType结果类型，也可以是1、类型的全限定名称 2、类型的别名, 例如 java.lang.Integer别名是int
     * @return   int selectCount
     */
    int selectCount();


    /***
     * 定义方法返回map
     * @param id
     * @return
     */
    Map<Object,Object> selectMapById(Integer id);


    /**
     * 使用resultMap映射关系
     * @return
     */
    List<Student>   selectAllStudent();


    /**
     * 解决列名和属性吗不同的问题
     * @return
     */
    List<MyStudent> selectMyStudent();


    /**
     * 解决列名和属性名不一样的问题
     * @return
     */
    List<MyStudent> selectMyStudentOfResultType();

    /**
     * 第一种模糊查询,在java代码指定 like的内容
     * @return  List<Student> selectLikeOne
     */
    List<Student> selectLikeOne(String name);


    /**
     * name就是李值,在mapper中拼接 like "%"李"%"
     * @param name
     * @return
     */
    List<Student> selectLikeTwo(String name);

}
