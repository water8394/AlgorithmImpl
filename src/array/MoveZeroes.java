package array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int l = 0, r= 0;
        int len = nums.length;
        int mod = 0;
        while (r < nums.length){
            if (nums[r] != 0){
                nums[l++] = nums[r];
                mod++;
            }
            r++;
        }

        while (l < len){
            nums[l++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes sol = new MoveZeroes();
        sol.moveZeroes(new int[]{1,3,0,2,3,0,1,2});
        System.out.println("-");
    }
}
