package dp;

public class JumpFloorBT {
    private int JumpFloorII(int target) {
        if (target <= 2) return target;
        int[] dp = new int[target];
        dp[0] = 1; dp[1] = 2;
        for (int i = 2; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
            dp[i] ++;
        }
        return dp[target-1];
    }

    public static void main(String[] args) {
        JumpFloorBT sol= new JumpFloorBT();
        System.out.println(sol.JumpFloorII(4));
    }
}
