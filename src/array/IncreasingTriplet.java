package array;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {

        int l = Integer.MAX_VALUE, h = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= l){
                l = nums[i];
            }else if (nums[i] <= h){
                h = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet sol = new IncreasingTriplet();
        boolean b = sol.increasingTriplet(new int[]{2, 4, -2, -3});
        System.out.println("-");
    }

}
