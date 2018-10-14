package ccc_problems;

import java.util.Scanner;

public class CCC_2013_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        year = String.valueOf(Integer.parseInt(year) + 1);

        for (int x = 0; x < year.length()*year.length(); x++) {
            for (int i = 0; i < year.length(); i++) {
                char c = year.charAt(i);
                for (int j = i + 1; j < year.length(); j++) {
                    char check = year.charAt(j);
                    if (c == check) {
                        year = String.valueOf(Integer.parseInt(year) + 1);
                    }
                }
            }
        }
        System.out.println(year);
        scanner.close();
    }
}

