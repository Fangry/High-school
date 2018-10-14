package ccc_problems;

import java.util.Scanner;

public class CCC_2007_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int[] years = new int[num];
        int[] months = new int[num];
        int[] days = new int[num];
        for(int i = 0; i < num; i++) {
            String[] temp = scanner.nextLine().split(" ");
            years[i] = Integer.parseInt(temp[0]);
            months[i] = Integer.parseInt(temp[1]);
            days[i] = Integer.parseInt(temp[2]);
        }
        for(int i = 0; i < num; i++) {
            if(years[i] < 1989 || (years[i] == 1989 && months[i] <= 2 && days[i] <= 27)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}
