package Shapes;

public class Circle implements Shape {
	
	protected double radius;

	@Override
	public Double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(getRadius(), 2);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [Area=" + getArea()+"]";
	}

}
 