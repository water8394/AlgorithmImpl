package stringAndChar;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (s.charAt(0) == '-') return false;
        if (s.charAt(0) == '+' && s.length()==1) return false;
        if (s.charAt(0) == '+') s = s.substring(1);
        int l = 0, r= s.length()-1;
        while (l < r){
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome sol = new IsPalindrome();
        boolean a = sol.isPalindrome(134231);
        System.out.println(a);
    }

}
