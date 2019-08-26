package book.online.minCoins;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = minCoin(arr, min);
        System.out.println(res);
    }
    public static int minCoin(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim == 0){
            return -1;
        }
        int n = arr.length;
        int[][] dp = new int[n+1][aim+1];
        for (int i = 1; i <= aim; i++) {
            dp[n][i] = -1;
        }
        for (int i = n-1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = -1;
                if (dp[i+1][rest] != -1){
                    dp[i][rest] = dp[i+1][rest];
                }
                if (rest - arr[i] >= 0 && dp[i][rest-arr[i]] != -1){
                    if (dp[i][rest] == -1){
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    }else {
                        dp[i][rest] = Math.min(dp[i][rest], dp[i][rest-arr[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }
}
