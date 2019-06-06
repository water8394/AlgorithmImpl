package array;

import java.util.concurrent.locks.ReentrantLock;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isOdd;
        int[] res = new int[2];
        if ((nums1.length + nums2.length) % 2 == 0){
            isOdd = false;
        }else {
            isOdd = true;
        }
        int middle = (nums1.length + nums2.length)/2;
        int l = 0, r = 0;
        int idx = 0;
        while ((l < nums1.length || r < nums2.length) && idx < 2){
            if (nums1[l] >= nums2[r]){
                l++;
                if ((l+r+2) == middle){

                }
            }else{
                r++;
            }
        }
       new ReentrantLock();
        return 0.0;
    }
}
