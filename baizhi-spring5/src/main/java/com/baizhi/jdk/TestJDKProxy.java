package com.baizhi.jdk;

import com.baizhi.proxy.User;
import com.baizhi.proxy.service.Impl.UserServiceImpl;
import com.baizhi.proxy.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-----proxy log-----");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };
        //2.jdk创建动态代理
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(), userService.getClass().getInterfaces(), handler);
        userServiceProxy.register(new User());
    }
}
