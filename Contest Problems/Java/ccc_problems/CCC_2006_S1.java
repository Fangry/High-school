package ccc_problems;

import java.util.Scanner;

public class CCC_2006_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mom = scanner.nextLine();
        String dad = scanner.nextLine();
        String combined = "";
        int numOfBabies = scanner.nextInt();
        String[] babies = new String[numOfBabies];
        for (int i = 0; i < babies.length; i++) {
            babies[i] = scanner.nextLine();
        }

        for (int i = 0; i < mom.length(); i += 2) {
            if (Character.isUpperCase(mom.charAt(i)) || Character.isUpperCase(dad.charAt(i))) {
                combined += Character.toUpperCase(mom.charAt(i));
            }
            if (Character.isLowerCase(mom.charAt(i)) || Character.isLowerCase(dad.charAt(i))) {
                combined += Character.toLowerCase(mom.charAt(i));
            }
        }
        System.out.println(combined);
        for (int i = 0; i < babies.length; i++) {
            boolean match = true;
            for(int j = 0; j < babies[i].length(); j++) {
                if(combined.indexOf(babies[i].charAt(j)) == -1) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println("Possible baby.");
            } else {
                System.out.println("Not their baby!");
            }
        }
        scanner.close();
    }
}

