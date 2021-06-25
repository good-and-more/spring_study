package com.baizhi;

import com.baizhi.basic.BeanFactory;
import com.baizhi.basic.Person;
import com.baizhi.basic.User;
import com.baizhi.basic.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
