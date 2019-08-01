package nowcode.bag;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        Arrays.sort(v);

        int sum = dfs(v, 0, 0, w, 0);

        System.out.println(sum);
    }

    private static int dfs(int[] v, int sum, int idx, int w, int depth) {

        if (sum > w) return 0;
        if (sum == w) return 1;
        if (idx == v.length-1){
            if (w-sum >= v[idx]) return 2;
            else return 1;
        }

        return dfs(v,sum+v[idx],idx+1,w,depth+1)+dfs(v,sum,idx+1,w,depth+1);
    }
}
