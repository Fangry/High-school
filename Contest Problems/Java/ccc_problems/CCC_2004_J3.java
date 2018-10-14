package ccc_problems;

import java.util.Scanner;

public class CCC_2004_J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numAdjs = Integer.parseInt(scanner.nextLine());
        int numNouns = Integer.parseInt(scanner.nextLine());
        String[] adjs = new String[numAdjs];
        String[] nouns = new String[numNouns];

        for (int i = 0; i < numAdjs; i++) {
            adjs[i] = scanner.nextLine();
        }
        for (int i = 0; i < numNouns; i++) {
            nouns[i] = scanner.nextLine();
        }

        for (int i = 0; i < numAdjs; i++) {
            for (int j = 0; j < numNouns; j++) {
                System.out.println(adjs[i] + " as " + nouns[j]);
            }
        }

        scanner.close();
    }
}
