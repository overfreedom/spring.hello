package spring.beans.factory;

import java.util.HashMap;
/**
 * ��̬����������ֱ�ӵ���ĳ����ľ�̬�����Ϳ��Է���beanʵ��
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
