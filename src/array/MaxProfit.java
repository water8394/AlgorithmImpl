package array;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int l = 0, r = 1, pre = 0;
        while (r < prices.length){
            if (r == prices.length -1 && prices[r] > prices[pre]){
                sum += prices[r] - prices[l];
                break;
            }
            if (prices[r] > prices[pre]){
                pre = r;
                r++;
            }else {
                sum += prices[pre] - prices[l];
                pre = l = r;
                r++;
            }

        }
        return sum;
    }
}
