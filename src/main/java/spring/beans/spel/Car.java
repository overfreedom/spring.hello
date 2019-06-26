package spring.beans.spel;

public class Car {
	private String brand;
	private int maxSpeed;
	private double typePerimeter; //¬÷Ã•÷‹≥§
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public double getTypePerimeter() {
		return typePerimeter;
	}
	public void setTypePerimeter(double typePerimeter) {
		this.typePerimeter = typePerimeter;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + ", typePerimeter=" + typePerimeter + "]";
	}

}
