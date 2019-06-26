package spring.beans.cylce;

import spring.beans.cylce.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MybeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("before init");
		if ("car".equals(beanName) ) {
			Car car = new Car();
			car =(Car) bean;
			car.setBrand("benchi");
			return car;
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after init");
		return bean;
	}

}
