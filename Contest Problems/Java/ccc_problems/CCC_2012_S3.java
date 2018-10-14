package ccc_problems;

import java.util.Scanner;

public class CCC_2012_S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] freq = new int[1001];
        int highest = 0, secondHighest = 0, out = 0;

        for (int i = 0; i < num; i++) { // get data
            freq[sc.nextInt()]++;
        }

        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i]);
            if (freq[i] > freq[highest]) {
                secondHighest = highest; // update secondHighest
                highest = i; // set record higher
            } else if (freq[i] >= freq[secondHighest]) {
                secondHighest = i;
            }
        }

        if (freq[highest] == freq[secondHighest]) { // if there's a tie
            int min = out;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] == freq[highest]) { // locate freq[highest]
                    if (min == out) {
                        min = i; // set min to first value of array
                    } else {
                        out = i - min;
                    }
                }
            }
        } else {
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] == freq[secondHighest]) { // find any 2nd places
                    out = Math.max(out, Math.abs(highest - i)); //absolute difference between the two most frequent readings
                }
            }
        }
        System.out.println(out);
    }
}