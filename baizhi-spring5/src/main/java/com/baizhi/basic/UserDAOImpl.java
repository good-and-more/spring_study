package com.baizhi.basic;

public class UserDAOImpl implements UserDAO{
    @Override
    public void save(User user) {
        System.out.println("insert into user = " + user);
    }

    @Override
    public void queryUserByNameAndPassword(String username, String password) {
        System.out.println("login success, " + username + " and " + password);
    }
}
