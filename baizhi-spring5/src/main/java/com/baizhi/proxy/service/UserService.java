package com.baizhi.proxy.service;

import com.baizhi.proxy.User;

public interface UserService {
    void register(User user);
    boolean login(String name, String password);
}
