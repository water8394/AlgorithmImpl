package array;

import java.util.ArrayList;
import java.util.List;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ret = new int[n];

        int sum = 1;
        List<Integer> zero = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (t == 0)
                zero.add(i);
            else
                sum*=t;
        }

        if (zero.size() > 1){
            for (int i = 0; i < n; i++) {
                ret[i] = 0;
            }
        }else if (zero.size() == 1){
            int t = zero.get(0);
            int tmp = 1;
            for (int i = 0; i < n; i++) {
                if (i != t) tmp *= nums[i];
            }
            ret[t] = tmp;
        }else{
            for (int i = 0; i < n; i++) {
                ret[i] = sum / nums[i];
            }
        }


        return ret;
    }


    public static void main(String[] args) {

        ProductExceptSelf sol = new ProductExceptSelf();
        int[] inp = {1,0,4};
        int[] ret = sol.productExceptSelf(inp);

        for (int i : ret) {
            System.out.println(i);
        }

    }

}
