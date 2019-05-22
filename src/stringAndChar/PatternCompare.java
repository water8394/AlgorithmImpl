package stringAndChar;

public class PatternCompare {
    public boolean match(char[] str, char[] pattern) {
        if (str.length == 0) {
            return false;
        }
        int idx = 0;
        for (int i = 0; i < pattern.length; i++) {

        }


        return false;
    }


    public static void main(String[] args) {
        PatternCompare sol = new PatternCompare();
        sol.match(new char[]{'a','b','c'}, new char[]{'a','.','c'});
    }
}
