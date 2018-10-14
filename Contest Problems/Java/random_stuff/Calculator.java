package random_stuff;

import java.util.*;

public class Calculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float answer = 0;
		try {
			System.out.println("Welcome to Simple Calculator!\nEnter your first number!");
			float a = input.nextFloat();
			System.out.println("Which operation would you like?");
			char operator = input.next().charAt(0);
			checkOperator(operator);
			System.out.println("Enter your second number!");
			float b = input.nextFloat();

			switch (operator) {
			case '+':
				answer = add(a, b);
				break;
			case '-':
				answer = subtract(a, b);
				break;
			case '*':
				answer = multiply(a, b);
				break;
			case '/':
				answer = divide(a, b);
				break;
			}
		} finally {
			input.close();
		}
		System.out.println("The answer is : " + answer);
	}

	public static float add(float a, float b) {
		return a + b;
	}

	public static float subtract(float a, float b) {
		return a - b;
	}

	public static float multiply(float a, float b) {
		return a * b;
	}

	public static float divide(float a, float b) {
		return a / b;
	}

	public static void checkOperator(char o) {
		if (o != '+' && o != '-' && o != '*' && o != '/') {
			throw new IllegalArgumentException("Try +, -, *, or /");
		}
	}
}
