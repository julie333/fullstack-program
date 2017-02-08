package passwordValidator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PasswordValidatorTest {

	PasswordValidator pvStandard = new StandardPasswordValidator();
	PasswordValidator pvStrong = new StrongPasswordValidator();

	@Test
	public void testStandardPassword() {

		assertThat(pvStandard.isValid("hellooooooooooooo")).isTrue();
		assertThat(pvStandard.isValid("hello")).isFalse();

	}

	@Test
	public void testStrongPasswordValidator() {

		assertThat(pvStrong.isValid("hello1234")).isTrue();
		assertThat(pvStrong.isValid("h4")).isFalse();
		assertThat(pvStrong.isValid("45645768")).isFalse();
		assertThat(pvStrong.isValid("hello")).isFalse();

	}

}
