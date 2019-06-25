package spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//����HelloWorld ����
//		HelloWorld hw = new HelloWorld();
		//Ϊname���Ը�ֵ
//		hw.setName("mike");

		//1. ����Spring��IOC��������
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");	
		//2. ��IOC���������л�ȡʵ��
//		HelloWorld hw = (HelloWorld)ctx.getBean("helloworld");
//		hw.Hello();
		ContructorTest ctt = (ContructorTest)ctx.getBean("contructortest1");
		System.out.println(ctt);
		ctt = (ContructorTest)ctx.getBean("contructortest2");
		System.out.println(ctt);
	}

}
