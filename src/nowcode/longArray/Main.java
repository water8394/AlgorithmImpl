package nowcode.longArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
        }
        String ret = "";
        for (int k = 1; k <= n; k++) {
            List<Long> list = new ArrayList<>();

            if ( k == x.length){
                long max = Long.MIN_VALUE;
                for (int i = 0; i < k; i++) {
                    max = Math.max(x[i], max);
                }
                ret += String.valueOf(max)+" ";
            }else{

                for (int i = 0; i < x.length - k; i++) {
                    long max = Long.MIN_VALUE;
                    for (int j = i; j < i+k; j++) {
                        max = Math.max(max, x[j]);
                    }
                    list.add(max);
                }
                long min = Long.MAX_VALUE;
                for (int i = 0; i < list.size(); i++) {
                    min = Math.min(list.get(i),min);
                }
                ret += String.valueOf(min) + " ";
            }

        }
        System.out.println(ret);
    }

}
