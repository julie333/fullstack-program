package passwordValidator;

public class StrongPasswordValidator extends StandardPasswordValidator {

	@Override
	public boolean isValid(String password) {

		boolean isLongEnough = isLongEnough(password);
		boolean containsOneLetter = password.matches(".*[a-zA-Z]+.*");
		boolean containsOneDigit = false;

		char[] p = password.toCharArray();

		for (int i = 0; i < p.length; i++)
			if (Character.isDigit(p[i]))
				containsOneDigit = true;

		if (isLongEnough && containsOneLetter && containsOneDigit)
			return true;
		else
			return false;

	};
}
