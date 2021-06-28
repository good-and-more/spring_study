package com.baizhi;

import com.baizhi.proxy.User;
import com.baizhi.proxy.service.OrderService;
import com.baizhi.proxy.service.UserService;
import com.baizhi.proxy.service.proxy.OrderServiceProxy;
import com.baizhi.proxy.service.proxy.UserServiceProxy;
import org.junit.jupiter.api.Test;

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
}
