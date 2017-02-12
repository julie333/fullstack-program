package Shapes;

public class Rectangle implements Shape {
	
	protected double breadth;
	protected double width;
	
	
	public Rectangle(Double breadth, Double width) {
		super();
		this.breadth = breadth;
		this.width = width;
	}

	public Double getBreadth() {
		return this.breadth;
	}

	public Double getWidth() {
		return this.width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.breadth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.width);
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
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(this.breadth) != Double.doubleToLongBits(other.breadth))
			return false;
		if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	@Override
	public Double getArea() {
		// TODO Auto-generated method stub
		return breadth*width;
	}
	
	@Override
	public String toString() {
		return "Rectangle [Area=" + getArea()+"]";
	}

}
