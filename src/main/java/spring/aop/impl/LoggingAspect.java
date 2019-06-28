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

	//ǰ��֪ͨ
//	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.add(int,int))")
	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.*(int,int))")
	public void Logging(JoinPoint joinPoint) {
		String methonName = joinPoint.getSignature().getName();
		String args = Arrays.asList(joinPoint.getArgs()).toString();
		System.out.println(methonName + "���������ã�����Ϊ"+ args);						
	}
	
	
	//����֪ͨ ����Ŀ�귽���Ƿ����쳣����ִ��
	@After("execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))")
	public void after(JoinPoint joinPoint) {
		String methonName = joinPoint.getSignature().getName();
		System.out.println(methonName +"�����ĺ���֪ͨ");
	}
	
}

