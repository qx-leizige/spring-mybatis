package cn.wengzi.aop.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 在CalImpl中,每一个方法前面和后面添加日志,不利于系统维护
 * 可以使用Aop进行优化,使用动态代理来实现。
 */
public class MyInvocationHandler implements InvocationHandler {

    //接收委托对象
    private Object object = null;

    //返回代理对象
    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "方法的参数是:" + Arrays.toString(args));
        Object result = method.invoke(this.object, args);
        System.out.println(method.getName() + "方法的输出结果是:" + result);
        return result;
    }
}
