package dmoj_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lowest_Exam_Mark {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            double current = Integer.parseInt(reader.readLine());
            double desire = Integer.parseInt(reader.readLine());
            double weight = Integer.parseInt(reader.readLine()) / 100.0;
            double exam = (desire - current + current * weight) / weight;
            if (exam < 0) {
                exam = 0;
            }

            if (desire - (current - current * weight + weight * 100) > 0.5) {
                System.out.println("DROP THE COURSE");
            } else {
                if (exam > 100) {
                    System.out.println(100);
                } else {
                    System.out.println((int) exam);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
