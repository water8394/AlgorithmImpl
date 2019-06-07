package stringAndChar;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (!map.containsKey(sorted)){
                List<String> inp = new ArrayList<>();
                inp.add(str);
                map.put(sorted, inp);
            }else {
                map.get(sorted).add(str);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> l : map.values()){
            ans.add(l);
        }
        return ans;
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        sol.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
