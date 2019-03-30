package dp;

import java.util.Arrays;

public class CoinsNum {
    public int coinChange(int[] coins, int amount) {
        System.out.println("============");
        Arrays.sort(coins);
        int val = -1;
        if (amount==0) return 0;
        if (coins.length == 0) return -1;
        if (coins.length == 1 && amount%coins[0] != 0) return -1;
        for (int i = coins.length-1; i >= 0; i--){
            System.out.println("i:"+i);
            System.out.println("coin:"+coins[i]);
            if (coins[i] <= amount){
                val = amount/coins[i];
                int remain = amount - val * coins[i];
                System.out.println("remain: "+remain);
                if (remain==0) return val;
                int ret = coinChange(Arrays.copyOfRange(coins, 0, i), remain);
                if (ret != -1){
                    val += ret;
                    return val;
                }else{
                    val = -1;
                }
            }
        }
        return val;
    }
    public static void main(String[] args) {

        CoinsNum sol = new CoinsNum();
        int[] test = new int[]{186, 419, 83, 408};
        System.out.println(sol.coinChange(test, 6249));
    }
}
