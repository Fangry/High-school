package dmoj_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Binary {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(reader.readLine());
            StringBuilder[] output = new StringBuilder[cases];
            for (int i = 0; i < cases; i++) {
                output[i] = new StringBuilder("");
            }

            for (int i = 0; i < cases; i++) {
                int deci = Integer.parseInt(reader.readLine());
                output[i].append(Integer.toBinaryString(deci));

                int front = output[i].length() % 4;
                if (front != 0) {
                    for (int j = 0; j < 4 - front; j++) {
                        output[i].insert(0, "0");
                    }
                }

                int counter = 0;
                for (int j = output[i].length() - 1; j >= 1; j--) {
                    counter++;
                    if (counter == 4) {
                        output[i].insert(j, " ");
                        counter = 0;
                    }
                }
            }

            for (StringBuilder s : output) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
