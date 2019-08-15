package nowcode.maxModInteger;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }
        Collections.sort(a);
        Collections.sort(b);
        int max = n-1;
        String s = "";
        for (int i = 0; i < n; i++) {
           s += find2(max, a, b,n) + " ";

        }
        System.out.println(s);
    }

    private static String find(int max, List<Integer> a, List<Integer> b,int n) {

        for (int i = max; i >= 0 ; i--) {
            for (int j = 0; j < a.size(); j++) {
                for (int k = b.size()-1; k >= 0; k--) {
                    int t = a.get(j) + b.get(k);
                    if ( t == i || t%n == i){
                        a.remove(j);
                        b.remove(k);
                        return String.valueOf(t%5);
                    }
                }
            }
        }
        return "";

    }


    private static int[] find2(int max, List<Integer> a, List<Integer> b,int n) {

        int[] ret = new int[n];

        int idx = 0;
        int l = 0;
        int h = 0;




        return ret;
    }

}
