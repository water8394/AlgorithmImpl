package stringAndChar;

import java.util.Arrays;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {

        int tl = t.length();
        int sl = s.length();
        if (tl != sl) return false;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i = 0; i < tl; i++) {
            if (ss[i] != tt[i]) return false;
        }
        return true;
    }
}
