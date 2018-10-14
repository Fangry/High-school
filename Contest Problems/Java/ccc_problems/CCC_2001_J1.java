package ccc_problems;

import java.util.Scanner;

public class CCC_2001_J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < 2 * h; j++) {
                if (i < (h / 2) + 1) {
                    if ((j < 1 + 2 * i) || (j > 2 * h - 2 - 2 * i)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    if ((j >  2 * i) || (j < 2 * h - 1 - 2 * i)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
