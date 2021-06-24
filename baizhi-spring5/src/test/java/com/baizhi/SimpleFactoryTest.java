package com.baizhi;

import com.baizhi.basic.SimpleBeanFactory;
import com.baizhi.basic.User;
import com.baizhi.basic.UserService;
import org.junit.jupiter.api.Test;

public class SimpleFactoryTest {

    @Test
    public void test() {
        System.out.println("hello");
    }

    /**
     * 用于测试:工厂类解耦合的操作
     */
    @Test
    public void test1() {
        //UserService userService = new UserServiceImpl();
        UserService userService = SimpleBeanFactory.getUserService();
        userService.login("atguigu","123456");
        User user = new User("suns", "123456");
        userService.register(user);
    }

}
