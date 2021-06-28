package com.baizhi;

import com.baizhi.proxy.User;
import com.baizhi.proxy.service.OrderService;
import com.baizhi.proxy.service.UserService;
import com.baizhi.proxy.service.proxy.OrderServiceProxy;
import com.baizhi.proxy.service.proxy.UserServiceProxy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyTest {

    /**
     * 用于测试:静态代理
     */
    @Test
    void test1() {
        UserService userService = new UserServiceProxy();
        userService.login("suns", "123456");
        userService.register(new User());
        System.out.println("===================");

        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();
    }

    /**
     * 用于测试:动态代理
     */
    @Test
    void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextProxy.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.login("suns", "123456");
        userService.register(new User());
        //System.out.println("===========================");
        //OrderService orderService = ctx.getBean("orderService", OrderService.class);
        //orderService.showOrder();
    }

    /**
     * 用于测试:基于注解的面向切面编程
     */
    @Test
    void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextAspect.xml");
        com.baizhi.aspect.UserService  userService = ctx.getBean("userService", com.baizhi.aspect.UserService .class);
        //userService.login("suns", "123456");
        userService.register(new User());
    }
}
