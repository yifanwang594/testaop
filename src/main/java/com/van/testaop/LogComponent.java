package com.van.testaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: Van
 * @create: 2019-08-27 09:54
 * @description: Aop 切面
 * @program: testaop
 * @version: 1.0
 **/

@Component
@Aspect
public class LogComponent {
    //第一个*代表返回值任意 service包下面的任意类任意方法 两个点代表参数任意
    @Pointcut("execution(* com.van.testaop.service.*.*(..))")
    public void pc1() {
    }


    /**
     * @Author: Van
     * @Date: 2019/8/27
     * @Description:
     * @Param: [jp]  前置通知  切点
     * @return: void
     */
    @Before(value = "pc1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println("before=========" + name);
    }

    //后置通知
    @After(value = "pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println("after========" + name);
    }

    //返回通知
    @AfterReturning(value = "pc1()", returning = "result")
    public void afterreturn(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        System.out.println("afterreturn=====" + name + "result=====" + result);
    }

    //异常通知
    @AfterThrowing(value = "pc1()", throwing = "e")
    public void afterThrow(JoinPoint jp, Exception e) { //接受全部异常
        String name = jp.getSignature().getName();
        System.out.println("afterruturn======" + name + "e======" + e.getMessage());
    }

    //环绕通知
    @Around("pc1()")
    public Object around(ProceedingJoinPoint pp) throws Throwable { //接受全部异常
        Object proceed = pp.proceed();
        return proceed;
//        return "van";
    }

}
