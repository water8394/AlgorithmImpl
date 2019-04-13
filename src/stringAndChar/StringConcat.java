package stringAndChar;

import java.util.*;

public class StringConcat {

    public static void main(String[] args) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Scanner scanner = new Scanner(System.in);
        String inp = scanner.next();
        String ret = openStr(inp, map);
        System.out.println(ret);
    }

    private static String openStr(String inp, HashMap map) {
        String ret = "";
        int repNumber = 0;
        int i = 0;
        while (i < inp.length()) {
            Character temp = inp.charAt(i++);
            if (!Character.isDigit(temp)){
                ret += temp;
            }else {
                repNumber = temp - '0';
                Character right = (Character) map.get(inp.charAt(i));
                String rep = "";
                Stack<Character> stack = new Stack<>();
                for (int j = i+1; j < inp.length(); j++) {

                    Character c = inp.charAt(j);
                    if (map.containsKey(c)){
                        stack.push(c);

                    }else if (!stack.empty() && c == map.get(stack.peek())){
                        stack.pop();
                    }else if (inp.charAt(j) == right && stack.empty()) {
                        rep = openStr(inp.substring(i+1, j), map);
                        i = j + 1;
                    }
                }
                for (int j = 0; j < repNumber; j++) {
                    ret += rep;
                }
                ;
            }

        }
        return ret;
    }

}
