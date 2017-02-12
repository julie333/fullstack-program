package interfaces;

public class ClassTwoTwo extends MyAbstractClass {

//	@Override
//	public String generateMessage() {
//		return String.format(getTemplate(), "Two and");
//	}

	@Override
	protected String getCounting() {
		// TODO Auto-generated method stub
		return "2";
	}

	@Override
	protected String keepCounting() {
		// TODO Auto-generated method stub
		return "3";
	}

}
