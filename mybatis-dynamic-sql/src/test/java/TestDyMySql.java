import com.company.dao.StudentDao;
import com.company.domain.Student;
import com.company.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @ClassName TestDyMySql
 * @company 公司
 * @Description TODO
 * @createTime 2021年10月07日 22:08:08
 */
public class TestDyMySql {


    @Test
    public void testSelectStudentIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student  student = new Student();
        student.setName("李四");
        student.setAge(20);
        List<Student> students = dao.selectStudentIf(student);
        students.forEach(stu-> System.out.println("学生:"+stu));
        MybatisUtils.closeSqlSession();
    }


    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student  student = new Student();
        student.setName("李四");
        student.setAge(20);
        List<Student> students = dao.selectStudentWhere(student);
        students.forEach(stu-> System.out.println("学生:"+stu));
        MybatisUtils.closeSqlSession();
    }


    @Test
    public void testSelectForeachById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(1002);
        List<Student> students = dao.selectForeachById(list);
        students.forEach(stu-> System.out.println("学生:"+stu));
        MybatisUtils.closeSqlSession();
    }


    @Test
    public void testSelectForeachByStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student>  studentList =  new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("赵六");
        studentList.add(student1);

        student1 = new Student();
        student1.setId(3);
        student1.setName("小芳");
        studentList.add(student1);

        student1 = new Student();
        student1.setId(1002);
        student1.setName("王五");
        studentList.add(student1);

        List<Student> students = dao.selectForeachByStudent(studentList);
        students.forEach(stu-> System.out.println("学生:"+stu));
        MybatisUtils.closeSqlSession();
    }
}
