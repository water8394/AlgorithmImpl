package stringAndChar;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ret = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (s.length() < p.length()) return ret;
        int[] map = new int[26];
        for (char ch : p.toCharArray())
            map[ch - 'a']++;

        int counter = p.length();  // 指示条件, 如果counter被减为0需要判断窗口内的字符是否满足要求
        int lo = 0, hi = 0;
        char[] ss = s.toCharArray();

        while (hi < m) {
            // 每次都要向右移动一次hi, 如果hi对应的字符出现次数大于等于1说明该字符在p中, 将counter减1
            if (map[ss[hi] - 'a']-- >= 1)
                counter--;
            hi++;
            // 如果counter减为0, 将左端点index加入返回值
            if (counter == 0)
                ret.add(lo);
            // 如果hi-lo == p.length说明窗口大小超出限制, 需要将lo右移一位同时判断lo对应的字符是否在p中并决定是否对counter加1
            if (hi - lo == n) {
                // 只有当lo对应的字符个数大于等于0才说明lo对应的字符属于p, 否则其对应值应为负值
                if (map[ss[lo] - 'a']++ >= 0)
                    counter++;
                lo++;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        FindAnagrams sol = new FindAnagrams();
        List<Integer> anagrams = sol.findAnagrams("cbaebabacd", "abc");
        System.out.println("-");
    }
}
