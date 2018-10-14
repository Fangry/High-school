package dmoj_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class List_Minimum {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int totalNum = Integer.parseInt(reader.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < totalNum; i++) {
                list.add(Integer.parseInt(reader.readLine()));
            }
            Collections.sort(list);
            for (Integer i : list) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
