package stringAndChar;

import java.util.LinkedList;
import java.util.List;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        List<Integer> list = new LinkedList<>();
        int count = 0;
        int tmp;
        list.add(1);
        for (int i = 0; i < n - 1; i++) {
            int len = list.size();
            tmp = ((LinkedList<Integer>) list).getFirst();
            for (int j = 0; j < len; j++) {
                int m = ((LinkedList<Integer>) list).poll();
                if (m != tmp){
                    ((LinkedList<Integer>) list).addLast(count);
                    ((LinkedList<Integer>) list).addLast(tmp);
                    tmp = m;
                    count = 1;
                }else{
                    ++count;
                }
            }
            ((LinkedList<Integer>) list).addLast(count);
            ((LinkedList<Integer>) list).addLast(tmp);
            count = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) sb.append(i);
        return sb.toString();
    }

}
