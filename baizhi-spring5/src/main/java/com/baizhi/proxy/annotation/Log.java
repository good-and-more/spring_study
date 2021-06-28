package com.baizhi.proxy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//决定注解用在哪
@Retention(RetentionPolicy.RUNTIME)//决定注解在哪起作用,一般都写runtime
public @interface Log {
}
