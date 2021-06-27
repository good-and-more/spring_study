package com.baizhi;

import com.baizhi.basic.*;
import com.baizhi.life.Product;
import com.baizhi.scope.Account;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FactoryTest<test> {

    @Test
    public void test() {
        System.out.println("hello");
    }

    /**
     * 用于测试:工厂类解耦合的操作
     */
    @Test
    public void testSimpleFactory() {
        //UserService userService = new UserServiceImpl();
        UserService userService = (UserService) BeanFactory.getBean("userService");
        userService.login("mary","123");
        User user = new User("suns", "456");
        userService.register(user);
    }

    @Test
    public void testPerson() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println(person);
    }

    @Test
    public void testSpring1() {
        //1 获得Spring工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //2 通过工厂类获得对象
        //getBean有方法重载

        //Person person = (Person) ctx.getBean("person");
        //Person person = ctx.getBean("person", Person.class);

        //这要求配置文件中只有一个Person类
        //Person person = ctx.getBean(Person.class);

        //获取的是配置文件中所有的bean标签的id值
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        for (String beanDefinitionName: beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }

        //获取的是配置文件中指定类型的bean的id
//        String[] beanNamesForTypes = ctx.getBeanNamesForType(Person.class);
//        for (String beanNamesForType: beanNamesForTypes) {
//            System.out.println(beanNamesForType);
//        }

        //判断是否存在对应的bean标签,只能判断id
        boolean person2 = ctx.containsBeanDefinition("q");
        System.out.println(person2);
        //可以判断id和name
        boolean person21 = ctx.containsBean("q");
        System.out.println(person21);
    }

    @Test
    void test6() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Person p = (Person) ctx.getBean("jjj");
        System.out.println(p);
    }

    @Test
    void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person p = ctx.getBean("person", Person.class);
        //p.setId(1);
        //p.setName("suns");
        System.out.println(p);
    }

    @Test
    void test8() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = ctx.getBean("person", Person.class);

        String[] strs = person.getStrs();
        for (String str : strs) {
            System.out.println("str = " + str);
        }
        System.out.println("=========================================");

        Set<String> phones = person.getPhones();
        for (String phone : phones) {
            System.out.println("my phone number is " + phone);
        }
        System.out.println("=========================================");

        List<String> lists = person.getLists();
        for (String list : lists) {
            System.out.println("list = " + list);
        }
        System.out.println("=========================================");

        Map<String, String> maps = person.getMaps();
        Set<String> strings = maps.keySet();
        for (String string : strings) {
            System.out.println("key = " + string + ", value = " + maps.get(string));
        }
        System.out.println("=========================================");

        Properties props = person.getProps();
        Set<String> propertyNames = props.stringPropertyNames();
        for (String propertyName : propertyNames) {
            System.out.println("propertyName = " + propertyName + ", propertyValue = " + props.getProperty(propertyName));
        }
        System.out.println("=========================================");

        UserService userService = person.getUserService();
        userService.login("mary","123456");
        userService.register(new User("lucy","654321"));
    }

    /**
     * 用于测试构造注入
     */
    @Test
    void test11() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = ctx.getBean("customer", Customer.class);
        System.out.println(customer);
    }

    /**
     * 用于测试FactoryBea接口,后来又测试了配置文件参数化
     */
    @Test
    void test12() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextDb.xml");
        Connection connection = ctx.getBean("connection", Connection.class);
        System.out.println(connection);
    }

    /**
     * 用于测试实例工厂
     */
    @Test
    void test14() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection connection = ctx.getBean("conn", Connection.class);
        System.out.println(connection);
    }

    /**
     * 用于测试静态工厂
     */
    @Test
    void test15() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection connection = ctx.getBean("staticConn", Connection.class);
        System.out.println(connection);
    }

    /**
     * 用于测试简单对象的创建次数
     */
    @Test
    void test16() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account1 = ctx.getBean("account", Account.class);
        Account account2 = ctx.getBean("account", Account.class);
        System.out.println("account1 = " + account1);
        System.out.println("account2 = " + account2);
    }

    /**
     * 用于测试生命周期:对象初始化方法
     */
    @Test
    void test17() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = ctx.getBean("product", Product.class);
        ctx.close();
    }

    /**
     * 用于测试:自定义类型转换器
     */
    @Test
    void test18() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContextConverter.xml");
        com.baizhi.converter.Person person = ctx.getBean("person", com.baizhi.converter.Person.class);
        System.out.println("person birthday = " + person.getBirthday());
    }
}
