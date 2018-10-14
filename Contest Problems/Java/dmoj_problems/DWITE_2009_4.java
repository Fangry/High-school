package dmoj_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DWITE_2009_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            char[][] map = new char[8][8];
            for (int j = 0; j < map.length; j++) { // get rounding data
                map[j] = scanner.nextLine().toCharArray();
            }
            int[] aAndB = new int[4]; // record points A and B's xy location on map
            for (int row = 0; row < map.length; row++) {
                for (int col = 0; col < map[0].length; col++) {
                    if (map[row][col] == 'A') {
                        aAndB[0] = row;
                        aAndB[1] = col;
                    }
                    if (map[row][col] == 'B') {
                        aAndB[2] = row;
                        aAndB[3] = col;
                    }
                }
            }
            int[][] step = new int[map.length][map[0].length]; // same size as map, this shows how many steps to get to each location
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    step[r][c] = 64;
                }
            }
            step[aAndB[0]][aAndB[1]] = 0; // start at point A
            List<Integer> rowList = new ArrayList<>();
            rowList.add(aAndB[0]);
            List<Integer> colList = new ArrayList<>();
            colList.add(aAndB[1]);

            while (!rowList.isEmpty()) {
                int row = rowList.get(0); // start at last position
                rowList.remove(0);
                int col = colList.get(0);
                colList.remove(0);

                if (row - 1 >= 0 && map[row - 1][col] != '#' && step[row - 1][col] > step[row][col] + 1) { // if there is space up AND that space is not wall AND the steps it takes to next position is one larger than the steps to get to current position
                    step[row - 1][col] = step[row][col] + 1;
                    rowList.add(row - 1);
                    colList.add(col);
                      System.out.println("going up");
                }
                if (row - 1 >= 0 && col - 1 >= 0 && map[row - 1][col - 1] != '#' && step[row - 1][col - 1] > step[row][col] + 1) {
                    step[row - 1][col - 1] = step[row][col] + 1;
                    rowList.add(row - 1);
                    colList.add(col - 1);
                       System.out.println("going up left");
                }
                if (row + 1 < 8 && map[row + 1][col] != '#' && step[row + 1][col] > step[row][col] + 1) {
                    step[row + 1][col] = step[row][col] + 1;
                    rowList.add(row + 1);
                    colList.add(col);
                        System.out.println("going down");
                }
                if (row - 1 >= 0 && col + 1 < 8 && map[row - 1][col + 1] != '#' && step[row - 1][col + 1] > step[row][col] + 1) {
                    step[row - 1][col + 1] = step[row][col] + 1;
                    rowList.add(row - 1);
                    colList.add(col + 1);
                         System.out.println("going up right");
                }
                if (col - 1 >= 0 && map[row][col - 1] != '#' && step[row][col - 1] > step[row][col] + 1) {
                    step[row][col - 1] = step[row][col] + 1;
                    rowList.add(row);
                    colList.add(col - 1);
                           System.out.println("going left");
                }
                if (row + 1 < 8 && col + 1 < 8 && map[row + 1][col + 1] != '#' && step[row + 1][col + 1] > step[row][col] + 1) {
                    step[row + 1][col + 1] = step[row][col] + 1;
                    rowList.add(row + 1);
                    colList.add(col + 1);
                       System.out.println("going down right");
                }
                if (col + 1 < 8 && map[row][col + 1] != '#' && step[row][col + 1] > step[row][col] + 1) {
                    step[row][col + 1] = step[row][col] + 1;
                    rowList.add(row);
                    colList.add(col + 1);
                          System.out.println("going right");
                }
                if (row + 1 < 8 && col - 1 >= 0 && map[row + 1][col - 1] != '#' && step[row + 1][col - 1] > step[row][col] + 1) {
                    step[row + 1][col - 1] = step[row][col] + 1;
                    rowList.add(row + 1);
                    colList.add(col - 1);
                        System.out.println("going down left");
                }
            }
             //step map
            System.out.println();
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    System.out.print(step[r][c] + " ");
                }
                System.out.println();
            }

            System.out.println(step[aAndB[2]][aAndB[3]]);
        }
        scanner.close();
    }
}

