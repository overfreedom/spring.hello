package spring.hello.test.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.fabric.xmlrpc.base.Array;

public class ArithmeticCalculateProxy {
	private ArithmeticCalculate arithmeticCalculate;

	public ArithmeticCalculateProxy(ArithmeticCalculate arithmeticcalculate) {
		this.arithmeticCalculate =arithmeticcalculate;
	}

	public ArithmeticCalculate getArithmeticCalculateProxy() {

		ClassLoader loader = arithmeticCalculate.getClass().getClassLoader();		
		Class[] interfaces = new Class[] {ArithmeticCalculate.class};
		InvocationHandler h = new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("正在执行"+method.getName() +"方法:参数"+ Arrays.asList(args));				
				Object result = method.invoke(arithmeticCalculate, args);
				System.out.println(method.getName() + "结果为"+result);
				return result;
			}
		};
		
		ArithmeticCalculate proxy =  (ArithmeticCalculate) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
		
	}
}


