package spring.beans.factory;

import java.util.HashMap;

public class InstanctCarFactory {
	private HashMap<String, Car> cars;

	public InstanctCarFactory() {
		super();
		cars = new HashMap<String, Car>();
		cars.put("baoma", new Car("baoma", 30000.0));
		cars.put("benchi", new Car("benchi",40000.0));		
	}

	public Car getCar(String carName) {
		return cars.get(carName);
	}

	

}
