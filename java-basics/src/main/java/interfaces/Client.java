package interfaces;

public class Client {

	private final MyInterface myInterface;
	
	public Client(MyInterface myInterface) {
		this.myInterface = myInterface;
	}
	
	public String getClientClass() {
		String msg = this.myInterface.generateMessage();
		System.out.println(msg);
		return msg.toUpperCase();
	}

}
