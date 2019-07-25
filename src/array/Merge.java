package array;

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1;
        int cur2 = m - 1;
        int end = nums1.length;
        while (cur1 >= 0 && cur2 >= 0){
            if (nums1[cur1] > nums2[cur2]){
                nums1[end--] = nums1[cur1--];
            }else{
                nums1[end--] = nums2[cur2--];
            }
        }
        if (cur1 < 0) {
            for (int i = cur2; i > 0; i--) {
                nums1[end--] = nums2[i];
            }
        }
        if (cur2 < 0) {
            for (int i = cur1; i > 0; i--) {
                nums1[end--] = nums1[i];
            }
        }
    }


}
