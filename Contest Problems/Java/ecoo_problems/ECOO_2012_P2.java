package ecoo_problems;

import java.util.Scanner;

public class ECOO_2012_P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = new String[3];
        String promoter = "TATAAT";
        for (int i = 0; i < 3; i++) {
            inputs[i] = scanner.nextLine();
        }

        for (int i = 0; i < 3; i++) {
            int promoterEnd = StringChecker(inputs[i], promoter, 0);
            int terminatorStart = repeatChecker(inputs[i], 6, promoterEnd);
            String RNA = DNAinverse(inputs[i].substring(promoterEnd, terminatorStart), true);

            System.out.println(promoterEnd);
            System.out.println(terminatorStart);
            System.out.println(RNA);
        }
        scanner.close();
    }

    public static int StringChecker(String input, String toCheck, int start) {
        int result = -1, counter = 0;
        for (int i = start; i < input.length(); i++) {
            if (input.charAt(i) == toCheck.charAt(counter)) {
                counter++;
            } else {
                if (counter > 0) {
                    i -= counter;
                }
                counter = 0;
            }
            if (counter == toCheck.length()) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static int repeatChecker(String input, int minLen, int start) {
        int result = -1;
        for (int i = start; i < input.length(); i++) {
            String temp = "";
            for (int j = i; j < input.length(); j++) {
                if (temp.length() < minLen) {
                    temp += input.charAt(j);
                } else {
                    break;
                }
            }
            result = StringChecker(input, DNAinverse(temp, false), i);
            if (result > 0) {
                break;
            }
            minLen++;
        }
        return result;
    }

    public static String DNAinverse(String input, boolean RNA) {
        String result = "";
        if (RNA) {
            for (int i = 0; i < input.length(); i++) {
                char temp = input.charAt(i);
                if (temp == 'A') {
                    temp = 'U';
                } else if (temp == 'T') {
                    temp = 'A';
                } else if (temp == 'C') {
                    temp = 'G';
                } else if (temp == 'G') {
                    temp = 'C';
                }
                result += temp;
            }
        } else {
            for (int i = input.length() - 1; i >= 0; i--) {
                char temp = input.charAt(i);
                if (temp == 'A') {
                    temp = 'T';
                } else if (temp == 'T') {
                    temp = 'A';
                } else if (temp == 'C') {
                    temp = 'G';
                } else if (temp == 'G') {
                    temp = 'C';
                }
                result += temp;
            }
        }
        return result;
    }
}
