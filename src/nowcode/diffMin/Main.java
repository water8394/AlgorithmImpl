package nowcode.diffMin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] inp = new long[n];
        for (int i = 0; i < n; i++) {
            inp[i] = sc.nextLong();
        }

        long[] ret = new long[2];
        long min = Long.MAX_VALUE;


        for (int i = 1; i < n; i++) {
            long diff = Math.abs(inp[i] - inp[i-1]);
            if (diff < min){
                min = diff;
                ret[0] = inp[i-1];
                ret[1] = inp[i];
            }
        }

        System.out.println(ret[0] + " " + ret[1]);

    }

}
