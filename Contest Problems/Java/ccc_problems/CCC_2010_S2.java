package ccc_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCC_2010_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfIndex = Integer.parseInt(scanner.nextLine());
        List<Character> index = new ArrayList<>();
        List<String> values = new ArrayList<>();

        for (int i = 0; i < numOfIndex; i++) {
            String temp = scanner.nextLine();
            index.add(temp.charAt(0));
            values.add(temp.substring(2));
        }
        String sequence = scanner.nextLine();
        String answer = "";

        int counter;
        while (sequence.length() > 0) {
            counter = 0;
            while (!sequence.startsWith(values.get(counter))) { // skip this value
                counter++;
            }
            answer += index.get(counter);
            sequence = sequence.substring(values.get(counter).length());
        }

        System.out.println(answer);
        scanner.close();
    }
}
