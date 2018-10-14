package ccc_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CCC_2008_S3 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < cases; i++) {
                int row = Integer.parseInt(reader.readLine());
                int col = Integer.parseInt(reader.readLine());
                char[][] map = new char[row][col];
                List<Integer> queue = new ArrayList<>();
                List<Integer> visitedX = new ArrayList<>();
                List<Integer> visitedY = new ArrayList<>();
                int output = -1;

                for (int j = 0; j < row; j++) { // get input data
                    map[j] = reader.readLine().toCharArray();
                }

                visitedY.add(0); // starting point
                visitedX.add(0);
                whereToGo(map, 0, 0, queue, visitedY, visitedX);

                while (!queue.isEmpty()) {
                    if (visitedY.contains(map.length - 1) && visitedX.contains(map[0].length - 1)) {
                        output = visitedY.size();
                        break;
                    }
                    int headY = queue.get(0);
                    queue.remove(0);
                    int headX = queue.get(0);
                    queue.remove(0);
                    if (!(visitedY.contains(headY) && visitedX.contains(headX))) {
                        visitedY.add(headY);
                        visitedX.add(headX);
                    }
                    whereToGo(map, headY, headX, queue, visitedY, visitedX);
                }
                System.out.println(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // right = 1    up = 2      left = 3        down = 4
    public static List<Integer> directions(char c) {
        List<Integer> output = new ArrayList<>();
        if (c == '+') {
            for (int i = 1; i < 5; i++) {
                output.add(i);
            }
        } else if (c == '-') {
            output.add(1);
            output.add(3);
        } else if (c == '|') {
            output.add(2);
            output.add(4);
        }
        return output;
    }

    public static void whereToGo(char[][] map, int y, int x, List queue, List visitedY, List visitedX) {
        List<Integer> current = directions(map[y][x]);
        if (x < map[0].length - 1) {
            if (current.contains(1) && map[y][x + 1] != '*' && !(visitedY.indexOf(y) == visitedX.indexOf(x + 1))) { // right
                queue.add(y);
                queue.add(x + 1);
                //System.out.println("right");
            }
        }
        if (y > 0) {
            if (current.contains(2) && map[y - 1][x] != '*' && !(visitedY.indexOf(y - 1) == visitedX.indexOf(x))) { // up
                queue.add(y - 1);
                queue.add(x);
                //System.out.println("up");
            }
        }
        if (x > 0) {
            if (current.contains(3) && map[y][x - 1] != '*' && !(visitedY.indexOf(y) == visitedX.indexOf(x - 1))) { // left
                queue.add(y);
                queue.add(x - 1);
                //System.out.println("left");
            }
        }
        if (y < map.length - 1) {
            if (current.contains(4) && map[y + 1][x] != '*' && !(visitedY.indexOf(y + 1) == visitedX.indexOf(x))) { // down
                queue.add(y + 1);
                queue.add(x);
                //System.out.println("down");
            }
        }
        /*
        System.out.println("queue: " + queue);
        System.out.println("visitedY: " + visitedY);
        System.out.println("visitedX: " + visitedX);
        System.out.println();
        */
    }
}