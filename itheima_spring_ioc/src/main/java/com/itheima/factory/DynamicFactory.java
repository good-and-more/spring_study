package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
//工厂实例方法实例化
public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
