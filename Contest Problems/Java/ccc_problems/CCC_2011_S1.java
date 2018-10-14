package ccc_problems;

import java.util.Scanner;

public class CCC_2011_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        String[] text = new String[lines+1];
        for(int i = 0; i < text.length; i++) {
            text[i] = scanner.nextLine();
        }
        int counter = 0;
        for(String s : text) {
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++) {
                if(chars[i] == 't' || chars[i] == 'T') {
                    counter ++;
                } else if(chars[i] == 's' || chars[i] == 'S') {
                    counter--;
                }
            }
        }
        if(counter > 0) {
            System.out.println("English");
        } else {
            System.out.println("French");
        }
        scanner.close();
    }
}
