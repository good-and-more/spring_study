package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
//工厂静态方法实例化
public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
