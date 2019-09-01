package cn.wengzi.aop.interfaces;

/**
 * 计算器类,定义加减乘除方法
 */
public interface Cal {
    public int add(int num1, int num2);

    public int sub(int num1, int num2);

    public int mul(int num1, int num2);

    public int div(int num1, int num2);
}
