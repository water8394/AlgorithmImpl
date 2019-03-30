package find;

public class RotateArrayByMinNumber {


    // Binary Search
    private int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        int l = 0, r = array.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int midValue = array[mid];
            if (midValue <= array[r]) r = mid;
            else
                l = mid + 1;
        }
        return array[l];
    }

    public static void main(String[] args) {
        RotateArrayByMinNumber sol = new RotateArrayByMinNumber();
        System.out.println(sol.minNumberInRotateArray(new int[]{4,5,6,1,2,3}));
    }
}
