package com.prework;

public class FibonacciCommandline {

	public static void main(String[] args) {

		try {
			int num = Integer.parseInt(args[0]);
			int sum = 0;

			System.out.println("Number :" + num + " Fibonacci :" + computeFibonacci(num, sum));
		} catch (Exception e) {
			System.out.println("Error: you must supply which Fibonacci number to compute");
			System.exit(1);
		}
	}

	public static int computeFibonacci(int num, int sum) {
		if (num > 0) {
			if (num == 1)
				return 1;
			else {
				sum = computeFibonacci(num - 1, sum) + computeFibonacci(num - 2, sum);
				return sum;
			}
		} else {
			return 0;
		}
	}
}