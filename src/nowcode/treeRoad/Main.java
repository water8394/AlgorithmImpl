package nowcode.treeRoad;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n-1];
        int k  = n-1;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = k--;
        }
        int[] ret = new int[3];
        for (int i = 0; i < n-1; i++) {
            int t = i+1;
            if (t % 3 == 0) ret[0] += t*arr[i];
            if (t % 3 == 1) ret[1] += t*arr[i];
            if (t % 3 == 2) ret[2] += t*arr[i];
        }
        ret[0] = new Double(ret[0] % (1e9+7)).intValue();
        ret[1] = new Double(ret[1] % (1e9+7)).intValue();
        ret[2] = new Double(ret[2] % (1e9+7)).intValue();
        System.out.println(ret[0] + " " + ret[1] + " " + ret[2]);
    }
}
