package dmoj_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arranged_Marriage {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        long n = reader.nextLong();
        int b = reader.nextInt();
        int a = reader.nextInt();

        if (b == 0) {
            System.out.println(n * a);
        } else {
            double maxX = Math.rint((1.0 * b * n - a) / (2 * b * 1.0));
            long maxY = (long) ((a + b * maxX) * (n - maxX));
            //System.out.println(maxX);
            System.out.println(maxY);
        }
    }
}

 class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() {
        return Integer.parseInt(next());
    }
    long nextLong() {
        return Long.parseLong(next());
    }
    double nextDouble() {
        return Double.parseDouble(next());
    }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}