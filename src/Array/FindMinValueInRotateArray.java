package Array;

import java.util.ArrayList;

public class FindMinValueInRotateArray {

    public int minNumberInRotateArray(int [] array) {
        if (array != null && array.length != 0){
            int left = 0, right = array.length-1;
            int mid = 0;
            while (left < right){
                mid = left + (right-left)/2;
                System.out.println("===========");
                System.out.println("left: "+left);
                System.out.println("right: "+right);
                System.out.println("mid: "+mid);
                if (array[mid]==array[right] && array[mid] == array[left]){
                    return findMin(array, left, right);
                }else if (array[mid] <= array[right]){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            return array[left];
        }else{
            return 0;
        }
    }

    private int findMin(int[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            if (array[i] > array[i+1]){
                return array[i+1];
            }
        }
        return array[right];
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{3,4,5,1,2,3};
        FindMinValueInRotateArray sol  = new FindMinValueInRotateArray();
        System.out.println(sol.minNumberInRotateArray(testArray));
    }
}
