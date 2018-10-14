package dmoj_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int layers = Integer.parseInt(reader.readLine());
            char[] process = reader.readLine().toCharArray();
            List<Integer> sandwich = new ArrayList<>();

            for (int i = 1; i < layers + 1; i++) {
                sandwich.add(i);
            }

            for (int i = 0; i < process.length; i++) {
                sandwich.remove(sandwich.indexOf(i + 1));
                if (process[i] -'0' == 0) {
                    sandwich.add(i + 1);
                } else {
                    sandwich.add(0, i + 1);
                }
            }

            for (Integer i : sandwich) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
