package cn.wengzi.aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志切面
 *
 * @Aspect : 表明该类是一个通知
 * @Componetn ：将该类加入Ioc容器中
 */
@Aspect
@Component
public class LoggerAspect {


    /**
     * 定义一个方法，用于声明切入点表达式。一般的，该方法中再不需要添加其他的代码
     * 使用@Pointcut 来声明切入点表达式
     * 后面的其他通知直接使用方法名直接引用方法名即可
     */
//    @Pointcut("execution(* cn.wengzi.aop.interfaces.impl.*.*(..))")
//    public void anyOldTransfer() {
//    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before(value = "execution(public int cn.wengzi.aop.interfaces.impl.CalImpl.*(..))")
    public void before(JoinPoint joinPoint) {
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(methodName + "方法的参数是：" + args);
    }


    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @After(value = "execution(public int cn.wengzi.aop.interfaces.impl.CalImpl.*(..))")
    public void after(JoinPoint joinPoint) {
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "方法执行完毕");
    }

    /**
     * 最终通知,return后执行
     *
     * @param joinPoint
     * @param result    目标方法执行之后返回的结果
     */
    @AfterReturning(value = "execution(public int cn.wengzi.aop.interfaces.impl.CalImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "方法的结果是" + result);
    }

    /**
     * 异常通知,目标方法抛出异常后执行
     *
     * @param joinPoint
     * @param exception 目标方法抛出异常的类型
     */
    @AfterThrowing(value = "execution(public int cn.wengzi.aop.interfaces.impl.CalImpl.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "方法抛出了异常" + exception);
    }


    /**
     * 环绕通知需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
     * 而且环绕通知必须有返回值，返回值即为目标方法的返回值
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "execution(public int cn.wengzi.aop.interfaces.impl.CalImpl.*(..))")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) {

        //获取方法名称
        String methodName = proceedingJoinPoint.getSignature().getName();
        //获取参数
        String args = Arrays.toString(proceedingJoinPoint.getArgs());

        Object result = null;

        //执行目标方法
        try {
            //前置通知
            System.out.println(methodName + "方法的参数是：" + args);
            result = proceedingJoinPoint.proceed();         //控制目标方法执行
        } catch (Throwable throwable) {

            //异常通知
            System.out.println(methodName + "方法抛出了异常:" + throwable.toString());
            throwable.printStackTrace();
        }

        //后置通知
        System.out.println(methodName + "方法执行完毕");
        return result; //目标方法的返回值
    }
}
