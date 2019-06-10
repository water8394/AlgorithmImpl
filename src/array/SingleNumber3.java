package array;

import java.util.Arrays;
import java.util.Stack;

public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int cur = 0;
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        for(int n : nums){
            if (stack.isEmpty()){
                stack.push(n);
            }else{
                Integer pop = stack.pop();
                if (!pop.equals(n)){
                    ans[cur++] = pop;
                    stack.push(n);
                }
            }
        }
        if (!stack.isEmpty()){
            ans[cur] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumber3 sol = new SingleNumber3();
        int[] num = sol.singleNumber(new int[]{1, 1, 2, 2, 3, 4});
        for (int n : num) System.out.println(n);
    }
}
