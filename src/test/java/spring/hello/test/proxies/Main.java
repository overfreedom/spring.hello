package spring.hello.test.proxies;

public class Main {

	public static void main(String[] args) {
		ArithmeticCalculate target = new ArithmeticCalculateImpl();
		ArithmeticCalculate proxy = new ArithmeticCalculateProxy(target).getArithmeticCalculateProxy();

		proxy.add(1, 2);
		proxy.mul(3, 4);
	}

}
