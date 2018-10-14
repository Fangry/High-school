package ccc_problems;

import java.util.Scanner;
import java.util.Stack;

public class CCC_2014_S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numTests; i++) { // repeat for every tests
            int numOfTrains = Integer.parseInt(scanner.nextLine());
            Stack<Integer> mountain = new Stack<>();
            Stack<Integer> branch = new Stack<>();
            int[] lake = new int[numOfTrains];
            String output = "Y";

            for (int j = 0; j < numOfTrains; j++) { // all trains start initially on mountain
                mountain.push(Integer.parseInt(scanner.nextLine()));
            }
            System.out.println("initial: " + mountain);
            int record = 1;

            while(true) {
                if (!mountain.isEmpty() && mountain.peek() == record) { // trains on mountain go straight away to lake
                    lake[record - 1] = record;
                    mountain.pop();
                    record++;
                } else if (!branch.isEmpty() && branch.peek() == record) { // trains on branch go to lake
                    lake[record - 1] = record;
                    branch.pop();
                    record++;
                } else if (!mountain.isEmpty()) {
                    branch.push(mountain.peek());
                    mountain.pop();
                } else {
                    break;
                }
                ///*
            System.out.println("mountain " + mountain);
            System.out.println("branch " + branch);
            System.out.print("lake :");
            for (int x : lake) {
                System.out.print(x + ",");
            }
            System.out.println();
            //*/
        }

            for (int l = 0; l < lake.length - 1; l++) { // check to see if trains in order
                if (!(lake[l] < lake[l + 1])) {
                    output = "N";
                }
            }
            System.out.println(output);
        }
        scanner.close();
    }
}
