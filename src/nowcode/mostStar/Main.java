package nowcode.mostStar;

import java.util.Scanner;

public class Main {


    private static int depth = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int star = Math.max(dp(arr,arr.length-1, 0), dp(arr,arr.length-2, 0));
        System.out.println(star);
        System.out.println(depth);
    }

    private static int dp(int[] arr, int i, int k) {
        int sum = arr[i];
        if (i <= 2){
            depth = Math.max(k+1, depth);
            return arr[i];
        }
        return Math.max(dp(arr,i-1, k+1), dp(arr, i-2, k+1)) + sum;
    }
}
