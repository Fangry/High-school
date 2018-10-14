package ccc_problems;

import java.util.Scanner;

public class CCC_2004_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String output = "Yes";
            String[] input = new String[3];
            for (int j = 0; j < input.length; j++) {
                input[j] = scanner.nextLine();
            }
            int shortest = 26;
            for (int j = 0; j < input.length; j++) {
                if (input[j].toCharArray().length < shortest) {
                    shortest = input[j].toCharArray().length;
                }
            }
            for (int j = 0; j < input.length; j++) {
                String prefix = "";
                String suffix = "";
                for (int k = 0; k < shortest; k++) {
                    prefix += input[j].charAt(k);
                }
                for (int k = shortest - 1; k >= 0; k--) {
                    suffix += input[j].charAt(k);
                }
                for (int k = 0; k < input.length; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (input[k].contains(prefix) || input[k].contains(suffix)) {
                        output = "No";
                    }
                }
            }
            System.out.println(output);
        }
        scanner.close();
    }
}
