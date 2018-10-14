package ccc_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCC_2001_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = scanner.nextInt();
        int end = scanner.nextInt();
        List<Integer> numList = new ArrayList<>();

        for (int i = end; i > begin - 1; i--) {
            numList.add(i);
        }

        int row = (int) Math.round(Math.sqrt(numList.size()));
        int col = row;

        if (numList.size() - row * row > 0) {
            col++;
        }

        List<List<Integer>> table = new ArrayList<>();
        int r2 = row / 2;
        int c2 = col / 2;
        while (!numList.isEmpty()) {
            
        }

        System.out.println(row + " " + col);
        scanner.close();
    }
}
