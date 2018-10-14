package random_stuff;

public class Averager2 {
    public static void main(String[] args) {
        System.out.println(average(1, 2.50, 3, 5, 7.6436));
    }

    public static double average(double... nums) {
        double total = 0;
        for (double x : nums) {
            total += x;
        }
        return total / nums.length;
    }
}

