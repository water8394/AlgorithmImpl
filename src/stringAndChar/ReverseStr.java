package stringAndChar;

/**
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，
 * 并将剩余的字符保持原样。
 *

 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        if (k > s.length()) return reverseSubString(s, 0, s.length()-1);
        boolean flag = true;
        int split = 0;
        while (split < s.length()){
            int end = split+k-1 < s.length()-1 ? split + k-1 : s.length()-1;
            if (flag){
                s = reverseSubString(s, split, end);
            }
            split += k;
            flag = !flag;
        }
        return s;
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
        ReverseStr sol = new ReverseStr();
        String s = sol.reverseStr("abcdefg", 3);
        System.out.println(s);
    }
}
