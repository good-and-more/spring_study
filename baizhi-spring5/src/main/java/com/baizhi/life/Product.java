package com.baizhi.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean, DisposableBean {
//public class Product {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }

    public Product() {
        System.out.println("Product.product");
    }

    public void myInit() {
        System.out.println("my init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destory");
    }

    public void myDestory() throws Exception {
        System.out.println("Product.myDestory");
    }
}
