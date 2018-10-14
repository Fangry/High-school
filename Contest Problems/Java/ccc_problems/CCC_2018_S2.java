package ccc_problems;

import java.util.Scanner;

public class CCC_2018_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] table = new int[rows][rows];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j ++) {
                table[i][j] = scanner.nextInt();
            }
        }

        /*for(int i = 0; i < table.length-1; i++) {
            for (int j = 0; j < table.length-1; j ++) {
                while (table[i][j] >= table[i][j + 1] || table[i][j] >= table[i+1][j]) {
                    for(int k = 0; k < table.length; k ++) {
                        for(int l = 0; l < table.length; l++) {
                            table[l][table.length-1-k] = table[k][l];
                            System.out.println(table[k][l]);
                        }
                    }
                }
            }
        }
        */

        for(int i = table.length-1; i >= 0; i--) {
            for (int j = table.length-1; j >= 0; j--) {
                table[i][j] = table[j][i];
            }
        }

        for(int[] row : table) {
            for(int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
