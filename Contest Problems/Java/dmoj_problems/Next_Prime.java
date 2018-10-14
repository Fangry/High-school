package dmoj_problems;

import java.util.Scanner;

public class Next_Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        scanner.close();
        if (min == 1) {
            System.out.println(2);
        } else {
            while (true) {
                int temp = min;
                for (int i = 2; i < Math.sqrt(min); i++) {
                    if (min % i == 0) {
                        min++;
                        break;
                    }
                }

                if (temp == min) {
                    break;
                }
            }
            System.out.println(min);
        }
    }
}