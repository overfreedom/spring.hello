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

@Order(2)  //这个切片会再1之后执行
@Aspect
@Component
public class LoggingAspect {

	/**
	 * 定义一个方法 用于声明切入点表达式 该方法中不用插入任何方法
	 * 使用Pointcut 来声明切入点表达式
	 */
//	@Pointcut("execution(* spring.aop.impl.ArithmeticCalculate.*(..))")
	@Pointcut("execution(public int spring.aop.impl.ArithmeticCalculate.*(int,int))")
 	public void joinPointCutExpression() {}
	
	// 前置通知
//	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.add(int,int))")
//	@Before("execution(public int spring.aop.impl.ArithmeticCalculate.*(int,int))")
 	@Before("joinPointCutExpression()")
	public void Logging(JoinPoint joinPoint) {
		String methonName = joinPoint.getSignature().getName();
		String args = Arrays.asList(joinPoint.getArgs()).toString();
		System.out.println(methonName + "方法被调用，参数为" + args);
	}

	// 后置通知 无论目标方法是否有异常都会执行
//	@After("execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))")
 	@After("joinPointCutExpression()")
	public void after(JoinPoint joinPoint) {
		String methonName = joinPoint.getSignature().getName();
		System.out.println(methonName + "方法的后置通知");
	}

	// 返回通知
	@AfterReturning(value = "execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))", returning = "result")
	public void returnMethod(JoinPoint joinPoint, Object result) {
		String methonName = joinPoint.getSignature().getName();
		System.out.println(methonName + "方法的返回通知" + "返回值为：" + result);

	}

	// 异常通知
	@AfterThrowing(value = "execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))", throwing = "ex")
	public void throwMethod(JoinPoint joinPoint, Exception ex) {
		String methonName = joinPoint.getSignature().getName();
		System.out.println(methonName + "方法的异常通知" + "异常为：" + ex);
	}

	// 环绕通知， 相当于动态代理的实现
//	@Around("execution(* spring.aop.impl.ArithmeticCalculate.*(int,int))")
 	@Around("joinPointCutExpression()")
	public Object arroundMethod(ProceedingJoinPoint pjp) {
		Object result = null;
		try {
			String methonName = pjp.getSignature().getName();
			String args = Arrays.asList(pjp.getArgs()).toString();
			System.out.println("前置通知" + methonName + "  " + args);
			result = pjp.proceed();
			System.out.println("返回通知");
		} catch (Throwable e) {
			System.out.println("异常通知" + e);
		} finally {
			System.out.println("后置通知");
		}
		return result;
	}
}
