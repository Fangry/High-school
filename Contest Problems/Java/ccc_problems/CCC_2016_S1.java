package ccc_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CCC_2016_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] firstLine = scanner.nextLine().toCharArray();
        char[] secondLine = scanner.nextLine().toCharArray();
        Arrays.sort(firstLine);
        Arrays.sort(secondLine);
        int numOfAsterisks = 0;
        char output = 'A';

        for (int i = 0; i < secondLine.length; i++) {
            if (secondLine[i] == '*') {
                numOfAsterisks++;
            }
        }

        List lishighest = new ArrayList();
        List lissecondHighest = new ArrayList();
        for (int i = 0; i < firstLine.length; i++) {
            lishighest.add(firstLine[i]);
            lissecondHighest.add(secondLine[i]);
        }

        for (int x = 0; x < lishighest.size(); x++) {
            for (int i = 0; i < lishighest.size(); i++) {
                for (int j = 0; j < lissecondHighest.size(); j++) {
                    if (lishighest.get(i) == lissecondHighest.get(j)) {
                        lishighest.remove(i);
                        lissecondHighest.remove(j);
                    }
                }
            }
        }

        if (lishighest.size() > numOfAsterisks) {
            output = 'N';
        }

        System.out.println(output);
        scanner.close();

    }
}

