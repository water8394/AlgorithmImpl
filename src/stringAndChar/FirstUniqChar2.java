package stringAndChar;

public class FirstUniqChar2 {

    public int firstUniqChar(String s) {
        int[] exist = new int[26];
        for (int i = 0; i < 26; i++) {
            exist[i] = -1;
        }
        for (int i = 0; i< s.length();i++) {
            int idx = s.charAt(i)- 'a';
            if (exist[idx] == -1) {
                exist[idx] = i;
            }else {
                exist[idx] = Integer.MAX_VALUE;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i: exist) {
            if (i != -1 && i !=Integer.MAX_VALUE){
                min = Math.min(min, i);
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        else return min;
    }

}
