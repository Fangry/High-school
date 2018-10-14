package ccc_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCC_2013_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxWeight = Integer.parseInt(scanner.nextLine());
        int numCars = Integer.parseInt(scanner.nextLine());
        List<Integer> carsWeight = new ArrayList<>();

        for (int i = 0; i < numCars; i++) {
            carsWeight.add(Integer.parseInt(scanner.nextLine()));
        }

        int maxCars = 0;
        int currentWeight = 0;
        int carsPassed = 0;

        for (int i = 0; i < numCars; i++) {
            if (currentWeight < maxWeight) {
                currentWeight += carsWeight.get(i);
                System.out.println("Car " + i + " moves on the bridge");
            } else {
                currentWeight -= carsWeight.get(carsPassed);
                System.out.println("Car " + carsPassed + " moves off the bridge");
                carsPassed++;
                currentWeight += carsWeight.get(i);
                System.out.println("Car " + i + " moves on the bridge");
            }
            System.out.println("Current weight is: " + currentWeight);

            if(currentWeight > maxWeight) {
                System.out.println(i + " cars can cross.");
                return;
            }
        }
        scanner.close();
    }
}
