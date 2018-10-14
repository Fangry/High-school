package random_stuff;

import java.util.*;

public class Password {

	public static void main(String[] args) {
		boolean gotIt = false;
		int password = 123456;
		int i = 0;
		Scanner in = new Scanner(System.in);

		System.out.println("Plz enter your name!");
		String userName = in.nextLine();

		while (!gotIt) {
			System.out.println("Plz enter the password.");
			i = in.nextInt();
			if (i == password) {
				System.out.println("Welcome back, " + userName);
				gotIt = true;

			} else {
				System.out.println("Access denied \nHINT: it is between 0 and 999999999");
			}
		}
		in.close();
	}

}
