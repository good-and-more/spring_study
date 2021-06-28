package com.baizhi.aspect;

import com.baizhi.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceImpl implements UserService, ApplicationContextAware {
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("sunsun", "123456");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return false;
    }

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
