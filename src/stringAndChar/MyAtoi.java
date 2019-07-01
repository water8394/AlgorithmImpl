package stringAndChar;




public class MyAtoi {

    boolean m = true;

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() < 1) return 0;
        String ans ="";
        boolean flag = false;
        char first = str.charAt(0);
        if ((flag = isSymbol(first)) || (flag = isNumber(first))){
            if (isNumber(first)) ans += first;
            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);
                if (isNumber(c)){
                    ans += c;
                } else {
                    break;
                }
            }
            if (ans.length() > 0) {
                return transfer(ans, this.m);
            }
        }

        return 0;
    }

    private boolean isSymbol(char first) {
        if (first == '+') this.m = true;
        if (first == '-') this.m = false;
        return first == '+' || first == '-';
    }

    private boolean isNumber(char c){
        return c >='0' && c <= '9';
    }

    private int transfer(String s, boolean flag){

        int max = (Integer.MAX_VALUE - 7) / 10;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int a = Integer.valueOf(c + "");
            if (((ans > max)|| (ans == max && a > 7)) && flag) return Integer.MAX_VALUE;
            if (((ans > max)|| (ans == max && a > 7)) && !flag) return Integer.MIN_VALUE;
            ans = 10 * ans + a;
        }
        int b = flag ? 1 : -1;
        return b * ans;
    }

    public static void main(String[] args) {
        MyAtoi sol = new MyAtoi();
        int i = sol.myAtoi("-91283472332");
        System.out.println(i);

    }
}
