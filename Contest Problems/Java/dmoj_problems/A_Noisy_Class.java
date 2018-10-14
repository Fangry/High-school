package dmoj_problems;

import java.util.*;

public class A_Noisy_Class {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStudents = Integer.parseInt(scanner.nextLine());
        int numConnections = Integer.parseInt(scanner.nextLine());
        boolean[][] adjList = new boolean[numStudents][numStudents];
        int colLength = adjList.length;
        int rowLength = adjList[0].length;
        char output = 'Y';

        for (int i = 0; i < colLength; i++) { // set initially to false
            for (int j = 0; j < rowLength; j++) {
                adjList[i][j] = false;
            }
        }

        for (int i = 0; i < numConnections; i++) { // get rounding data
            String[] temp = scanner.nextLine().split(" ");
            adjList[Integer.parseInt(temp[0]) - 1][Integer.parseInt(temp[1]) - 1] = true;
        }

        List<Integer> candidates = new ArrayList<>(); //there may be many students to start
        for (int i = 0; i < colLength; i++) { // find which student to start
            int counter = 0;
            for (int j = 0; j < rowLength; j++) {
                if (!adjList[j][i]) { // check vertically
                    counter++;
                }
                if (counter == adjList.length) {
                    candidates.add(i);
                }
            }
        }
        int start = -1;
        List<Integer> path = new ArrayList<>();
        LinkedList<Integer> affected = new LinkedList<>();
        if (!candidates.isEmpty()) {
            start = Collections.min(candidates);
            path.add(start); // start with student with lowest number
        }
        boolean possible = true;
        if (path.isEmpty()) { // check to see if this is even possible bc. visited should have something
            output = 'N';
            possible = false;
        }

        while (true && possible) {
            findAffected(adjList, affected, path.get(path.size() - 1));
            if (affected.isEmpty()) {
                break;
            }
            whichOneToQuiet(adjList, affected);
            path.add(affected.poll());

           // System.out.println("affected " + affected);
           // System.out.println("path" + path);
           // System.out.println();
        }

        if (path.size() < numStudents) {
            output = 'N';
        }
        System.out.println(output);
        scanner.close();
    }

    public static void findAffected(boolean[][] adjList, List<Integer> affected, int start) {
        for (int i = 0; i < adjList.length; i++) { // find who are affected by this student
            if (adjList[start][i]) {
                affected.add(i);
                //System.out.println(i + " is added");
            }
        }
    }

    public static void whichOneToQuiet(boolean[][] adjList, List<Integer> affected) {
        List<Integer> scores = new ArrayList<>();
        for (int x : affected) {
            int tempScore = 0;
            for (int j = 0; j < adjList[x].length; j++) {
                if (adjList[j][x]) { // check vertically
                    tempScore++;
                }
            }
            scores.add(tempScore);
        }
        int record = Collections.min(scores);
        for (int i = 0; i < affected.size(); i++) {
            if (scores.indexOf(record) == i) {
                //System.out.println(i + " continued");
                continue;
            } else {
                //System.out.println(i + " removed");
                affected.remove(i);
            }
        }
    }

    public static void printAdjList(boolean[][] adjList) {
        for (boolean[] bb : adjList) {
            for (boolean b : bb) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
