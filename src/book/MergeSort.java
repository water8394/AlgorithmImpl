package book;

public class MergeSort {

    public static void merge(int[] nums, int l, int m, int h){

        int i = l, j= m+1;
        int[] tmp = new int[nums.length];

        for (int k = 0; k <= h; k++) {
            tmp[k] = nums[k];
        }

        for (int k = l; k <=h; k++) {
            if (i > m){
                nums[k] = tmp[j++];
            }else if (j > h){
                nums[k] = tmp[i++];
            }else if (tmp[i] <= tmp[j]){
                nums[k] = tmp[i++];
            }else {
                nums[k] = tmp[j++];
            }
        }
    }
    public static void sort(int[] nums, int l, int h){
        if (h <= l){
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums,l, mid);
        sort(nums, mid+1, h);
        merge(nums, l, mid, h);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,4,5,76,53};
        sort(arr, 0, arr.length-1);
        for (int a :arr){
            System.out.print(a + " -> ");
        }
    }
}
