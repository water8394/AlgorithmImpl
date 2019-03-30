import java.util.HashMap;

public class Solution {

    public void minStr(String input){
        char res = 'z';
        input = input.toLowerCase();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<input.length();i++){
            char temp = input.charAt(i);
            if (!map.containsKey(temp)){
                map.put(temp, 1);
                res = res < temp ? res : temp;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.minStr("");

    }
}
