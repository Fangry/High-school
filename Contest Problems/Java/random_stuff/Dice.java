package random_stuff;

import java.util.Random;

public class Dice {
	public static void main(String[] args) {
		Random dice = new Random();
		int number;
		int faces = 6;
		int times = 100;
		int[] tracker = new int[faces];

		for (int i = 0; i < times; i++) {
			number = 1 + dice.nextInt(faces);
			for (int j = 0; j < faces; j++) {
				if (number == j + 1) {
					tracker[j]++;
				}
			}

		}
		for (int i = 0; i < tracker.length; i++) {
			int iAddOne = i + 1;
			System.out.println("The number " + iAddOne + " is rolled " + tracker[i] + " times.");
		}

	}
}