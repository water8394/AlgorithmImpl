package stringAndChar;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1){
            return 0;
        }
        int max = 1;
        int l = 0, r = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        while (l < r && r < s.length()){
            if (map.containsKey(s.charAt(r))){
                max = Math.max(max, r-l);
                l = Math.max(map.get(s.charAt(r))+1,l);
            }
            map.put(s.charAt(r),r++);
        }
        max = Math.max(max, r-l);
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring sol = new LengthOfLongestSubstring();

        int i = sol.lengthOfLongestSubstring("abcba");
        System.out.println(i);
    }

}
