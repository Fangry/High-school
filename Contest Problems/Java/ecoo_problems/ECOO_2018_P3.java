package ecoo_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECOO_2018_P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nxyz = new int[4];
        String[] nxyzInput = scanner.nextLine().split(" ");
        String MATCH = "MATCH";
        boolean match = true; // if true, then print MATCH
        List<Integer> whichOneFailed = new ArrayList<>();

        for (int i = 0; i < nxyz.length; i++) { // populate nxyz array
            nxyz[i] = Integer.parseInt(nxyzInput[i]);
        }

        int[] codes = new int[nxyz[0]];
        int[] answers = new int[nxyz[0]];

        for (int i = 0; i < codes.length; i++) { // populate codes array
            codes[i] = Integer.parseInt(scanner.nextLine());
        }
        scanner.nextLine(); // skip one line
        for (int i = 0; i < answers.length; i++) {
            answers[i] = Integer.parseInt(scanner.nextLine());
        }
        scanner.nextLine(); // skip one line

        for (int i = 0; i < codes.length; i++) {
            char[] digits = String.valueOf(codes[i]).toCharArray(); // get each digits of each code
            List<Integer> list = new ArrayList<>(); // has to be flexible size unlike array
            for (char c : digits) { // populate list with digits
                list.add(Character.getNumericValue(c));
            }
            for (int j = 0; j < list.size(); j++) {
                int temp = list.get(j);
                if (temp == 0) { // 3 different cases
                    temp = nxyz[3];
                } else if (temp % 2 == 0) {
                    if (temp + nxyz[1] > 9) { // the point of using ArrayList, dealing with 2 digits
                        temp += nxyz[1];
                        temp = temp % 10; // get the ones place digit
                        list.add(1); // you know temp is between 10-18 (9+9), the tenth place digit is always 1
                    } else {
                        temp += nxyz[1];
                    }
                } else if (temp % 2 != 0) {
                    if (temp > nxyz[2] && j != 0) {
                        temp -= nxyz[2];
                    }
                }
                list.set(j, temp); // set it back
            }
            String temp = ""; // for concatenation
            for (int c : list) {
                temp += c;
            }
            codes[i] = Integer.parseInt(temp);
            if (codes[i] != answers[i]) {
                match = false;
                whichOneFailed.add(i); // add that to the FAIL list
            }
        }

        if (match) {
            System.out.println(MATCH);
        } else {
            System.out.print("FAIL: ");
            for(int i = 0; i < whichOneFailed.size(); i++) {
                System.out.print((whichOneFailed.get(i)+1));
                if(!(i == whichOneFailed.size()-1)) {
                    System.out.print(",");
                }
            }
        }
        scanner.close();
    }
}
