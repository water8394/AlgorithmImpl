package array;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int l = 0, r = 1;
        int length = nums.length;
        while (r < length){
            if (nums[r] == nums[l]){
                if (length - r > 1){
                    System.arraycopy(nums, r+1, nums, r, nums.length - r -1);
                }
                length--;
            }else{
                l++;
                r++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();
        int[] inp = new int[]{1,1,2,2,3};
        int i = sol.removeDuplicates(inp);
        for (int n : inp){
            System.out.print(n +" ");
        }
        System.out.println(" ");
        System.out.println(i);
    }
}
