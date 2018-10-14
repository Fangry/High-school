package ecoo_problems;

import java.util.Scanner;

public class ECOO_2016_R1_P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = 4;
        int[] numPassed = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            int[] weights = new int[4];
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                weights[j] = Integer.parseInt(input[j]);
            }
            int numStudents = Integer.parseInt(scanner.nextLine());
            int[][] grades = new int[numStudents][4];
            for (int j = 0; j < numStudents; j++) {
                String[] temp = scanner.nextLine().split(" ");
                for (int k = 0; k < 4; k++) {
                    grades[j][k] = Integer.parseInt(temp[k]);
                }
            }
            for (int j = 0; j < numStudents; j++) {
                int total = 0;
                for (int k = 0; k < 4; k++) {
                    total += weights[k] * grades[j][k];
                }
                total /= 100;
                //System.out.println("student " + j + " got " + total);
                if (total > 50) {
                    numPassed[i]++;
                }
            }
            System.out.println(numPassed[i]);
            //System.out.println();
        }
        scanner.close();
    }
}
