package random_stuff;

import java.util.Scanner;

public class Averager1 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		double total = 0;
		double temp;
		double average;
		int times = 0;
		boolean running = true;

		System.out.println("Welcome to Averager. Enter a number to Start");

		while (running) {
			if (times > 0) {
				System.out.println("Enter a number or enter s to stop");
			}
			String s = input.nextLine();
			if (s.charAt(0) == 's') {
				average = total / times;
				System.out.println("Your average is " + average);
				running = false;
			} else {
				times++;
				temp = Double.parseDouble(s);
				total += temp;
			}
		}
		input.close();
	}
}
