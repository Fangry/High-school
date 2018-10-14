package ccc_problems;

import java.util.Scanner;

public class CCC_2012_J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        char[][] original = {{'*', 'x', '*'}, {' ', 'x', 'x'}, {'*', ' ', '*'}};
        char[][] output = new char[input * 3][input * 3];

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output.length; j++) {
                output[i][j] = original[i / input][j / input];
                //output[i][j] = original[i % input][j % input]; // wrong but cool result
            }
        }

        for (char[] cc : output) {
            for (char c : cc) {
                System.out.print(c);
            }
            System.out.println();
        }

        scanner.close();
    }
}
