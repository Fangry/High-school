package ccc_problems;

import java.util.Scanner;

public class CCC_2003_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int square = 1;

        outer:
        while (scanner.hasNextInt()) {
            int move = scanner.nextInt();
            if (move == 0) {
                System.out.println("You Quit!");
                break;
            }

            if (square + move <= 100) {
                square += move;
            }

            if (square == 100) {
                System.out.println("You are now on square 100");
                System.out.println("You Win!");
                break;
            } else if (square == 54) {
                square = 19;
            } else if (square == 90) {
                square = 48;
            } else if (square == 99) {
                square = 77;
            } else if (square == 9) {
                square = 34;
            } else if (square == 40) {
                square = 64;
            } else if (square == 67) {
                square = 86;
            }
            System.out.println("You are now on square " + square);
        }
        scanner.close();
    }
}

