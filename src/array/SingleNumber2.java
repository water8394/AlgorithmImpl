package array;

import java.util.Arrays;

public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i;
        for (i=0; i < nums.length-2; i+=3) {
            int l = nums[i];
            int r = nums[i+2];
            if (l != r){
                return l;
            }
        }
        if (i < nums.length){
            return nums[i];
        }

        return -1;
    }


    public static void main(String[] args) {
        SingleNumber2 sol = new SingleNumber2();
        int i = sol.singleNumber(new int[]{1,1,1,3, 2, 2, 2});
        System.out.println(i);
    }
}
