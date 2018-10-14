package ccc_problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CCC_2008_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> temperatures = new LinkedHashMap<>();
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            if (temp.equals("")) {
                break;
            }
            String[] input = temp.split(" ");
            temperatures.put(input[0], Integer.parseInt(input[1]));
        }
        System.out.println(temperatures);
        String name = "";
        int coldest = temperatures.entrySet().iterator().next().getValue();
        for (Map.Entry<String, Integer> entry : temperatures.entrySet()) {
            String key = entry.getKey();
            int temperature = entry.getValue();
            if (temperature < coldest) {
                coldest = temperature;
                name = key;
            }
        }
        System.out.println(name);
        //System.out.println(coldest);
    }
}
