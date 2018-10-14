package ecoo_problems;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ECOO_2012_P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String[] names = new String[10];
        int[] atBats = new int[10];
        int[] totalHits = new int[10];
        int[] oneHits = new int[10];
        int[] twoHits = new int[10];
        int[] threeHits = new int[10];
        int[] homeRuns = new int[10];

        for (int i = 0; i < 10; i++) {
            String[] temp = scanner.nextLine().split(" ");
            names[i] = temp[0];
            atBats[i] = Integer.parseInt(temp[2]);
            totalHits[i] = Integer.parseInt(temp[4]);
            twoHits[i] = Integer.parseInt(temp[5]);
            threeHits[i] = Integer.parseInt(temp[6]);
            homeRuns[i] = Integer.parseInt(temp[7]);
            oneHits[i] = totalHits[i] - twoHits[i] - threeHits[i] - homeRuns[i];
        }

        double[] batAvgs = new double[10];
        double[] slugAvgs = new double[10];
        double totalBatAvg = 0;
        double totalSlugAvg = 0;

        for (int i = 0; i < 10; i++) {
            batAvgs[i] = (double) (totalHits[i]) / atBats[i];
            batAvgs[i] = Math.round(batAvgs[i] * 1000.0) / 1000.0;
            slugAvgs[i] = (double) (oneHits[i] + 2 * twoHits[i] + 3 * threeHits[i] + 4 * homeRuns[i]) / atBats[i];
            slugAvgs[i] = Math.round(slugAvgs[i] * 1000.0) / 1000.0;
        }

        for (int i = 0; i < 10; i++) {
            totalBatAvg += batAvgs[i] / 10.0;
            totalSlugAvg += slugAvgs[i] / 10.0;
        }
        totalBatAvg = Math.round(totalBatAvg * 1000.0) / 1000.0;
        totalSlugAvg = Math.round(totalSlugAvg * 1000.0) / 1000.0;

        DecimalFormat df = new DecimalFormat(".000");
        //output begins here
        System.out.println(title);
        System.out.println("====================");
        for (int i = 0; i < 10; i++) {
            System.out.println(names[i] + ": " + df.format(batAvgs[i]) + " " + df.format(slugAvgs[i]));
        }
        System.out.println("====================");
        System.out.println("Big 10 Av: " + df.format(totalBatAvg) + " " + df.format(totalSlugAvg));

        scanner.close();
    }
}
