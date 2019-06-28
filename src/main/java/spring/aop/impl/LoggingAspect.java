package spring.aop.impl;

import java.util.Arrays;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)  //�����Ƭ����1֮��ִ��
@Aspect
@Component
public class LoggingAspect {

	/**
	 * ����һ������ ���������������ʽ �÷����в��ò����κη���
	 * ʹ��Pointcut �������������ʽ
	 */
//	@Pointcut("execution(* spring.aop.impl.ArithmeticCalculate.*(..))")
	@Pointcut("execution(public int spring.aop.impl.ArithmeticCalculate.*(int,int))")
 	public void joinPointCutExpression() {}
	
	// ǰ��֪ͨ
//	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.add(int,int))")
//	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.*(int,int))")
 	@Before("joinPointCutExpression()")
	public void Logging(JoinPoint joinPoint) {
		String methonName = joinPoint.getSignature().getName();
		String args = Arrays.asList(joinPoint.getArgs()).toString();
		System.out.println(methonName + "���������ã�����Ϊ" + args);
	}

	// ����֪ͨ ����Ŀ�귽���Ƿ����쳣����ִ��
//	@After("execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))")
 	@After("joinPointCutExpression()")
	public void after(JoinPoint joinPoint) {
		String methonName = joinPoint.getSignature().getName();
		System.out.println(methonName + "�����ĺ���֪ͨ");
	}

	// ����֪ͨ
	@AfterReturning(value = "execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))", returning = "result")
	public void returnMethod(JoinPoint joinPoint, Object result) {
		String methonName = joinPoint.getSignature().getName();
		System.out.println(methonName + "�����ķ���֪ͨ" + "����ֵΪ��" + result);

	}

	// �쳣֪ͨ
	@AfterThrowing(value = "execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))", throwing = "ex")
	public void throwMethod(JoinPoint joinPoint, Exception ex) {
		String methonName = joinPoint.getSignature().getName();
		System.out.println(methonName + "�������쳣֪ͨ" + "�쳣Ϊ��" + ex);
	}

	// ����֪ͨ�� �൱�ڶ�̬�����ʵ��
//	@Around("execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))")
 	@Around("joinPointCutExpression()")
	public Object arroundMethod(ProceedingJoinPoint pjp) {
		Object result = null;
		try {
			String methonName = pjp.getSignature().getName();
			String args = Arrays.asList(pjp.getArgs()).toString();
			System.out.println("ǰ��֪ͨ" + methonName + "  " + args);
			result = pjp.proceed();
			System.out.println("����֪ͨ");
		} catch (Throwable e) {
			System.out.println("�쳣֪ͨ" + e);
		} finally {
			System.out.println("����֪ͨ");
		}
		return result;
	}
}
