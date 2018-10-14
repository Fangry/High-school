package ccc_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CCC_2018_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        ArrayList<Float> villages = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            villages.add(scanner.nextFloat());
        }
        Collections.sort(villages);

        ArrayList<Float> size = new ArrayList<>();
        ArrayList<Float> combined = new ArrayList<>();

        for (int i = 0; i < villages.size() - 1; i++) {
            size.add((villages.get(i + 1) - villages.get(i)) / 2);
        }
        for (int i = 0; i < size.size() - 1; i++) {
            combined.add(size.get(i) + size.get(i + 1));
        }

        //System.out.println(villages);
        //System.out.println(size);
        //System.out.println(combined);

        System.out.println(Collections.min(combined));
    }
}
