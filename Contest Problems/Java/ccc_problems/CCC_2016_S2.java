package ccc_problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CCC_2016_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int whichQuestion = Integer.parseInt(scanner.nextLine());
        int citizens = Integer.parseInt(scanner.nextLine());
        int[] dmoj = new int[citizens];
        Integer[] peg = new Integer[citizens];
        String[] temp1 = scanner.nextLine().split(" ");
        String[] temp2 = scanner.nextLine().split(" ");

        for (int i = 0; i < citizens; i++) {
            dmoj[i] = Integer.parseInt(temp1[i]);
            peg[i] = Integer.parseInt(temp2[i]);
        }

        int total = 0;
        if (whichQuestion == 1) { // find min.total speed
            Arrays.sort(dmoj);
            Arrays.sort(peg);
            //System.out.println(Arrays.toString(dmoj));
            //System.out.println(Arrays.toString(peg));
            for(int i = 0; i < citizens; i++) {
                total += Math.max(dmoj[i], peg[i]);
            }
        } else { // find max.total speed
            Arrays.sort(dmoj);
            Arrays.sort(peg, Collections.reverseOrder());
            //System.out.println(Arrays.toString(dmoj));
            //System.out.println(Arrays.toString(peg));
            for(int i = 0; i < citizens; i++) {
                total += Math.max(dmoj[i], peg[i]);
            }
        }

        System.out.println(total);
        scanner.close();
    }
}
