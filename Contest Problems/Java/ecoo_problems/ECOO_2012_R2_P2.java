package ecoo_problems;

import java.util.Scanner;

public class ECOO_2012_R2_P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] passwords = new String[10];
        int[] scores = new int[10];
        for (int i = 0; i < 10; i++) {
            passwords[i] = scanner.nextLine();
        }

        for (int i = 0; i < 10; i++) {
            String current = passwords[i];
            if (current.length() >= 8) { // min. 8 chars long
                scores[i] += 2;
            }
            int numUpper = 0, numLower = 0, numDigit = 0, numSym = 0;
            int numDigitNotMid = 0, numSymNotMid = 0;
            int upperCounter = 0, lowerCounter = 0, digitCounter = 0;
            int upperConsec = 0, lowerConsec = 0, digitConsec = 0;
            int sequenLetter = 0, sequenDigit = 0;
            for (int j = 0; j < current.length(); j++) {
                scores[i] += 4; // length
                if (Character.isLowerCase(current.charAt(j))) { // how many uppercase
                    numLower++;
                    lowerCounter++;
                    if (lowerCounter == 2) {
                        lowerConsec++;
                        lowerCounter = 0;
                    }
                    upperCounter = 0;
                    digitCounter = 0;

                } else if (Character.isUpperCase(current.charAt(j))) { // how many lowercase
                    numUpper++;
                    upperCounter++;
                    if (upperCounter == 2) {
                        upperConsec++;
                        upperCounter = 0;
                    }
                    lowerCounter = 0;
                    digitCounter = 0;

                } else if (Character.isDigit(current.charAt(j))) {
                    numDigit++;
                    if (j == 0 || (j == current.length() - 1)) {
                        numDigitNotMid++;
                    }
                    digitCounter++;
                    if (digitCounter == 2) {
                        digitConsec++;
                        digitCounter = 0;
                    }
                    lowerCounter = 0;
                    upperCounter = 0;
                } else {
                    numSym++;
                    if (j == 0 || (j == current.length() - 1)) {
                        numSymNotMid++;
                    }
                }
            }
            if (numLower != 0) { // whether password contains lowercase
                scores[i] += 2;
                scores[i] += (current.length() - numLower) * 2;
            }
            if (numUpper != 0) { // whether password contains uppercase
                scores[i] += 2;
                scores[i] += (current.length() - numUpper) * 2;
            }
            if (numDigit < current.length()) { // num of digits
                scores[i] += 4 * numDigit;
            }
            scores[i] += 6 * numSym;
            scores[i] += 2 * (numDigit + numSym - numDigitNotMid - numSymNotMid); // middle digits/symbols
            if (numLower + numUpper == current.length() - 1) { // only letters
                scores[i] -= (numLower + numUpper);
            }
            if (numDigit == current.length() - 1) { // only digits
                scores[i] -= numDigit;
            }
            scores[i] -= 2 * (upperConsec - 1); // subtract consecutive
            scores[i] -= 2 * (lowerConsec - 1);
            scores[i] -= 2 * (digitConsec - 1);
            scores[i] -= 3 * (sequenLetter - 2); // subtract sequence
            scores[i] -= 3 * (sequenDigit - 2);
        }

        for (int i : scores) {
            System.out.println(i);
        }

        scanner.close();
    }
}
