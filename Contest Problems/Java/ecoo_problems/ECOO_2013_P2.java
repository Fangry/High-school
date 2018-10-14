package ecoo_problems;

import java.util.Scanner;

public class ECOO_2013_P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] input = new String[5][5];
        for (int i = 0; i < 5; i++) { // get rounding data
            String[] temp = scanner.nextLine().split(" ");
            for (int j = 0; j < 5; j++) {
                input[i][j] = temp[j];
            }
        }

        for (int i = 0; i < 5; i++) { // for each col
            String output = "";
            for (int j = 0; j < 5; j++) { // for each row
                int sum = 0;
                boolean divisible = false;

                while (!divisible) {
                    for (int x = 0; x < 10; x++) {
                        sum = 0;
                        String current = input[i][j];
                        current += Integer.toString(x);
                        //System.out.println(current);
                        for (int k = current.length() - 2; k >= 0; k -= 2) {
                            int twoTimes = Character.getNumericValue(current.charAt(k)) * 2;
                            char[] digits = String.valueOf(twoTimes).toCharArray();
                            for (char c : digits) {
                                sum += Character.getNumericValue(c);
                                //System.out.println(Character.getNumericValue(c) + " is added");
                            }
                        }
                        //System.out.println("sum: " + sum);
                        for (int k = current.length() - 1; k >= 0; k -= 2) {
                            sum += Character.getNumericValue(current.charAt(k));
                           // System.out.println(Character.getNumericValue(current.charAt(k)) + " is added");
                        }
                        //System.out.println("sum: " + sum);
                        //System.out.println();
                        if (sum % 10 == 0) {
                            output += (Integer.toString(x));
                            divisible = true;
                        }
                    }
                }
            }
            System.out.println(output);
        }
        scanner.close();
    }
}
