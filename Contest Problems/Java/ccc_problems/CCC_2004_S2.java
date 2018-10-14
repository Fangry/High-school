package ccc_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CCC_2004_S2 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] inputs = reader.readLine().split(" ");
            int numPeople = Integer.parseInt(inputs[0]);
            int numRounds = Integer.parseInt(inputs[1]);
            int[] scores = new int[numPeople];
            int[] worstRank = new int[numPeople]; // store the worst rank of all players

            for (int i = 0; i < numPeople; i++) { //initialize arrays
                scores[i] = 0;
                worstRank[i] = 1;
            }

            for (int i = 0; i < numRounds; i++) { // add each round's scores
                String[] roundScores = reader.readLine().split(" ");
                for (int j = 0; j < numPeople; j++) {
                    scores[j] += (Integer.parseInt(roundScores[j])); // get inputs into arrays
                }

                int[] sorted = scores.clone(); // make a separate list
                Arrays.sort(sorted);

                for (int k = 0; k < numPeople; k++) {
                    int rank = numPeople;
                    for (int l = 0; l < numPeople; l++) {
                        if (scores[k] != sorted[l] || (l + 1 < numPeople && scores[k] == sorted[l+1])) { // 2nd condition checks if there is a tie between worst rank, if yes, still move up that player's rank
                            rank--;
                        } else {
                            if (rank > worstRank[k]) {
                                worstRank[k] = rank;
                            }
                        }
                    }
                }
                //System.out.println(Arrays.toString(worstRank));
            }

            int[] sorted = scores.clone();
            Arrays.sort(sorted);
            int bestScore = sorted[numPeople - 1];
            List<Integer> bestScorers = new ArrayList<>(); // there can be a tie, so a list is needed

            for (int i = 0; i < numPeople; i++) {
                if (bestScore == scores[i]) {
                    bestScorers.add(i); // add that best scorer to the list
                }
            }

            for (Integer i : bestScorers) {
                System.out.println("Yodeller " + (i + 1) + " is the TopYodeller: score " + bestScore + ", worst rank " + worstRank[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
