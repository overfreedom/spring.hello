package spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//创建HelloWorld 对象
//		HelloWorld hw = new HelloWorld();
		//为name属性赋值
//		hw.setName("mike");

		//1. 创建Spring的IOC容器对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");	
		//2. 从IOC容器对象中获取实例
//		HelloWorld hw = (HelloWorld)ctx.getBean("helloworld");
//		hw.Hello();
		ContructorTest ctt = (ContructorTest)ctx.getBean("contructortest1");
		System.out.println(ctt);
		ctt = (ContructorTest)ctx.getBean("contructortest2");
		System.out.println(ctt);
	}

}
