package spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("AOPImpl.xml");
		ArithmeticCalculate arithmeticCalculate = (ArithmeticCalculate) ctx.getBean("arithmeticCalculate");
		System.out.println(arithmeticCalculate.add(1, 2));
		System.out.println(arithmeticCalculate.mul(4, 8));
		System.out.println(arithmeticCalculate.div(2, 0));
	}

}
