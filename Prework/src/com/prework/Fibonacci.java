package com.prework;

public class Fibonacci {

	int sum;

	public Fibonacci() {
		sum = 0;
	}

	public int computeFibonacci(int num) {
		if (num > 0) {
			if (num == 1)
				return 1;
			else {
				sum = computeFibonacci(num - 1) + computeFibonacci(num - 2);
				return sum;
			}
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {

		Fibonacci f = new Fibonacci();

		System.out.println(f.computeFibonacci(8) + " " + f.computeFibonacci(9));

	}

	public static void foo(String[] args) {

		Fibonacci f = new Fibonacci();

		System.out.println(f.computeFibonacci(7) + " " + f.computeFibonacci(19));

	}

}
