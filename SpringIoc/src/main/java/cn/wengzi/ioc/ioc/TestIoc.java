package cn.wengzi.ioc.ioc;

import cn.wengzi.ioc.entity.Student;

/**
 * 自定义ApplicationContext和ClassPathXmlApplicationContext
 * 模拟Ioc实现
 */
public class TestIoc {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/Spring.xml");
        Student person = (Student) context.getBean("student1");
        System.out.println(person);
    }
}
