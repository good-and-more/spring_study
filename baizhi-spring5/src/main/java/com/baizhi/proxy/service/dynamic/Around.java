package com.baizhi.proxy.service.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Around implements MethodInterceptor {
    //@Override
    //public Object invoke(MethodInvocation invocation) throws Throwable {
    //    //原始方法运行之前
    //    System.out.println("-----额外功能 log-----");
    //    Object ret = null;
    //    try {
    //        ret = invocation.proceed();//原始方法运行
    //    } catch (Throwable throwable) {
    //        System.out.println("-----原始方法抛出异常-----");
    //        throwable.printStackTrace();
    //    }
    //    //原始方法运行之后
    //    System.out.println("-----额外功能 在执行之后-----");
    //    return ret;
    //}

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("-----额外功能 log-----");
        Object ret = invocation.proceed();;
        return ret;
    }
}
