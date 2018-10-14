// unsolved
package ecoo_problems;

import java.util.Arrays;
import java.util.Scanner;

public class ECOO_2017_R1_P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            int numChoco = Integer.parseInt(scanner.nextLine());
            String[] names = new String[numChoco];
            int[] Pscores = new int[numChoco];
            int[] Fscores = new int[numChoco];
            int[] Gscores = new int[numChoco];
            for (int j = 0; j < numChoco; j++) {
                int counter = 0;
                while (true) {
                    String[] temp = scanner.nextLine().split(" ");
                    if (temp[0].equals("*")) {
                        break;
                    } else if (temp[0].equals("J")) {
                        Pscores[j] += Integer.parseInt(temp[1]);
                        Fscores[j] += Integer.parseInt(temp[2]) * 2;
                        Gscores[j] += Integer.parseInt(temp[3]) * 3;
                    } else {
                        counter++;
                        if (counter > 1) {
                            if (j != numChoco - 1) {
                                names[j + 1] = temp[0];
                            }
                            break;
                        }
                        names[j] = temp[0];
                    }
                }
            }

            int[] totalScores = new int[numChoco];
            for (int j = 0; j < numChoco; j++) {
                totalScores[j] += Pscores[j];
            }
            for (int j = 0; j < numChoco; j++) {
                totalScores[j] += Fscores[j];
            }
            for (int j = 0; j < numChoco; j++) {
                totalScores[j] += Gscores[j];
            }

            int max = totalScores[0];
            int winnerNum = 0;
            String winner = "";
            for (int j = 0; j < numChoco; j++) {
                if (totalScores[j] > max) {
                    max = totalScores[j];
                    winnerNum = j;
                    winner = names[j];
                } else if (totalScores[j] == max) {
                    if (Gscores[j] > Gscores[winnerNum]) {
                        winnerNum = j;
                        winner = names[j];
                    } else {
                        continue;
                    }
                    if (Fscores[j] > Fscores[winnerNum]) {
                        winnerNum = j;
                        winner = names[j];
                    } else {
                        continue;
                    }
                    if (Pscores[j] > Pscores[winnerNum]) {
                        winnerNum = j;
                        winner = names[j];
                    } else {
                        continue;
                    }
                }
            }

            //System.out.println(Arrays.toString(names));
            //System.out.println(Arrays.toString(totalScores));
            System.out.println(winner);

        }
        scanner.close();
    }
}
