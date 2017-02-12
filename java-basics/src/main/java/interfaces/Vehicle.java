package interfaces;

public class Vehicle {

	private String color;
	private int speed;

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Vehicle(String color, int speed) {
		super();
		this.color = color;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Vehicle [color=" + this.color + ", speed=" + this.speed + "]--" + super.toString();
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.color == null) ? 0 : this.color.hashCode());
		result = prime * result + this.speed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (this.color == null) {
			if (other.color != null)
				return false;
		} else if (!this.color.equals(other.color))
			return false;
		if (this.speed != other.speed)
			return false;
		return true;
	}

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	protected int getDoubleSpeed(){ //Subclass can see it , if its private no subclass can access it
		return speed * 2;
	}

	public static void main(String[] args) {

		Vehicle v = new Vehicle("red", 100);
		Vehicle v2 = new Vehicle("blue", 120);
		Vehicle v3 = new Vehicle("red", 100);

		Object x = new Integer(5);
		Number y = new Integer(5);
		
//		if (x instanceof Object) {
//
//			System.out.println("Object");
//		}

		if (x instanceof Number) {

			System.out.println("Number");
		}

		if (x instanceof Integer) {

			System.out.println("Integer");
		}

		System.out.println(v.equals(v3));
		System.out.println(v.equals(v2));

		System.out.println(v.toString());
		
		Integer i =  (Integer) x;
//		Double d =  (Integer) x; Type mismatch: cannot convert from Integer to Double
		i.shortValue();
//		x.doubleValue(); The method doubleValue() is undefined for the type Object
		i.doubleValue();
		

		// Logic should be implemented on our own
		//package + SUBCLASSES

	}

}
