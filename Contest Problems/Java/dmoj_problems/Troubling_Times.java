package dmoj_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Troubling_Times {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numIntervals = scanner.nextInt();
        int destination = scanner.nextInt();
        scanner.nextLine();
        List<Integer> intervals = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");
        String output = "This is not the best time for a trip.";

        for (int i = 0; i < numIntervals; i++) {
            int temp = Integer.parseInt(input[i]);
            if (destination % temp == 0) {
                intervals.add(temp);
            }
        }

        int record = 1000;
        for (int i = 0; i < intervals.size(); i++) {
            int trial = Math.abs(destination / intervals.get(i));
            if (trial < record) {
                record = trial;
                output = Integer.toString(record);
            }
        }

        System.out.println(output);
        scanner.close();
    }
}
