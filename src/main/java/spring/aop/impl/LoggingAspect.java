package spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	//前置通知
//	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.add(int,int))")
	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.*(int,int))")
	public void Logging(JoinPoint joinPoint) {
		String methonName = joinPoint.getSignature().getName();
		String args = Arrays.asList(joinPoint.getArgs()).toString();
		System.out.println(methonName + "方法被调用，参数为"+ args);						
	}
	
	
	//后置通知 无论目标方法是否有异常都会执行
	@After("execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))")
	public void after(JoinPoint joinPoint) {
		String methonName = joinPoint.getSignature().getName();
		System.out.println(methonName +"方法的后置通知");
	}
	
}

