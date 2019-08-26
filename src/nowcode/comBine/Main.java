package nowcode.comBine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(" ");
        String[] b = sc.nextLine().split(" ");
        int cur1 = 0, cur2= 0;
        int flag = 0;
        List<String> res = new ArrayList<>();
        while (cur1 < a.length && cur2 < a.length){
            if (flag < 4){
                res.add(a[cur1++]);
                flag++;
            }else{
                flag = 0;
                res.add(b[cur2++]);
            }
        }
        while (cur1 < a.length){
            res.add(a[cur1++]);
        }
        while (cur2 < b.length){
            res.add(b[cur2++]);
        }
        String ans = "";
        for (String re : res) {
            ans += re + " ";
        }
        System.out.println(ans);
    }
}
