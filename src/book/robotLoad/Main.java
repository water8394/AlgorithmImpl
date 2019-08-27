package book.robotLoad;

public class Main {
    public static void main(String[] args) {

    }

    public int way(int n, int m, int k, int p){
        if (n < 2 || k < 1 || m < 1 || m > n || p < 1 || p>n){
            return 0;
        }
        int[][] dp = new int[k+1][n+1];
        dp[0][p] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n ; j++) {
                if (j==1){
                    dp[i][j] = dp[i-1][2];
                }else if (j==n){
                    dp[i][j] = dp[i-1][n-1];
                }else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
            }
        }
        return dp[k][m];
    }
}
