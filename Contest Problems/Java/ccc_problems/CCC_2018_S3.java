//unsolved
package ccc_problems;

import java.util.Scanner;

public class CCC_2018_S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        char[][] map = new char[row][col];

        for (int i = 0; i < row; i++) { // get rounding data
            char[] temp = scanner.nextLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = temp[j];
            }
        }



        scanner.close();
    }
}
