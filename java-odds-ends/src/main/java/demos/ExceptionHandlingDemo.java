package demos;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Scanner;

import net.bytebuddy.jar.asm.commons.StaticInitMerger;
import net.bytebuddy.jar.asm.commons.TryCatchBlockSorter;

public class ExceptionHandlingDemo {

	public static void main(String[] args) throws IOException, AssertionError {
		// TODO Auto-generated method stub

		int n = 0;

		try {

			n = n / 0;
		} catch (ArithmeticException e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {

			System.out.println("Finally");
		}

		System.out.println("Before");
		// n = n / 0;
		System.out.println("After");

		ExceptionHandlingDemo e = new ExceptionHandlingDemo();

		e.sayHelloException();

		if (n <= 0) {
			throw new IllegalArgumentException("Must be greater than 0");
		}

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();

		try (Scanner scanner1 = new Scanner(System.in)) {
			// ...

		}

	}

	public int sayHelloException() throws IOException, AssertionError {

		String x = "happy";
		assertEquals(3, 3);
		System.out.println("Before");
		assertEquals(3, 5);
		System.out.println("After");
		return 0;

	}

}
