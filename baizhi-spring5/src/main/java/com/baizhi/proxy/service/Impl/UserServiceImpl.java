package com.baizhi.proxy.service.Impl;

import com.baizhi.proxy.User;
import com.baizhi.proxy.annotation.Log;
import com.baizhi.proxy.service.UserService;

public class UserServiceImpl implements UserService {
    @Log
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算 + DAO");
        //throw new RuntimeException("测试异常");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
