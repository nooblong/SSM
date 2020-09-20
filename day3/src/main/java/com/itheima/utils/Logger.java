package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {

    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printBeforeLog() {
        System.out.println("Logger类前置通知");
    }

    public void printAfterReturningLog() {
        System.out.println("Logger类return通知");
    }

    public void printAfterThrowingLog() {
        System.out.println("Logger类异常通知");
    }

    public void printAfterLog() {
        System.out.println("Logger类最终通知");
    }

    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object rtValue = null;
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println("Logger类环绕通知");
            rtValue = proceedingJoinPoint.proceed(args);
            System.out.println("Logger类环绕通知");
        } catch (Throwable throwable) {
            System.out.println("Logger类环绕通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("Logger类环绕通知");
        }
        return rtValue;
    }
}
