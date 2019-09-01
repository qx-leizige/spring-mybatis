package cn.wengzi.ioc.test;

import cn.wengzi.ioc.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("Factory-beans.xml");

    /**
     * 静态工厂 创建Car
     */
    public static void staticFactory() {
        Car car = (Car) context.getBean("staticFactoryCar");
        System.out.println(car);
    }

    /**
     * 实例工厂 创建Car
     */
    public static void instanceFactory() {
        Car car = (Car) context.getBean("instanceFactoryCar");
        System.out.println(car);
    }

    public static void main(String[] args) {
        staticFactory();
        instanceFactory();
    }
}
