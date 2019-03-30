package dp;

import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {

        if (nums.length <= 0)
            return false;
        if (nums.length == 1)
            return true;
        int h = nums.length-1;

        for (int i = h-1; i >= 0; i--){

            if ((h - i)  <= nums[i]){
                if (i == 0) {
                    return true;}
                return canJump(Arrays.copyOfRange(nums, 0, i+1));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame sol  = new JumpGame();
        int[] test = new int[]{3, 2, 1, 1, 4};

        System.out.println(sol.canJump(test));
    }

}
