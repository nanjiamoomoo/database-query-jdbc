package com.project.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoadTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream inputStream = PropertyLoadTest.class.getResourceAsStream("/jdbc.properties");// 获取相对路径
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String property = properties.getProperty("driver");
        System.out.println(property);
    }
}
