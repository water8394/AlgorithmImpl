package book.sortPackage;

public class QuickSortList {

    public static void sort(int[] nums){
        sortPart(nums, 0, nums.length-1);
    }

    private static void sortPart(int[] nums, int l, int h) {
        if (h <= l){
            return;
        }
        int j = partition(nums, l, h);
        sortPart(nums, l, j-1);
        sortPart(nums, j+1, h);
    }

    private static int partition(int[] nums, int l, int h) {
        int i = l, j = h+1;
        int t = nums[l];
        while (true){
            while (less(nums[++i], t) && i != h);
            while (less(t, nums[--j]) && j != l);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static boolean less(int num, int t) {
        return num < t;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,7,6,5};

        for (int i : arr) {
            System.out.print(i);
        }
        sort(arr);
        System.out.println("--------");
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
