package ccc_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCC_2012_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scorer = scanner.nextInt();
        int total = 0;
        List<Integer> players = new ArrayList<>();
        for (int i = 0; i < scorer; i++) {
            players.add(i + 1);
        }
        for (int f = 0; f < players.size()-1; f++) {
            for (int s = f; s < players.size()-1; s++) {
                for (int t = f; t < players.size()-1; t++) {
                    if(f < s && s < t) {
                        total++;
                    }

                }
            }
        }
        System.out.println(total);
        scanner.close();
    }
}
