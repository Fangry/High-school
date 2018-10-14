package ccc_problems;

import java.util.Arrays;
import java.util.Scanner;

public class CCC_2007_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numBoxes = Integer.parseInt(scanner.nextLine());
        int[][] boxes = new int[numBoxes][3];
        for (int i = 0; i < numBoxes; i++) {
            String[] temp = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                boxes[i][j] = Integer.parseInt(temp[j]);
            }
            Arrays.sort(boxes[i]);
        }
        int numItems = Integer.parseInt(scanner.nextLine());
        int[][] items = new int[numItems][3];
        for (int i = 0; i < numItems; i++) {
            String[] temp = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                items[i][j] = Integer.parseInt(temp[j]);
            }
            Arrays.sort(items[i]);
        }

        for (int i = 0; i < numItems; i++) {
            int output = Integer.MAX_VALUE;
            for (int j = 0; j < numBoxes; j++) {
                if (items[i][0] <= boxes[j][0] && items[i][1] <= boxes[j][1] && items[i][2] <= boxes[j][2]) { // requirement
                    output = Math.min(output, boxes[j][0] * boxes[j][1] * boxes[j][2]);
                }
            }
            if (output == Integer.MAX_VALUE) {
                System.out.println("Item does not fit.");
            } else {
                System.out.println(output);
            }
        }
        scanner.close();
    }
}
