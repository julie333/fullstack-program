package demos;


public class Product {
	
	private final String name;
	private final ProductColors color;
	private final ProductSizes size; 
	private final Double price;
	

	public Product(String name, ProductColors color, ProductSizes size, Double price) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
		this.price = price;
	}
	public String getName() {
		return this.name;
	}

	public Double getPrice() {
		return this.price;
	}

	
	public ProductColors getColor() {
		return this.color;
	}

	public ProductSizes getSize() {
		return this.size;
	}
	

}