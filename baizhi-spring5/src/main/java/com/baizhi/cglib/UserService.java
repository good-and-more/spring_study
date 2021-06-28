package com.baizhi.cglib;

import com.baizhi.proxy.User;

public class UserService {
    public void register(User user) {
        System.out.println("UserService.register");
    }

    public void login(String name, String password) {
        System.out.println("UserService.login");
    }
}
