package nowcode.coinNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] ss = s.substring(1, s.length()-1).split(",");
        int[] nums = new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(ss[i]);
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int coin :nums){
            for (int i = coin; i <= n ; i++) {
                dp[i] += dp[i-coin];

            }
        }
        System.out.println(dp[n]);
    }
}
