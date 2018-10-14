package ccc_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCC_2015_S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gates = Integer.parseInt(scanner.nextLine());
        int planes = Integer.parseInt(scanner.nextLine());
        List<Integer> availableGates = new ArrayList<>();
        List<Integer> availablePlanes = new ArrayList<>();
        int output = 0;

        for (int i = 0; i < gates; i++) {
            availableGates.add(i + 1);
        }
        for (int i = 0; i < planes; i++) {
            availablePlanes.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < availablePlanes.size(); i++) {
            //System.out.println("Gates: " + availableGates);
            //System.out.println("Planes: " + availablePlanes);
            int numOfOptions = availablePlanes.get(i);
            for (int j = numOfOptions; j > 0; j--) {
                if (availableGates.contains(j)) {
                    availablePlanes.remove(i);
                    availableGates.remove(availableGates.indexOf(j));
                    output++;
                    //System.out.println("Plane " + numOfOptions + " lands in gate " + (j));
                    break;
                }
            }
        }
        System.out.println(output);
        scanner.close();
    }
}
