package lombok.excercise;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class NumberGuess {

	private static final Logger logger = LogManager.getLogger(NumberGuess.class);

	public NumberGuess() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Random r = new Random(System.currentTimeMillis());
		double rNum = r.nextInt(10) + 1;
		System.out.println(rNum);
		System.out.println("I'm thinking of a random number from 1 to 10.");

		int flag = 0;
		int tries = 0;

		try (Scanner scanner = new Scanner(System.in)) {

			while (flag == 0) {
				tries++;
				System.out.println("Guess what it is: ");
				int number = Integer.parseInt(scanner.nextLine());
				System.out.format("\nYou guessed %s", number);

				if (rNum == number) {
					System.out.format("\nCongratulations! You guessed it in %s tries", tries);
					logger.info("\nUser has guessed correctly");
					System.exit(0);
				} else if (rNum < number) {

					System.out.println("\nNope. It's lower than that. Try again.");
					logger.info("\nUser has guessed wrongly");

				} else if (rNum > number) {

					System.out.println("\nNope. It's higher than that. Try again.");
					logger.info("\nUser has guessed wrongly");

				}

			}

		}catch (Exception e) {
			// TODO: handle exception
			
			logger.error("Invalid Input " , e);
			
			
			
		}

	}

}
