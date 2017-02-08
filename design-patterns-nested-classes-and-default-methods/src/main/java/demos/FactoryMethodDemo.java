package demos;

public class FactoryMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Factory Method (Range : -128 to 127)
		Integer i1 = Integer.valueOf(42);
		Integer i3 = Integer.valueOf(42);

		// Standard Constructor
		Integer i2 = new Integer(42);

		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
		System.out.println(i1 == i3);

	}

}
