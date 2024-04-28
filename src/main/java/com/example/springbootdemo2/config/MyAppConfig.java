package com.example.springbootdemo2.config;

import com.example.springbootdemo2.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 表示当前类是一个配置类，类似之前的配置文件beans.xml
 *
 */
@Configuration
public class MyAppConfig {
	/*
	 *
	 * @Bean注解的作用是：
	 * 将方法的返回值添加到容器中，容器中这个id值，默认就是方法名helloService
	 *
	 * 此时，testHelloService()方法，调用后，打印b的值就是true
	 *
	 */
	@Bean
	public HelloService helloService() {
		return new HelloService();

	}
}
