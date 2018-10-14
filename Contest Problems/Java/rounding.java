
public class rounding {
    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.2;
        double c = 0.300000001;
        int sigFig = 10;

        if ((a + b - c < Math.pow(10, -sigFig) && (a + b - c > -Math.pow(10, -sigFig)))) {
            System.out.println("equal");
        } else{
            System.out.println("not equal");
        }
    }
}
