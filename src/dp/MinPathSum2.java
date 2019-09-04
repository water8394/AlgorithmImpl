package dp;

import java.util.Scanner;

public class MinPathSum2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = 1;
            }
        }
        map[0][0] = 0;
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = Integer.MAX_VALUE;
        }
        int ans = minPathSum(map);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        }else{
            System.out.println(ans);
        }
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j==0){
                    dp[j] = dp[j];
                }else if (i == 0){
                    dp[j] = dp[j-1];
                }else {
                    dp[j] = Math.min(dp[j-1],dp[j]);
                }
                if (grid[i][j] == Integer.MAX_VALUE){
                    dp[j] = Integer.MAX_VALUE;
                }else{
                    dp[j] = dp[j] < Integer.MAX_VALUE ?  dp[j]+ grid[i][j] : dp[j];
                }
            }
        }
        return dp[n-1];
    }
}
