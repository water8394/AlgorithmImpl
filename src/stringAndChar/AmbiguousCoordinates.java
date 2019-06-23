package stringAndChar;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList<>();

        int start = 1;
        int end = S.length()-1;
        for (int i = start+1; i < end; i++) {
            add(S.substring(start,i), S.substring(i,end),ans);
        }
        return ans;
    }

    private void add(String left, String right, List<String> ans) {

        List<String> l = mix(left);
        List<String> r = mix(right);
        if (l.size() > 0 && r.size() > 0){
            for (String ll : l) {
                for (String rr : r) {
                    ans.add("("+ll+", "+rr+")");
                }
            }
        }
    }

    private List<String> mix(String part) {
        List<String> ans = new ArrayList<>();

            if (part.charAt(0) == '0'){
                if (part.length()>1){
                    if (part.charAt(part.length()-1) != '0'){
                        ans.add("0."+part.substring(1));
                    }
                }else{
                    ans.add(part);
                }
            } else if (part.length() == 1 || part.charAt(part.length() - 1) == '0') {
                ans.add(part);
            }else{
                for (int j = 1; j < part.length(); ++j) {
                    ans.add(part.substring(0,j) + "." + part.substring(j));
                }
                ans.add(part);
            }
        return ans;
    }


    public static void main(String[] args) {
        AmbiguousCoordinates sol = new AmbiguousCoordinates();
        List<String> strings = sol.ambiguousCoordinates("(010011)");
        System.out.println("-");
    }
}
