package interview;

public class Main {
        public static void main(String[] args) {
            int[] nums = new int[]{9,91,100,1,2,3,4};
            int target = 2;
            int idx = find(nums,target);
            System.out.print(idx);
        }
        public static int find(int[] nums, int target){
            int l = 0, r = nums.length -1;
            while (l < r){
                int mid = l + (r-l)/2;
                int tmp = nums[mid];
                if (mid > target){
                    if (nums[l] > target){
                        l = mid + 1;
                    }else {
                        r = mid -1;
                    }
                }else if (mid < target){
                    if (nums[r] > target){
                        l = mid+1;
                    }else {
                        r = mid -1;
                    }
                }else {
                    return mid;
                }
            }
            return l;
        }


}
