package spring.beans.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.autowrite.Address;
import spring.beans.autowrite.Person;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beansRelation.xml");
//		Address add = (Address) ctx.getBean("address1");

		Person p = (Person) ctx.getBean("person");
		System.out.println(p);
	}

}
