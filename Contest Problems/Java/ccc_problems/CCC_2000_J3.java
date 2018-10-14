package ccc_problems;
import java.util.Scanner;

public class CCC_2000_J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCoins = scanner.nextInt();
        int machine1 = scanner.nextInt();
        int machine2 = scanner.nextInt();
        int machine3 = scanner.nextInt();
        int timesPlayed = 0;

        while (numCoins >= 0) {
            machine1++;
            timesPlayed++;
            if (machine1 == 35) {
                machine1 = 0;
                numCoins += 30;
            }
            numCoins--;
            if(numCoins == 0) {
                break;
            }

            machine2++;
            timesPlayed++;
            if (machine2 == 100) {
                machine2 = 0;
                numCoins += 60;
            }
            numCoins--;
            if(numCoins == 0) {
                break;
            }

            machine3++;
            timesPlayed++;
            if (machine3 == 10) {
                machine3 = 0;
                numCoins += 9;
            }
            numCoins--;
            if(numCoins == 0) {
                break;
            }
        }
        System.out.println("Martha plays " + timesPlayed + " times before going broke.");
        scanner.close();
    }
}
