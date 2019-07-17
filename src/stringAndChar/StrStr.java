package stringAndChar;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int cur = 0;
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if (haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }

}
