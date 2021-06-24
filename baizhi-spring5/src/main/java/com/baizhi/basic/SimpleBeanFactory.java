package com.baizhi.basic;

import java.io.InputStream;
import java.util.Properties;

public class SimpleBeanFactory {

    private static Properties env = new Properties();

    static {
        try {
            //第一步 获得IO输入流
            InputStream inputStream = SimpleBeanFactory.class.getResourceAsStream("/applicationContext.properties");
            //第二步 文件内容封装到env集合中
            env.load(inputStream);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象的创建方法
     * 1.正射
     * 2.反射
     */
    public static UserService getUserService() {
        //return new UserServiceImpl();
        UserService userService = null;
        try {
            Class<?> clazz = Class.forName(env.getProperty("userService"));
            userService = (UserService) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return userService;
    }

    public static UserDAO getUserDAO() {
        UserDAO userDAO = null;
        try {
            Class<?> clazz = Class.forName(env.getProperty("userDAO"));
            userDAO = (UserDAO) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return  userDAO;
    }
}
