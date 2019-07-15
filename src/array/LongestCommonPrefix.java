package array;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            min = Math.min(strs[i].length(), min);
        }
        int i;
        for(i = 0; i < min; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,i);
    }

}
