package ccc_problems;

import java.util.Scanner;

public class CCC_2013_S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int favTeam = Integer.parseInt(scanner.nextLine());
        final int gamesAlreadyPlayed = Integer.parseInt(scanner.nextLine());
        int[] scores = new int[4];
        int[] gamesPlayed = new int[4];
        int outcomes = 0;

        for (int i = 0; i < gamesAlreadyPlayed; i++) { // get game data
            String[] dataString = scanner.nextLine().split(" ");
            int[] dataInt = new int[dataString.length]; // convert string array to int array
            for (int j = 0; j < dataInt.length; j++) { // populate data array
                dataInt[j] = Integer.parseInt(dataString[j]);
            }
            if (dataInt[2] > dataInt[3]) { // if team A beats team B
                scores[dataInt[0] - 1] += 3;
            } else if (dataInt[2] == dataInt[3]) { // if team A ties with team B
                scores[dataInt[0] - 1]++;
                scores[dataInt[1] - 1]++;
            } else { // if team A loses to team B
                scores[dataInt[1] - 1] += 3;
            }
            gamesPlayed[dataInt[0] - 1]++; // record which team played
            gamesPlayed[dataInt[1] - 1]++;
        }

        System.out.println(outcomes);
        scanner.close();
    }
}

