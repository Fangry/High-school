package ccc_problems;

import java.util.Scanner;

public class CCC_2011_J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int humid = scanner.nextInt();
        int maxH = scanner.nextInt();

        //method 1
        double landH = 241;
        for (double t = 1; t < maxH; t+=0.1) {
            if (-6 * Math.pow(t, 4) + humid * Math.pow(t, 3) + 2 * Math.pow(t, 2) + t < 0.0001) {
                landH = t;
                break;
            }
        }
        if (maxH > landH) {
            System.out.println("The balloon first touches ground at hour: \n" + (int) Math.round(landH));
        } else {
            System.out.println("The balloon does not touch ground in the given time.");
        }

        //method 2
//        int t = 1;
//        double Altitude = -6 * t * t * t * t + humid * t * t * t + 2 * t * t + t;
//        while (t < maxH && Altitude >= 0) {
//            t++;
//            Altitude = -6 * t * t * t * t + humid * t * t * t + 2 * t * t + t;
//        }
//        if (Altitude < 0) {
//            System.out.println("The balloon first touches ground at hour: \n" + t);
//        } else {
//            System.out.println("The balloon does not touch ground in the given time.");
//        }
        scanner.close();
    }
}
