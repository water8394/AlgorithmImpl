package book.sortPackage;

public class QuickSort2 {

    public void quickSort(int[] nums){
        sort(nums,0, nums.length-1);
    }
    public void sort(int[] nums, int l, int h){
        if (l >= h) return;
        int j = partition(nums, l , h);
        sort(nums, l, j-1);
        sort(nums, j+1, h);
    }

    private int partition(int[] nums, int l, int h) {
        int i = l;
        int j = h+1;
        int split = nums[l];
        while (true){
            while (nums[++i] < split && i != h);
            while (nums[--j] > split && j != l);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int l, int j) {
        int tmp = nums[l];
        nums[l] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3,7,9,8,6};
        QuickSort2 sol = new QuickSort2();
        sol.quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
