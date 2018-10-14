package ccc_problems;

import java.util.Scanner;

public class CCC_2003_J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            double photos = scanner.nextDouble();
            if (photos == 0) {
                break;
            } else {
                int x = (int) Math.round(Math.sqrt(photos));
                int y = x;
                while (x * y != photos) {
                    x += 1;
                    y -= 1;
                }
                int perimeter = 2 * (x + y);
                System.out.println("Minimum perimeter is " + perimeter + " with dimensions " + x + " x " + y);
            }
        }
        scanner.close();
    }
}
