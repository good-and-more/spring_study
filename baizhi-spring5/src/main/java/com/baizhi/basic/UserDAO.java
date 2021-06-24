package com.baizhi.basic;

public interface UserDAO {
    void save(User user);

    void queryUserByNameAndPassword(String username, String password);
}
