package nowcode.descount;

import java.util.*;

public class Main {

    static List<Double> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        String[] nStr = sc.nextLine().split(" ");
        double[] arr = new double[nStr.length];
        for (int i = 0; i <  nStr.length; i++) {
            arr[i] = new Double(nStr[i]);
        }
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            double res = helper(list, m, m, 0, i);
            ans.add(res);
        }

        double v =Double.MAX_VALUE;
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) < v && ans.get(i) > 0) v = ans.get(i);
        }
        v = v >= 2*m && v < Double.MAX_VALUE ? v : -1.0;
        System.out.println(v);

    }

    private static double helper(List<Double> list, double m1, double m2, double total, int k) {
        if (list.size() < 1 && (m1 > 0 || m2 > 0)) return -1.0;
        if (m1 <= 0 && m2 <=0) return total;
        List<Double> tmp = new ArrayList<>();
        tmp.addAll(list);
        Double remove = tmp.remove(k);
        double a = -1.0;
        double b = -1.0;
        if (remove <= m1){
            List<Double> tmp1 = new ArrayList<>();
            tmp1.addAll(tmp);
            a =  helper(tmp1, m1-remove, m2,total+remove, 0);
        }else if (remove <= m2){
            List<Double> tmp2 = new ArrayList<>();
            tmp2.addAll(tmp);
            b =  helper(tmp2, m1, m2-remove,total+remove, 0);
        }
        if (a == -1.0 && b == -1.0) return -1.0;
        return Math.max(a, b);
    }
}
