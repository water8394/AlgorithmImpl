package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        List<Integer> val = new ArrayList<>();
        for(int j : nums2){
            if (map.containsKey(j)){
                if (map.get(j) == 1){
                    map.remove(j);
                    val.add(j);
                }else{
                    map.put(j, map.get(j)-1);
                    val.add(j);
                }
            }
        }
        int[] ans = new int[val.size()];
        for (int i = 0; i < val.size(); i++) {
            ans[i] = val.get(i);
        }
        return ans;

    }


}
