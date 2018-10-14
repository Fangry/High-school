import java.util.Scanner;

public class CCC_2009_S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int small = scanner.nextInt();
        int big = scanner.nextInt();
        for(int i = small; i < big; i++) {
            boolean pow = false;
            boolean cube = false;
            for(int j = 0; j <Math.sqrt(big); j ++) {
                if(j*j == i) {
                    pow = true;
                }
            }
            for(int j = 0; j <Math.cbrt(big); j ++) {
                if(j*j*j == i) {
                    cube = true;
                }
            }
            if(pow && cube) {
                System.out.println(i);
            }
        }
    }
}
