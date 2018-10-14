package dmoj_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class VM7WC_16_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int numHouses = Integer.parseInt(input[0]);
        int numRoads = Integer.parseInt(input[1]);
        int A = Integer.parseInt(input[2]);
        int B = Integer.parseInt(input[3]);
        boolean[][] map = new boolean[numHouses][numHouses];
        Stack<Integer> tracking = new Stack<>();
        List<Integer> visited = new ArrayList<>();
        String output = "NO SHAHIR!";

        for (int i = 0; i < numRoads; i++) {
            String[] temp = scanner.nextLine().split(" ");
            map[Integer.parseInt(temp[0]) - 1][Integer.parseInt(temp[1]) - 1] = true;
            map[Integer.parseInt(temp[1]) - 1][Integer.parseInt(temp[0]) - 1] = true;
        }

        tracking.push(A);
        visited.add(A);
        outer:
        while (!tracking.isEmpty()) {
            int current = tracking.peek();
            //System.out.println("current is " + current);
            for (int i = 0; i < numHouses; i++) {
                if (tracking.contains(B)) {
                    output = "GO SHAHIR!";
                    break outer;
                }
                if (map[current - 1][i] && !tracking.contains(i + 1) && !visited.contains(i + 1)) {
                    tracking.push(i + 1);
                    visited.add(i + 1);
                    //System.out.println("push " + (i + 1));
                    break;
                }
                if (i == numHouses - 1) {
                    //System.out.println("pop " + current);
                    tracking.pop();
                    break;
                }
            }
        }
    /*
        for (boolean[] bb : map) {
            for (boolean b : bb) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        */
        System.out.println(output);
        scanner.close();
    }
}
