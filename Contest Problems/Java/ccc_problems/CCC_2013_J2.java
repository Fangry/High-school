package ccc_problems;

import java.util.Scanner;

public class CCC_2013_J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String output = "YES";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != 'I' && c != 'O' && c != 'S' &&
                    c != 'H' && c != 'Z' && c != 'X' && c != 'N') {
                output = "NO";
                break;
            }
        }

        System.out.println(output);
        scanner.close();
    }
}
