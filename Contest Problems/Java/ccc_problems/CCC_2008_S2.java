package ccc_problems;

import java.util.Scanner;

public class CCC_2008_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int radius = scanner.nextInt();
            if (radius == 0) {
                break;
            }
            int output = 0;
            for (int i = 1; i <= radius; i++) {
                output += (int) Math.sqrt(radius * radius - i * i) + 1;
            }
            output = 4 * output + 1;
            System.out.println(output);

        }
        scanner.close();
    }
}

