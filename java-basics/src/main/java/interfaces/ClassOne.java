package interfaces;

public class ClassOne implements MyInterface {

	public ClassOne() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generateMessage() {
		// TODO Auto-generated method stub
		
		System.out.println("Class One");
		return "Class One";
	}

}
