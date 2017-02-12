package com.prework;

public class Factorial {

	int fact;

	public Factorial() {

	}

	// Recursion

	public int factorial1(int n) {
		if (n > 0) {
			if (n == 1)
				return 1;
			return n * factorial1(n - 1);
		} else
			return 0;
	}

	// Iteration
	public int factorial2(int n) {
		if (n > 0) {
			fact = 1;
			for (int i = 1; i <= n; i++)
				fact *= i;
			return fact;

		} else
			return 0;
	}

	public void print(int num) {
		for (int j = 1; j <= num; j++) {
			System.out.println(j + "! = " + factorial1(j));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factorial f = new Factorial();

		f.print(5);
		f.print(15);
		f.print(-8);
	}
}
