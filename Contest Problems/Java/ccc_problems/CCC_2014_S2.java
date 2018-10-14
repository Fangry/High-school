package ccc_problems;

import java.util.Scanner;

public class CCC_2014_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        String[] firstLine = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ");
        String result = "good";

        for (int i = 0; i < students; i++) {
            if (firstLine[i].equals(secondLine[i])) {
                result = "bad";
            }

            for (int j = 0; j < students; j++) {
                if (firstLine[i].equals(firstLine[j]) && !secondLine[i].equals(secondLine[j])) {
                    result = "bad";
                }
                if (!firstLine[i].equals(firstLine[j]) && secondLine[i].equals(secondLine[j])) {
                    result = "bad";
                }
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
