package ccc_problems;

import java.util.Arrays;
import java.util.Scanner;

public class CCC_2015_J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numMessages = Integer.parseInt(scanner.nextLine());
        String[] messages = new String[numMessages];
        int[] timeReceived = new int[101];
        int[] totalWaitTime = new int[101];
        int time = 0;

        for (int i = 0; i < numMessages; i++) {
            messages[i] = scanner.nextLine();
        }

        for (int i = 0; i < numMessages; i++) {
            String[] temp = messages[i].split(" ");
            char type = temp[0].charAt(0);
            Character nextType = ' ';
            int friend = Integer.parseInt(temp[1]) - 1;

            if (type == 'R') {
                timeReceived[friend] = time;
                time++;

            } else if (type == 'S') {
                totalWaitTime[friend] += time - timeReceived[friend];
                timeReceived[friend] = 0;
                time++;
            } else { // W
                time += friend; // in this case friend variable is time lapsed
            }

//            System.out.println(time);
//            System.out.println(Arrays.toString(timeReceived));
//            System.out.println(Arrays.toString(totalWaitTime));
//            System.out.println();
        }

        for (int i = 0; i < 101; i++) { // message that never being replied to
            if (timeReceived[i] > 0 && totalWaitTime[i] > 0) {
                totalWaitTime[i] = -1;
            }
        }

//        System.out.println(Arrays.toString(timeReceived));
//        System.out.println(Arrays.toString(totalWaitTime));
//        scanner.close();

        for (int i = 0; i < 101; i++) {
            if (totalWaitTime[i] != 0) {
                System.out.println(i + 1 + " " + totalWaitTime[i]);
            }
        }
    }
}
