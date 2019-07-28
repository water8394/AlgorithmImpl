package nowcode.Stringcycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        LinkedList<String> list = new LinkedList<>();
        for (String word : words) {
            list.add(word);
        }
        String one = list.remove(0);
        char start = one.charAt(0);
        char end = one.charAt(one.length()-1);
        String t = helper(list, start, end);
        if (t.equals("true")) System.out.println("true");
        else System.out.println("false");
    }

    private static String helper(LinkedList<String> list, char start, char end) {
        if (list.size() == 1) {
            String word = list.pop();
            if (word.charAt(word.length()-1) == start && word.charAt(0)==end){
                return "true";
            }
            return "false";
        }
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (word.charAt(0)==end){
                LinkedList newList = new LinkedList();
                newList.addAll(list);
                newList.remove(i);
                ret.add(helper(newList,start, word.charAt(word.length()-1)));
            }
        }
        for (int i = 0; i < ret.size(); i++) {
            if (ret.get(i).equals("true")) return "true";
        }
        return "false";
    }

}
