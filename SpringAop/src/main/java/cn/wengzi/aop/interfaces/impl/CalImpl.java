package cn.wengzi.aop.interfaces.impl;

import cn.wengzi.aop.interfaces.Cal;
import org.springframework.stereotype.Component;

/**
 * 在每一个方法前面添加方法的参数
 * 后面添加方法的结果并输出
 */
@Component
public class CalImpl implements Cal {
    public int add(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

    public int sub(int num1, int num2) {
        int result = num1 - num2;
        return result;
    }

    public int mul(int num1, int num2) {
        int result = num1 * num2;
        return result;
    }

    public int div(int num1, int num2) {
        int result = num1 / num2;
        return result;
    }
}
