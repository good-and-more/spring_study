package com.baizhi.cglib;

import com.baizhi.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglibProxy {
    public static void main(String[] args) {
        UserService userService = new UserService();
        /*
            Proxy.newProxyInstance(classloader,interfaces,InvocationHandler)

            Enhancer.setClassLoader();
            Enhancer.setSuperclass();
            Enhancer.setCallback(); -> MethodInterceptor(cglib)
            Enhancer.create();
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(TestCglibProxy.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());
        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("---cglib log---");
                Object ret = method.invoke(userService, objects);
                return ret;
            }
        };
        enhancer.setCallback(interceptor);
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("suns", "123456");
        userServiceProxy.register(new User());
    }
}
