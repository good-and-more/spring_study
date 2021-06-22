package com.baizhi.basic;

public class UserServiceImpl implements UserService{
    @Override
    public void register(User user) {
        System.out.println("register success, " + user.getUsername() + " and " + user.getPassword());
    }

    @Override
    public void login(String username, String password) {
        System.out.println("login success, " + username + " and " + password);
    }
}
