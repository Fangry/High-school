package ccc_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCC_2014_S1 {
    public static void main(String[] args) {
        //method1();
        method2();
    }

    private static void method1() {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int rounds = scanner.nextInt();
        int[] remove = new int[rounds];
        for (int i = 0; i < rounds; i++) {
            remove[i] = scanner.nextInt();
        }
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i < total; i++) {
            friends.add(i);
        }
        for (int i = 0; i < remove.length; i++) {
            System.out.println(friends);
            for (int j = remove[i] - 1; j < friends.size(); j += remove[i] - 1) {
                friends.remove(j);
            }
        }
        System.out.println(friends);
        scanner.close();
    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int rounds = scanner.nextInt();
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i < total; i++) {
            friends.add(i);
        }
        System.out.println(friends);
        for (int i = 0; i < rounds; i++) {
            int remove = scanner.nextInt();
            int count = 0;
            for (int j = 1; j < friends.size(); j++) {
                count++;
                if(count%(remove-1) == 0) {
                    friends.remove(j);
                }
            }
            System.out.println(friends);
        }
        scanner.close();
    }
}
