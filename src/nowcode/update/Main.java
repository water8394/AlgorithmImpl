package nowcode.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            String a = arr[0], b = arr[1];
           if (check(a,b)){
               res.add("true");
           }else {
               res.add("false");
           }
        }
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static boolean check(String a, String b) {
        int[] aArr = new int[a.length()/2+1];
        int aaa = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '.'){
                aArr[aaa++] = Integer.parseInt(a.charAt(i)+"");
            }
        }
        int[] bArr = new int[b.length()/2+1];
        int bbb= 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != '.'){
                bArr[bbb++] = Integer.parseInt(b.charAt(i)+"");
            }
        }
        int cur = 0;
        while (cur < aArr.length && cur < bArr.length){
            int num1 = aArr[cur];
            int num2 = bArr[cur];
            if (num1 > num2) return false;
            cur++;
        }
        if (cur < aArr.length) return false;
        boolean p = false;
        if (cur < bArr.length){
            while (cur < bArr.length){
            int tmp = bArr[cur++];
            if (tmp > 0) p =true;
            }
        return p;
        }else {
            return true;
        }
    }
}
