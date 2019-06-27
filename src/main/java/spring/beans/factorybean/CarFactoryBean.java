package spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
	private String brand;
	public void setBrand(String brand) {
		this.brand =brand;
	}
	
	public Car getObject() throws Exception {
		return new Car("BenChi", 5000.00);
		
	}

	public Class<?> getObjectType() { 
		return Car.class;
	}

	public boolean isSingleton() {
		return false;
	}

}
