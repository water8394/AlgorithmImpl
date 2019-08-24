package nowcode.bagAnswer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int[][] ret = new int[n+1][m +1];
        for (int i = 0; i < n+1; i++) {
            ret[i][0] = 0;
        }
        for (int i = 0; i < m+1; i++) {
            ret[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (w[i -1] <= j){
                    if (ret[i-1][j] < (ret[i-1][j-w[i-1]] + v[i-1])){
                        ret[i][j] = ret[i-1][j-w[i-1]] + v[i-1];
                    }else {
                        ret[i][j] = ret[i-1][j];
                    }
                }else {
                    ret[i][j] = ret[i-1][j];
                }
            }

        }
        System.out.println(ret[n][m]);
        HashMap<Integer, String> s = new HashMap<>();
        for(Map.Entry<Integer, String> k: s.entrySet()){
            if (s.containsKey(k.getKey()))
            System.out.println(k.getKey());
        }
    }
}
