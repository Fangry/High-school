// thanks to algorithms from https://stackoverflow.com/questions/12161277/how-to-rotate-a-vertex-around-a-certain-point?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
package ecoo_problems;

import java.util.Scanner;

public class ECOO_2012_P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] x = new int[5];
        int[] y = new int[5];

        for (int i = 0; i < 5; i++) {
            String[] temp = scanner.nextLine().split(" ");
            x[i] = Integer.parseInt(temp[0]);
            y[i] = Integer.parseInt(temp[1]);
        }

        for (int i = 0; i < 5; i++) {
            double[] pointLeft = new double[2]; // sort of like PVector
            double[] pointRight = new double[2];
            double[] pointDown = new double[2];
            double n120 = Math.toRadians(-120);
            double n60 = Math.toRadians(-60);
            double p120 = Math.toRadians(120);

            pointLeft[0] = x[i] + (-x[i]) * Math.cos(n120) - (-y[i]) * Math.sin(n120);
            pointLeft[1] = y[i] + (-x[i]) * Math.sin(n120) + (-y[i]) * Math.cos(n120);

            pointRight[0] = x[i] * Math.cos(n60) - y[i] * Math.sin(n60);
            pointRight[1] = x[i] * Math.sin(n60) + y[i] * Math.cos(n60);

            pointDown[0] = x[i] * Math.cos(p120) - y[i] * Math.sin(p120);
            pointDown[1] = x[i] * Math.sin(p120) + y[i] * Math.cos(p120);

            System.out.printf("(%.1f" + ",%.1f) ", pointDown[0], pointDown[1]);
            System.out.printf("(%.1f" + ",%.1f) ", pointRight[0], pointRight[1]);
            System.out.printf("(%.1f" + ",%.1f) ", pointLeft[0], pointLeft[1]);
            System.out.println();
        }
        scanner.close();
    }
}

