package spring.beans.autowrite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.autowrite.Person;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beansAutoWrite.xml");
		Person p = (Person)ctx.getBean("person");
		System.out.println(p);
	}

}
