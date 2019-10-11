package cn.wengzi;

import cn.wengzi.entity.Student;
import cn.wengzi.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wengzi
 * @date 2019/10/11 21:17
 * @Description Mybatis调用存储过程
 */
public class TestMyBatis2 {

    public static void findAll() throws IOException {
        String mybatisConfig = "mybatis-config.xml";
        //读取mybatis-config.xml文件
        InputStream resourceAsStream = Resources.getResourceAsStream(mybatisConfig);
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建session实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryStudentAll();
        students.forEach(student -> System.out.println(student));
    }

    public static void findById(Integer id) throws IOException {
        String mybatisConfig = "mybatis-config.xml";
        //读取mybatis-config.xml文件
        InputStream resourceAsStream = Resources.getResourceAsStream(mybatisConfig);
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建session实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentById(id);
        System.out.println(student);
    }

    public static void main(String[] args) throws IOException {
        findAll();
        findById(1);
    }
}
