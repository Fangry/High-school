package ccc_problems;

import java.util.Arrays;
import java.util.Scanner;

public class CCC_2017_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int[] measurements = new int[num];
        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i < measurements.length; i++) {
            measurements[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(measurements);
        int[] lowTides = new int[num / 2];
        int[] highTides = new int[num / 2];
        System.arraycopy(measurements, 0, lowTides, 0, lowTides.length);
        System.arraycopy(measurements, lowTides.length, highTides, 0, highTides.length);

        for(int i = 0; i < lowTides.length; i++) { // basically reverse sort
            lowTides[i] *= -1;
        }
        Arrays.sort(lowTides);
        for(int i = 0; i < lowTides.length; i++) {
            lowTides[i] *= -1;
        }

        for (int i = 0; i < lowTides.length; i++) {
            System.out.print(lowTides[i] + " " + highTides[i] + " ");
        }

        scanner.close();
    }
}
