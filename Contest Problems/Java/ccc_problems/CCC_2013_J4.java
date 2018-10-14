package ccc_problems;

import java.util.Arrays;
import java.util.Scanner;

public class CCC_2013_J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();
        int numChores = scanner.nextInt();
        int[] chores = new int[numChores];

        for (int i = 0; i < numChores; i++) {
            chores[i] = scanner.nextInt();
        }
        Arrays.sort(chores);

        int sum = 0;
        int iterator = 0;
        while (sum + chores[iterator] <= minutes) {
            sum += chores[iterator];
            iterator++;
        }

        System.out.println(iterator);
        scanner.close();
    }
}
