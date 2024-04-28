package com.example.springbootdemo2.service;

/**
 * @ 创建组件HelloService
 * 在测试类中，观察它是否自动在ioc容器中？（没有自动在，而是需要注解@ImportResource使其生效）
 * 一、创建beans.xml文件，指定class和id属性
 * 二、在测试类 com.example.springbootdemo1.SpringbootDemo1ApplicationTest 里，
 * 2.1 声明一个ioc容器
 * 2.2 ioc.contiansBean(bean.xml文件中的id属性值)
 */
public class HelloService {
}
