package array;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }

        int l =0, r = nums.length-1;
        while (l <= r){
            int mid = (r - l) / 2 + l;
            System.out.println("mid:"+mid);
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        SearchInsert sol = new SearchInsert();

        int val = sol.searchInsert(new int[]{1,3,5,6},0);
        System.out.println(val);
    }
}
