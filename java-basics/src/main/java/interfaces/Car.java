package interfaces;

public class Car extends Vehicle {

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String color, int speed) {
		super(color, speed);
		// TODO Auto-generated constructor stub
	}
	
	public int getTurboSpeed(){ 
		return getDoubleSpeed() * 20;
	}


}
