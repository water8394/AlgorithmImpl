package nowcode.password;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = Integer.MAX_VALUE;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = lowerBound(g, 1, n, arr[i]);
            g[k] = arr[i];
            ans = Math.max(ans, k);
        }

        System.out.println(ans);
    }

    private static int lowerBound(int[] nums, int l, int r, int v) {
        while (l < r){
            int m = l + (r-l)/2;
            if (nums[m] >= v){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}
