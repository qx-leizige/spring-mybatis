package cn.wengzi;


import cn.wengzi.entity.Student;
import cn.wengzi.entity.StudentClass;
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
 * @date 2019/10/11 21:11
 * @Description Mybatis关联查询
 */
public class TestMybatis {
    public static void OneToOne() throws IOException {
        String mybatisConfig = "mybatis-config.xml";
        //读取mybatis-config.xml文件
        InputStream resourceAsStream = Resources.getResourceAsStream(mybatisConfig);
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建session实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.QueryStudentJoinStudentCardOneToOneByStuId(1);
        System.out.println(student);
    }

    public static void OneToMany() throws IOException {
        String mybatisConfig = "mybatis-config.xml";
        //读取mybatis-config.xml文件
        InputStream resourceAsStream = Resources.getResourceAsStream(mybatisConfig);
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建session实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<StudentClass> studentClasses = mapper.QueryStudentJoinStudentClassOneToManyByClassId(1);
        for (StudentClass studentClass : studentClasses) {
            System.out.println(studentClass);
        }
    }

    public static void main(String[] args) throws IOException {
//        OneToOne();
        OneToMany();
    }
}
