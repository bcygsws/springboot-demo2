package com.example.springbootdemo2;

import com.example.springbootdemo2.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/*
 *@SpringBootTest
 * 可以在测试期间，类似编码一样，自动注入到容器的功能
 *
 * @RunWith(SpringRunner.class)
 * 单元测试使用Spring的驱动器来跑，而不使用JUnit
 *
 * @AutoWired wired adj.连线的，联网的，兴奋不安的
 * v.wire的过去式，使……连线，给……接通电源
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootDemo1ApplicationTests {
	@Autowired
	Person person;

	// @Autowired注解，注入ioc容器类，实例化ioc容器
	@Autowired
	ApplicationContext ioc;

	@Test
	public void testHelloService() {
		// ioc容器中是否包含bean的方法，返回布尔值
		// helloService,beans.xml文件中bean标签里id属性值
		boolean b = ioc.containsBean("helloService");
		// 打印这个 布尔类型变量
		// 1.1 没有添加@ImportResource注解，使得Spring Boot的配置文件beans.xml生效，b的值打印false;表示Spring Boot里还没有这个配置文件
		// 1.2 需要将这个注解@ImportResource，加在一个配置类上；我们就将它加在主配置类上（com.example.springbootdemo1.SpringbootDemo1Application）
		// 1.3 在主配置类上，添加@ImportResources注解以后，重新运行观察该方法的返回值变成了true

		System.out.println(b);
	}


	@Test
	void contextLoads() {
		// 输出一下，要测试的person对象
		System.out.println(person);
	}

}
