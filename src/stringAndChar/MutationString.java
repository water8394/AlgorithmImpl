package stringAndChar;

import java.util.ArrayList;
import java.util.Collections;

public class MutationString {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] s = str.toCharArray();
        rank(s, 0);
        Collections.sort(ret);
        return ret;
    }

    private void rank(char[] s, int start) {
        if (start == s.length) {
            ret.add(new String(s));
        }else {
            for (int i = start; i < s.length; i++) {
                if (i == start)
                    rank(s, start+1);
                if (s[i] != s[start]){
                    char[] temp = swap(s, start, i);
                    rank(temp, start+1);
                }
            }
        }
    }

    private char[] swap(char[] s, int start, int i) {
        char[] v = s.clone();
        char temp = v[start];
        v[start] = v[i];
        v[i] = temp;
        return v;
    }


    public static void main(String[] args) {
//        ArrayList<String> result = new MutationString().Permutation("aabc");
//        System.out.println(result);
        // [aabc, aacb, abac, abca, acab, acba, baac, baca, bcaa, caab, caba, cbaa]
        ArrayList<String> result;
        result = new MutationString().Permutation("abc");
        System.out.println(result); // [aab, aba, baa]
    }

}
