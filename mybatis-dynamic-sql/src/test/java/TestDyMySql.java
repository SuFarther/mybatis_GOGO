import com.company.dao.StudentDao;
import com.company.domain.Student;
import com.company.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}
