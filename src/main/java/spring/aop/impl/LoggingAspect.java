package spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.add(int,int))")
	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.*(int,int))")
	public void Logging(JoinPoint joinPoint) {
		String methonName = joinPoint.getSignature().getName();
		String args = Arrays.asList(joinPoint.getArgs()).toString();
		System.out.println(methonName + "方法被调用，参数为"+ args);						
	}
}
