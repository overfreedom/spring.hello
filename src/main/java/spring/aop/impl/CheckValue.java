package spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) //切片的优先级 值越小优先级越高
@Aspect
@Component
public class CheckValue {

//	@Before("execution(* spring.aop.impl.ArithmeticCalculate.*(..))")
	@Before("spring.aop.impl.LoggingAspect.joinPointCutExpression()")  //重用其它包里的切片表达式
	public void checkValue(JoinPoint joinPoint) {
		System.out.println("--> check the args:"+ Arrays.asList(joinPoint.getArgs()));
	}
}
