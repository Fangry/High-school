package dmoj_problems;

import java.util.Scanner;

public class Sixteen_Bits_SW_Only {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++) {
            String output = "POSSIBLE DOUBLE SIGMA";
            String[] temp = scanner.nextLine().split(" ");
            long[] array = new long[3];
            for(int j = 0; j < 3; j++) {
                array[j] = Long.parseLong(temp[j]);
            }
            if(array[0]*array[1] != array[2]) {
                output = "16 BIT S/W ONLY";
            }
            System.out.println(output);
        }
        scanner.close();
    }
}
