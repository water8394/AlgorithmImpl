package book;

public class HeapSort {

    public void headSort(int[] nums){
        int n = nums.length-1;
        for (int k = n / 2; k >= 1; k--){
            sink(nums,k, n);
        }
        while (n > 1){
            swap(nums, 1, n--);
            sink(nums, 1, n);
        }
    }

    private void sink(int[] nums, int k, int n) {
        while (2 * k <= n){
            int j = 2* k;
            if (j < n && nums[j] < nums[j+1]){
                j++;
            }
            if (nums[k] > nums[j]){
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    private void swap(int[] nums, int k, int j) {
        int tmp = nums[k];
        nums[k] = nums[j];
        nums[j] = tmp;
    }


}
