/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.springbootdemo2.demos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Controller
public class BasicController {

	// http://127.0.0.1:8080/hello?name=lisi
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(@RequestParam(name = "name", defaultValue = "unknown user") String name) {
		return "Hello " + name;
	}

	// http://127.0.0.1:8080/user
	@RequestMapping("/user")
	@ResponseBody
	public User user() {
		User user = new User();
		user.setName("theonefx");
		user.setAge(666);
		return user;
	}

	// http://127.0.0.1:8080/save_user?name=newName&age=11
	@RequestMapping("/save_user")
	@ResponseBody
	public String saveUser(User u) {
		return "user will save: name=" + u.getName() + ", age=" + u.getAge();
	}

	// http://127.0.0.1:8080/html
	@RequestMapping("/html")
	public String html() {
		return "index.html";
	}

	/*
	 * Model是模型，表示把数据放在返回的页面上
	 * @RequestParam(name = "name", defaultValue = "unknown user") String name,实际上是一个赋值的过程
	 * 注解@RequestParam将请求参数中的name、age求解出来，并分别赋给Stirng和Integer类型的name和age变量
	 *
	 *
	 * */
	@ModelAttribute
	public void parseUser(@RequestParam(name = "name", defaultValue = "unknown user") String name
			, @RequestParam(name = "age", defaultValue = "12") Integer age, User user) {
		/*以下代码，在处理没有传入name和age时，例如访问：http://127.0.0.1:8080/save_user，index.html页面中就会显示：user will save: name=zhangsan, age=18*/
		user.setName("zhangsan");
		user.setAge(18);
	}
}
// 注解@ModelAttribute
//   参考文档：https://blog.csdn.net/u010502101/article/details/78876295?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-4-78876295-blog-105740360.235^v43^control&spm=1001.2101.3001.4242.3&utm_relevant_index=7
//
//   执行时机；
//   运行http://127.0.0.1:8080/save_user后，控制视图方法saveUser响应该请求，但是在执行该方法之前会先执行@ModelAttribute标注的parseUser()方法

