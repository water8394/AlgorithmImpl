package array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {

        if (nums.length < 2) return;
        for (int i = nums.length-1; i > 0 ; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]){
                    int min = Integer.MAX_VALUE;
                    for (int m = j; m < nums.length; m++){

                    }
                    swap(nums, i, j);
                    return;
                }
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();
        int[] num = {1,3,2};
        sol.nextPermutation(num);
        System.out.println("------------");
    }
}
