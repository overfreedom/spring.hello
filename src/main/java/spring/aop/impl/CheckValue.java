package spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) //��Ƭ�����ȼ� ֵԽС���ȼ�Խ��
@Aspect
@Component
public class CheckValue {

//	@Before("execution(* spring.aop.impl.ArithmeticCalculate.*(..))")
	@Before("spring.aop.impl.LoggingAspect.joinPointCutExpression()")  //���������������Ƭ���ʽ
	public void checkValue(JoinPoint joinPoint) {
		System.out.println("--> check the args:"+ Arrays.asList(joinPoint.getArgs()));
	}
}
