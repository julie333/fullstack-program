package com.prework;

public class PrimeNums {

	public PrimeNums() {

	}

	public boolean primes(int n) {

		if (n == 2)
			return true;

		if (n % 2 != 0 && n > 1) {
			for (int i = 3; i <= Math.sqrt(n); i += 2)
				if ((n % i) == 0 && (n != i))
					return false;
		} else
			return false;

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrimeNums p = new PrimeNums();
		int i = 0;
		int count = 0;
		System.out.println("First 20 primes");
		while (count <= 20) {
			i++;
			if (p.primes(i)) {
				System.out.println(i);
				count++;

			}
		}

	}

}
