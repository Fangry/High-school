package ccc_problems;

import java.util.Scanner;
import java.util.Stack;

public class CCC_2015_S1 {
    public static void main(String[] args) {
        //method 1: populate the stack first and then manage it
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num; i++) {
            stack.push(scanner.nextInt());
        }
        int total = -stack.elementAt(0);
        while (!stack.isEmpty()) {
            boolean zero = false;
            int howManyZeros = 0;
            do {
                zero = (stack.peek() == 0);
                if (zero) {
                    howManyZeros++;
                    stack.pop();
                }
            } while (zero);
            for (int i = 0; i < howManyZeros; i++) {
                stack.pop();
            }
            total += stack.peek();
            stack.pop();
        }
        System.out.println(total);
        scanner.close();

        //method 2:  more efficient, manage stack as you are populating it
        /*
        Scanner scanner = new Scanner ((System.in));
        int dictated = scanner.nextInt();
        Stack a = new Stack<Integer>();
        for(int i = 0; i < dictated; i++){
            int num = scanner.nextInt();
            if (num == 0){
                a.pop();
            }
            else{
                a.push(num);
            }
        }
        Integer sum = 0;
        while(!a.isEmpty()){
            sum += (Integer)a.pop();
        }
        System.out.println(sum);

*/
    }
}
