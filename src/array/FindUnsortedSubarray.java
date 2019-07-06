package array;

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start = -1;
        int end = -2;
        int max = nums[0];
        int min = nums[len-1];
        for (int i = 0; i < len; i++) {
            int pos = len - i - 1;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[pos]);
            if (max > nums[i]) end = i;
            if (min < nums[pos]) start = pos;
        }
        return end - start + 1;
    }

}
