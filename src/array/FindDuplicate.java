package array;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindDuplicate sol = new FindDuplicate();
        int duplicate = sol.findDuplicate(new int[]{1,1,5, 2, 2, 3, 3});
        System.out.println(duplicate);
    }
}
