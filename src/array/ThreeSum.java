package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int target = nums[i];
            int l = i+1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + target;
                if (sum == 0){
                    List<Integer> append = new ArrayList<>();
                    append.add(target);
                    append.add(nums[l]);
                    append.add(nums[r]);
                    ans.add(append);
                    while(l < r && nums[r-1] == nums[r]) r--;
                    while(l < r && nums[l+1] == nums[l]) l++;
                    l++;
                }else if (sum > 0){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        List<List<Integer>> lists = sol.threeSum(new int[]{0,0,0,0});
        lists.forEach(l -> l.forEach(System.out::println));


    }

}
