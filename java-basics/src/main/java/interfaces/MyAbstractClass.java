package interfaces;


public abstract class MyAbstractClass implements MyInterface{

	
	protected abstract String getCounting();


	protected abstract String keepCounting();

	protected String getTemplate() {
		return "%s%s";
	}

	@Override
	public final String generateMessage() { //final optional if you want to prevent ppl overiding ur comlex algorithm
		return String.format(getTemplate(), getCounting(), keepCounting());
	}
	

}
