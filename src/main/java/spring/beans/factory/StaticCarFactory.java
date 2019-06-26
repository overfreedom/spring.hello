package spring.beans.factory;

import java.util.HashMap;
/**
 * 静态工厂方法：直接调用某个类的静态方法就可以返回bean实例
 */
public class StaticCarFactory {
	private static HashMap<String,Car> cars;

	static {
		cars = new HashMap<String, Car>();
		cars.put("baoma", new Car("baoma",30000.0));
		cars.put("benchi", new Car("benchi", 40000.0));
	}

	public static Car getCar(String carName) {
		return cars.get(carName);			
	}
}
