package nowcode.talkpassword;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        char[] arr = s.toCharArray();

        int[] ret = new int[n];

        for (int i = 0; i < n; i++) {
            char t = '0';
            int kk = k-1;
            for (int j = i-1; j >= 0 && kk>0 ; j--) {
                t ^= ret[j];
                kk--;
            }
            ret[i] = t ^ arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ret) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
