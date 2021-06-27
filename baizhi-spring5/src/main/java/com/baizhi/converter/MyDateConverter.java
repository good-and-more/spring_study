package com.baizhi.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConverter implements Converter<String, Date> {//泛型,原始类型  转换类型

    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * convert方法作用,String->Date
     * SimpleDateFormat sdf = new SimpleDateFormat();
     * sdf.parse(String)
     * @param source 配置文件中的日期字符串
     * return 返回后,spring自动为birthday属性进行注入
     */
    @Override
    public Date convert(String source) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
