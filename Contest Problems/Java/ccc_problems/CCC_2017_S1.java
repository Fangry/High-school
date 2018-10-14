package ccc_problems;

import java.util.Scanner;

public class CCC_2017_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int[] swifts = new int[days];
        int[] sema = new int[days];
        int output = 0;
        String[] temp1 = scanner.nextLine().split(" ");
        String[] temp2 = scanner.nextLine().split(" ");

        for (int i = 0; i < days; i++) {
            swifts[i] = Integer.parseInt(temp1[i]);
            sema[i] = Integer.parseInt(temp2[i]);
        }

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < days; i++) {
            sum1 += swifts[i];
            sum2 += sema[i];
            if (sum1 > 0 && sum2 > 0 && sum1 == sum2) {
                output = i + 1;
            }
        }

        System.out.println(output);
        scanner.close();
    }
}
