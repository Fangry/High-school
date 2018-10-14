package ccc_problems;

import java.util.Scanner;

public class CCC_2011_S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfQuestions = Integer.parseInt(scanner.nextLine());
        char[] student = new char[numOfQuestions];
        char[] answers = new char[numOfQuestions];
        int counter = 0;

        for(int i = 0; i < student.length; i++) {
            student[i] = scanner.nextLine().charAt(0);
        }
        for(int i = 0; i < answers.length; i++) {
            answers[i] = scanner.nextLine().charAt(0);
        }
        for(int i = 0; i < student.length; i++) {
            if(student[i] == answers[i]) {
                counter ++;
            }
        }
        System.out.println(counter);
        scanner.close();
    }
}
