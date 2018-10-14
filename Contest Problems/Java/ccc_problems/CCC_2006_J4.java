package ccc_problems;

import java.util.*;

public class CCC_2006_J4 {
    static int afterTasks[] = new int[8]; // tasks that have tasks to be done before them
    static boolean adjList[][] = new boolean[8][8]; // ignore 1st row and 1st column

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        add(1, 7);
        add(1, 4);
        add(2, 1);
        add(3, 4);
        add(3, 5);

        while (true) { // get rounding data
            int a = s.nextInt(), b = s.nextInt();
            if (a == 0 && b == 0) break;
            add(a, b);
        }
        /*
        for(int i = 1; i < adjList.length; i++) {
            for(int j = 1; j < adjList[0].length; j++) {
                System.out.print(adjList[i][j] + " ");
            }
            System.out.println();
        }
        */
        List<Integer> currentTask = new ArrayList<>();
        int counter = 0;
        String output = "";

        for (int i = 1; i <= 7; i++) { //skip first bc there is no task 0
            if (afterTasks[i] == 0) { // if the task can be done first
                currentTask.add(i);
                break; // take just one task bc prioritize smaller task#
            }
        }

        while (!currentTask.isEmpty()) { // while the current task is not done
            int copy = currentTask.get(0);
            currentTask.remove(0);

            output += Integer.toString(copy) + " ";
            counter++;
            afterTasks[copy]--; // one less task to do
            for (int i = 1; i <= 7; i++)
                if (adjList[copy][i]) // if there is a connection
                    afterTasks[i]--; // do that task
            for (int i = 1; i <= 7; i++)
                if (afterTasks[i] == 0) { // if required tasks are finished
                    currentTask.add(i); // do that task
                    break;
                }
        }

        if (counter == 7) {
            System.out.println(output);
        } else {
            System.out.println("Cannot complete these tasks. Going to bed.");
        }
    }

    public static void add(int task1, int task2) {
        afterTasks[task2]++;
        adjList[task1][task2] = true;
    }
}