package com.example.springbootdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @ImportResource是后来加的，使得spring boot的配置文件beans.xml生效
// @ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
// 主配置类
public class SpringbootDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo1Application.class, args);
	}

}
/*
 * 一、@场景启动器 spring-boot-starter：spring boot的场景启动器
 * 1.1 spring-boot-starter-web
 * 其作用是，帮助我们导入web模块正常运行时依赖的组件
 *
 * 1.2 实际上，spring boot将所有的功能场景都抽象出来，做成一系列的starters（启动器）,只需要要在项目中引入，这些starters相关场景的依赖就会导入进来；
 * 需要什么功能，就导入什么场景启动器
 *
 * 二、@SpringBootApplication这个注解很重要，它标注了一个类是Spring Boot的主配置类，指示当前应用是一个spring boot应用；不能被注释掉，若注释掉代码就将报错
 * 按住CTRL,并点击@SpringBootApplication
 *
 * 三、@SpringBootConfiguration是Spring Boot的配置类
 * 标注在某个类上，表示这是Spring Boot的一个配置类
 * @Configuration配置类上来标注这个注解
 * 配置类-配置文件，也是容器中的一个组件 @Component
 *
 * 四、@EnableAutoConfiguration
 * 以前我们需要配置的东西，Spring Boot帮我们自动配置；EnableAutoConfiguration告诉Spring Boot开启自动配置功能，这样自动配置功能才能生效
 * @AutoConfigurationPackage
 * @Import({AutoConfigurationImportSelector.class})
 * public @interface EnableAutoConfiguration {
 * Spring Boot的底层注解，给容器中导入一个组件，组件的名称由AutoConfigurationImportSelector.class传入
 *
 * 4.1 @AutoConfigurationPackage将主配置类（@SpringBootApplication）所在包和其中的所有子包中的组件，都扫描进Spring容器中
 * 4.2 AutoConfigurationImportSelector.class
 * AutoConfigurationImportSelector会向容器中导入非常多的自动配置类，并导入某个场景所需要的所有组件，并完成这些组件的配置;
 * 有自动配置类，就可以免去手动添加配置和注入功能组件等工作
 *
 * 五、Spring Boot配置文件
 * 配置文件名称是固定的，可以作为项目的全局配置文件
 * main/resources/application.properties
 * main/resources/application.yml或者main/resources/application.yaml
 *
 * 5.1 yml文件，是YAML文件（读作亚马尔）
 * YAML:YAML Ain't Markup Language,双关的
 * YAML A Markup Language YAML是标记语言
 * YAML isn't Markup Language YAML不是标记语言
 *
 * 5.2 YAML以数据为中心，是比xml和json更适合做配置文件
 * application.yml文件中
 * server:
 * port: 8080
 *
 * application.properties
 * server.port=8080
 *
 * 以前的xml文件写法：（大量的代码都浪费在写标签上了）
 * <server>
        <port>8080</port>
 * </server>
 *
 * YAML语法规则
 * 5.2.1 以空格表示键值对
 * 例如  k:(空格)value值  空格不能少
 * 5.2.2 以前面的任意个空格作为层级关系，空格是几个无所谓，空格个数相同就表示是同一层级
 * server:
 *     port: 8080
 *     path: /hello
 * 注：port和path前面是server的子层级，port和path在同一层级
 * 5.2.3 属性和值，大小写敏感
 *
 * YAML的值
 * 1.字面量：（包括数字、字符串和布尔类型等）
 * 其中字符串，一般不适用单引号或者双引号；如果使用了单引号或者双引号，它们表示的意思不同；
 * a.对于单引号：它会转义特殊字符（将特殊字符\n作为普通字符输出了）
 * 例如：
 * name: 'zhangsan \n lisi'
 * 输出结果就是:
 * zhangsan \n lisi
 * b.对于双引号：它不会转义特殊字符，会按照她本来的含义执行
 * 例如：
 * name: "zhangsan \n lisi"
 * 输出结果是：
 * zhangsan
 * lisi
 *
 * 2.对象（Map）键值对：
 * 对象还是k: v 的方式;属性和值，在下面的行写，但是注意缩进（空格来控制）
 * 定义一个对象friends,{name: zhangsan,age: 18}
 * 2.1 对象分行写法
 * friends:
 *    name: zhangsan
 *    age: 18
 * 2.2 对象，行内写法，对象名和键值对在同一行
 * friends: {name: zhangsan,age: 18}
 *
 * 3.数组（包括List和Set等）
 * -（空格）元素，短横线空格元素的方式
 * 3.1 分行写法
 * pet:
 *  - pig
 *  - dog
 *  - cat
 *
 * 3.2 行内写法
 * pet: [pig,dog,cat]
 *
 *
 *
 */