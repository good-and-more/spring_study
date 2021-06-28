package com.baizhi.proxy.service.proxy;

import com.baizhi.proxy.User;
import com.baizhi.proxy.service.Impl.UserServiceImpl;
import com.baizhi.proxy.service.UserService;

public class UserServiceProxy implements UserService {

    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        System.out.println("---log---register---");
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("---log---login---");
        return userService.login(name, password);
    }
}
