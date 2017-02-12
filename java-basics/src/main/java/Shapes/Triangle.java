package Shapes;

public class Triangle implements Shape {
	
	protected final double breadth;
	protected final double height;
	
	
	public Triangle(Double breadth, Double width) {
		super();
		this.breadth = breadth;
		this.height = width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.breadth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.height);
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
		Triangle other = (Triangle) obj;
		if (Double.doubleToLongBits(this.breadth) != Double.doubleToLongBits(other.breadth))
			return false;
		if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height))
			return false;
		return true;
	}

	public Double getBreadth() {
		return this.breadth;
	}

	public Double getWidth() {
		return this.height;
	}

	@Override
	public Double getArea() {
		// TODO Auto-generated method stub
		return (height*breadth)/2;
	}

	@Override
	public String toString() {
		return "Triangle [Area=" + getArea()+"]";
	}
	
	


}
