package nowcode.listAs01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            arr[i] = sc.nextInt();
        }
        int i = 1;
        int ans = 0;
        while (i <= n){
            int[] tmp = new int[n];
            tmp[0] = i;
            ans += dp(tmp, 1, n, arr);
            i++;
        }
        System.out.println(ans);
    }

    private static int dp(int[] tmp, int i, int total,int[] c) {

        if (i == total){
            if (check(tmp,c, total-1)){
                return 1;
            }else{
                return 0;
            }

        }
        int ans = 0;
        int[] val = new int[total];

        if (i > 1){
            if (!check(tmp,c,i-1)) return 0;
        }



        for (int j = 0; j < i; j++) {
            if (tmp[j] != 0){
                val[tmp[j]-1] = 1;
            }
        }
        for (int j = 0; j < total; j++) {
            if (val[j] == 0){
                int[] arr = new int[total];
                int k = 0;
                for (k = 0; k < i; k++) {
                    arr[k] = tmp[k];
                }
                arr[i] = j+1;
                ans += dp(arr,i+1,total,c);

            }
        }

        return ans;
    }

    private static boolean check(int[] tmp, int[] c, int finish) {

        for (int i = 0; i < finish; i++) {
            if (c[i] == 1){
                if (tmp[i] < tmp[i+1]) return false;
            }else {
                if (tmp[i] > tmp[i+1]) return false;
            }
        }
        return true;
    }
}
