package stringAndChar;

public class ReverseWords {
    public String reverseWords(String s) {

        int cur = 0;
        int pre = 0;
        s.split(" ");
        while (cur < s.length()){
            if (s.charAt(cur) == ' ' && cur-pre > 0){
                s = reverseSubString(s, pre, cur-1);
                pre = cur+1;
            }
            cur++;
        }

        return reverseSubString(s, pre, s.length()-1);
    }

    private String reverseSubString(String s, int start, int end){
        StringBuilder sb = new StringBuilder(s);
        while (start < end){
            char tmp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords sol = new ReverseWords();
        String s = sol.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }

}
