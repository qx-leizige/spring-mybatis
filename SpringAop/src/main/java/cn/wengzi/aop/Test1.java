package cn.wengzi.aop;

import cn.wengzi.aop.interfaces.Cal;
import cn.wengzi.aop.interfaces.impl.CalImpl;
import cn.wengzi.aop.utils.MyInvocationHandler;

/**
 * 自定义动态代理执行目标方法
 */
public class Test1 {
    public static void main(String[] args) {
        Cal cal = new CalImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Cal bind = (Cal) myInvocationHandler.bind(cal);
        bind.add(1, 2);
        bind.sub(2, 1);
        bind.mul(2, 5);
        bind.div(6, 2);
    }
}
