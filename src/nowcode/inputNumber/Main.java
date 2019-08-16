package nowcode.inputNumber;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ret = "";
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c -'0' >= 0 && '9'-c >= 0){
                Integer t = Integer.parseInt(c+"");
                if (list.size()==0 || t.compareTo(list.peekLast())<0){
                    list.addFirst(t);
                }else{
                    list.addLast(t);
                }
            }
        }
        if (list.size() < 1){
            System.out.println(-1);
            return;
        }
//        Collections.sort(list);
        for (Integer integer : list) {
            ret += integer;
        }
        System.out.println(ret);
    }
}
