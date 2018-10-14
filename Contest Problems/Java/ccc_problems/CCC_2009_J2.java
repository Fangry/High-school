package ccc_problems;

import java.util.Scanner;

public class CCC_2009_J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int trout = scanner.nextInt();
        int pike = scanner.nextInt();
        int pickerel = scanner.nextInt();
        int max = scanner.nextInt();
        int estimate = max*2;
        int ways = 0;

        for (int i = 0; i < estimate; i++) {
            for (int j = 0; j < estimate; j++) {
                for (int k = 0; k < estimate; k++) {
                    if (i * trout + j * pike + k * pickerel <= max && (i + j + k) > 0) {
                        System.out.println(i + " Brown Trout, " + j + " Northern Pike, " + k + " Yellow Pickerel");
                        ways++;
                    }
                }
            }
        }
        System.out.println("Number of ways  to catch fish: " + ways);
        scanner.close();
    }
}
