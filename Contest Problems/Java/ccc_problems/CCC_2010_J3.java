package ccc_problems;

import java.util.Scanner;

public class CCC_2010_J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = 0;
        int B = 0;

        while (scanner.hasNextLine()) {
            String[] inputs = scanner.nextLine().split(" ");
            int operation = Integer.parseInt(inputs[0]);
            if (operation == 7) {
                break;
            }
            char var = inputs[1].charAt(0);
            String var2 = null;
            if (inputs.length > 2) {
                var2 = inputs[2];
            }
            switch (operation) {
                case 1:
                    if (var == 'A') {
                        A = Integer.parseInt(var2);
                    } else {
                        B = Integer.parseInt(var2);
                    }
                    break;
                case 2:
                    System.out.println((var == 'A') ? A : B);
                    break;
                case 3:
                    if (var == 'A') {
                        if (var2.charAt(0) == 'A') {
                            A += A;
                        } else {
                            A += B;
                        }
                    } else {
                        if (var2.charAt(0) == 'B') {
                            B += B;
                        } else {
                            B += A;
                        }
                    }
                    break;
                case 4:
                    if (var == 'A') {
                        if (var2.charAt(0) == 'A') {
                            A *= A;
                        } else {
                            A *= B;
                        }
                    } else {
                        if (var2.charAt(0) == 'B') {
                            B *= B;
                        } else {
                            B *= A;
                        }
                    }
                    break;
                case 5:
                    if (var == 'A') {
                        if (var2.charAt(0) == 'A') {
                            A = 0;
                        } else {
                            A -= B;
                        }
                    } else {
                        if (var2.charAt(0) == 'B') {
                            B = 0;
                        } else {
                            B *= A;
                        }
                    }
                    break;
                case 6:
                    if (var == 'A') {
                        if (var2.charAt(0) == 'A') {
                            A = 1;
                        } else {
                            A /= B;
                        }
                    } else {
                        if (var2.charAt(0) == 'B') {
                            B = 1;
                        } else {
                            B /= A;
                        }
                    }
                    break;
            }
            //System.out.println(A + " " + B);
        }
        scanner.close();
    }
}
