package nowcode.score;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int min = Integer.MAX_VALUE;
                int total = 0;
                for (int k = j; k < j+i; k++) {
                    min = Math.min(w[k], min);
                    total += w[k];
                }
                ans = Math.max(total*min, ans);
            }
        }
        System.out.println(ans);

    }
}
