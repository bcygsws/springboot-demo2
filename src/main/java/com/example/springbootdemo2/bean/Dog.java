package com.example.springbootdemo2.bean;

public class Dog {
	private String name;
	private Integer age;
	// 快捷键alt+insert调出getter/setter代码片段


	@Override
	public String toString() {
		return "Dog{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
