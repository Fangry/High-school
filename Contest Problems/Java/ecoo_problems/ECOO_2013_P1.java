package ecoo_problems;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ECOO_2013_P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int howManyLate = 0, howManyServed = 0, howManyLeft = 0;

        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            if (temp.equals("EOF")) {
                break;
            } else if (temp.equals("TAKE")) {
                howManyLate++;
                num++;
                if (num > 999) {
                    num = 1;
                }
            } else if (temp.equals("SERVE")) {
                howManyServed++;
            } else if (temp.equals("CLOSE")) {
                howManyLeft = howManyLate - howManyServed;
                System.out.println(howManyLate + " " + howManyLeft + " " + num);
                howManyLate = 0;
                howManyServed = 0;
            }
        }
        scanner.close();
    }
}
