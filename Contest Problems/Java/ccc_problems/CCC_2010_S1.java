package ccc_problems;

import java.util.*;

public class CCC_2010_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howMany = Integer.parseInt(scanner.nextLine());
        List<Map<String, String>> computer = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            String[] split = scanner.nextLine().split(" ");
            Map<String, String> temp = new HashMap<>();
            temp.put("name", split[0]);
            temp.put("RAM", split[1]);
            temp.put("CPU", split[2]);
            temp.put("disk", split[3]);
            int score = 2 * Integer.parseInt(split[1]) + 3 * Integer.parseInt(split[2]) + Integer.parseInt(split[3]);
            temp.put("score", Integer.toString(score));
            computer.add(temp);
        }
        for (Map m : computer) {
            System.out.println(m);
        }
        String name = "";
        int record = 0;
        for(int i = 0; i < computer.size(); i++) {
            int score = Integer.parseInt(computer.get(i).get("score"));
            for(int j = 0; j < computer.size(); j++) {
                int score2 = Integer.parseInt(computer.get(i).get("score"));
                record = Math.max(score, score2);
                name = computer.get(i).get("name");
            }
        }
        System.out.println(name + " " + record);
    }
}
