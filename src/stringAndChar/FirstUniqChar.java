package stringAndChar;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] res = new int[26];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if (res[idx] == -1){
                res[idx] = i;
            }else{
                res[idx] = -2;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.length; i++) {
            if (res[i] >=0) min = Math.min(res[i], min);
        }
        if (min >= 0 && min < Integer.MAX_VALUE) return min;
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar sol = new FirstUniqChar();
        int i = sol.firstUniqChar("hehllo");
        System.out.println(i);

    }
}
