package stringAndChar;

public class IsPalindrome2 {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        int l = 0, r = s.length()-1;
        while (l < r){
            while (l< s.length() && !isChar(s.charAt(l))) l++;
            while (r > 0 && !isChar(s.charAt(r)) ) r--;
            if (l >= r) break;
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    private boolean isChar(char c){
        return ('0' <= c && '9' >= c) || ('a' <=  c  && 'z' >= c);
    }


    public static void main(String[] args) {
        IsPalindrome2 sol = new IsPalindrome2();
        boolean is = sol.isPalindrome(",,");
        System.out.println(is);

    }
}
