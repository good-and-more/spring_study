package com.baizhi.proxy.service.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before1 implements MethodBeforeAdvice {
    /**
     * 需要把运行在原始方法执行之前运行的额外功能,写在before中
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("=======new new new new method before advice log==========");
    }
}
