package interfaces;

public class ClassOneOne extends MyAbstractClass {

//	@Override
//	public String generateMessage() {
//		return String.format(getTemplate(), "One and");
//	}

	@Override
	protected String getCounting() {
		// TODO Auto-generated method stub
		return "1";
	}

	@Override
	protected String keepCounting() {
		// TODO Auto-generated method stub
		return "2";
	}

}
