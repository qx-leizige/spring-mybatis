package cn.wengzi.ioc.test;

import cn.wengzi.ioc.entity.Collections;
import cn.wengzi.ioc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

    public static void TestCollections() {
        Collections collection = (Collections) context.getBean("collections");
        System.out.println(collection);
    }

    public static void TestStudent() {
        Student student = (Student) context.getBean("student4");
        System.out.println(student);
    }


    public static void main(String[] args) {
        TestStudent();
//        TestCollections();
    }
}
