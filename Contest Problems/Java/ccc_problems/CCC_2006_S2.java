package ccc_problems;

import java.util.HashMap;
import java.util.Scanner;

public class CCC_2006_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plainText = scanner.nextLine().toString();
        String cipherText = scanner.nextLine().toString();
        String goalText = scanner.nextLine().toString();
        StringBuilder resultText = new StringBuilder(goalText); // change it according to what we know
        HashMap<Character, Character> letterList = new HashMap();

        for (int i = 0; i < plainText.length(); i++) { // gather the letters available to us
            letterList.put(cipherText.charAt(i),plainText.charAt(i));
        }
        for (int i = 0; i < resultText.length(); i++) {
            if (letterList.containsKey(goalText.charAt(i))) {
                resultText.setCharAt(i, letterList.get(goalText.charAt(i)));
            } else {
                resultText.setCharAt(i, '.');
            }
        }
        System.out.println(resultText);
        scanner.close();
    }
}
