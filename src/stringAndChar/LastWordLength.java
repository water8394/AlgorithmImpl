package stringAndChar;

public class LastWordLength {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s.equals(" ")) {
            return 0;
        }
        String[] res = s.split(" ");
        if (res.length == 0){
            return 0;
        }
        return res[res.length-1].length();
    }

    public static void main(String[] args) {
        LastWordLength sol = new LastWordLength();
        int val = sol.lengthOfLastWord("   ");
        System.out.println(val);
    }
}
