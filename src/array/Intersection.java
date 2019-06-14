package array;

import java.util.*;

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int a : nums1){
            set.add(a);
        }
        for (int b : nums2){
            if (set.contains(b)){
                if (!map.containsKey(b)){
                    map.put(b,1);
                    list.add(b);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
