package com.baizhi;

import com.baizhi.basic.BeanFactory;
import com.baizhi.basic.Person;
import com.baizhi.basic.User;
import com.baizhi.basic.UserService;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    @Test
    public void test() {
        System.out.println("hello");
    }

    /**
     * 用于测试:工厂类解耦合的操作
     */
    @Test
    public void testSimpleFactory() {
        //UserService userService = new UserServiceImpl();
        UserService userService = (UserService) BeanFactory.getBean("userService");
        userService.login("mary","123");
        User user = new User("suns", "456");
        userService.register(user);
    }

    @Test
    public void testPerson() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println(person);
    }
}
