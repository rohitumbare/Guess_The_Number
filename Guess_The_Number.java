package guess_the_number_game;

import java.util.Random;
import java.util.Scanner;

public class Guess_The_Number {

//	ANSI Escape Codes for Text Color
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String Cyan = "\u001B[36m";
	public static final String Magenta = "\u001B[35m";

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		int randomNumber = ran.nextInt(100) + 1;

		int tryCount = 0;
		while (tryCount < 10) {
			System.out.print("Enter your guess (1-100):");

			int playerGuess = sc.nextInt();
			tryCount++;

			if (playerGuess == randomNumber) {
				System.out.println(GREEN + "\nYou Win!!!" + RESET);
				System.out.println("It took you " + YELLOW + tryCount + RESET + " tries.");

				if (tryCount == 1) {
					System.out.println(Cyan + "***YOU ARE GOD***" + RESET);
				} else if (tryCount <= 3) {
					System.out.println(Cyan + "Excellent Performance.\nYou Get 5 Stars: " + Magenta + "*****" + RESET);
				} else if (tryCount <= 6) {
					System.out.println(Cyan + "Good Performance.\nYou Get 3 Stars:" + Magenta + " ***" + RESET);
				} else {
					System.out.println(Cyan + "Average Performance.\nYou Get 1 Stars: " + Magenta + "*" + RESET);
				}
			} else if (tryCount == 10) {
				System.out.println(RED + "\nOut of tries.\nYou have tried maximum tries." + RESET);

			} else if (randomNumber > playerGuess) {
				System.out.println(YELLOW + "Nope! The number is higher. Guess again." + RESET);
			} else {
				System.out.println(YELLOW + "Nope! The number is lower. Guess again." + RESET);
			}

			if (playerGuess == randomNumber || tryCount == 10) {
				System.out.println("Do you wanna play again " + Cyan + "(Y/N):" + RESET);
				String playAgain = sc.next();

				if (playAgain.equals("y") || playAgain.equals("Y")) {
					tryCount = 0;
				} else {
					System.out.println(Magenta + "\nYou Quit.\nThanks For Playing..." + RESET);
					break;
				}
			}

		}

		sc.close();

	}
}