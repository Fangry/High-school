package ccc_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCC_2012_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        List<Integer> arabicNums = new ArrayList<>();
        List<Integer> romanNums = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < chars.length; i += 2) {
            arabicNums.add(Character.getNumericValue(chars[i]));
        }
        for(int i = 1; i < chars.length; i+= 2) {
            if(chars[i] == 'I') {
                romanNums.add(1);
            } else if (chars[i] == 'V') {
                romanNums.add(5);
            } else if (chars[i] == 'X') {
                romanNums.add(10);
            } else if (chars[i] == 'L') {
                romanNums.add(50);
            } else if (chars[i] == 'C') {
                romanNums.add(100);
            } else if (chars[i] == 'D') {
                romanNums.add(500);
            } else if (chars[i] == 'M') {
                romanNums.add(1000);
            }
        }

        for(int i = 1; i < romanNums.size(); i++) {
            if(romanNums.get(i) > romanNums.get(i-1)) {
                sum -= arabicNums.get(i-1) * romanNums.get(i-1);
                //System.out.println(arabicNums.get(i-1) + " times " + romanNums.get(i-1) + " is subtracted");
            } else {
                sum += arabicNums.get(i-1) * romanNums.get(i-1);
                //System.out.println(arabicNums.get(i-1) + " times " + romanNums.get(i-1) + " is added");
            }
        }
        sum += arabicNums.get(arabicNums.size()-1) * romanNums.get(romanNums.size()-1);
        //System.out.println(arabicNums.get(arabicNums.size()-1) + " times " + romanNums.get(romanNums.size()-1) + " is added");

        System.out.println(sum);
        scanner.close();
    }
}
