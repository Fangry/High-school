package ccc_problems;

import java.util.Scanner;

public class CCC_2009_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfRows = Integer.parseInt(scanner.nextLine());
        int numOfCols = Integer.parseInt(scanner.nextLine());
        int[][] grid = new int[numOfRows][numOfCols];
        int possiblePatterns = 0;

        for(int i = 0; i < numOfRows; i ++) {
            String[] input = scanner.nextLine().split(" ");
            for(int j = 0; j < numOfCols; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int[] x : grid) {
            for(int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

        System.out.println(grid[0].length*grid.length);

        System.out.println(possiblePatterns);
        scanner.close();
    }
}
