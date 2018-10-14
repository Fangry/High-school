package ecoo_problems;

import java.util.Arrays;
import java.util.Scanner;

public class ECOO_2015_R1_P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] smarties = new int[8];
        while (true) {
            String temp = scanner.nextLine();
            if (temp.equals("end of box")) {
                break;
            }
            switch (temp) {
                case "orange":
                    smarties[0]++;
                    break;
                case "blue":
                    smarties[1]++;
                    break;
                case "green":
                    smarties[2]++;
                    break;
                case "yellow":
                    smarties[3]++;
                    break;
                case "pink":
                    smarties[4]++;
                    break;
                case "violet":
                    smarties[5]++;
                    break;
                case "brown":
                    smarties[6]++;
                    break;
                case "red":
                    smarties[7]++;
                    break;
            }
        }
        int output = 0;
        for (int i = 0; i < smarties.length; i++) {
            if (i == 7) {
                output += smarties[i] * 16;
            } else {
                int times = smarties[i] / 7;
                if (smarties[i] % 7 != 0) {
                    times++;
                }
                output += times * 13;
            }
        }

        System.out.println(output);
        scanner.close();
    }
}
