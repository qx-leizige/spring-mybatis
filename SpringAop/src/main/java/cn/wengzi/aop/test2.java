package cn.wengzi.aop;

import cn.wengzi.aop.interfaces.Cal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用Spring Aop
 */
public class test2 {
    public static void main(String[] args) {

        //1.加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("/Spring.xml");
        //2.获取代理对象,代理对象的名称是 类名首字母小写
        Cal proxy = (Cal) context.getBean("calImpl");
        proxy.add(1, 1);
        proxy.sub(2, 1);
        proxy.mul(2, 5);
        proxy.div(6, 0);
    }
}
