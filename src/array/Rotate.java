package array;

public class Rotate {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) return;
        if (nums.length <k) {
            k = k % nums.length;
        }
        int l = 0, r = nums.length-1;
        while (l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }

        l = 0;
        r = k-1;
        while (l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
        l = k;
        r = nums.length-1;
        while (l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        Rotate sol = new Rotate();
        sol.rotate(nums, 3);
        for (int n: nums) {
            System.out.println(n);
        }

    }
}
