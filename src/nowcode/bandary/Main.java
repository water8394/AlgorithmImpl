package nowcode.bandary;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        if (n == 1){
            System.out.println(100);
            return;
        }else if (n == 2){
            System.out.println(300);
            return;
        }else{
            if (arr[1] >= arr[0]) dp[0] = 100;
            else dp[0] = 200;
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[i-1]){
                    dp[i] = dp[i-1] + 100;
                }else if (arr[i] == arr[i-1]){
                    dp[i] = dp[i-1];
                }else{
                    int t = dp[i-1] - 100;
                    int idx = i-1;
                    if (t < 100){
                        for (int j = i-1; j >= 0; j--) {
                            if (j == 0 && dp[0] > dp[1]){
                                idx = 0;
                                break;
                            }
                            if (dp[j-1] >= dp[j]){
                                idx--;
                            }else{
                                idx--;
                                break;
                            }
                        }
                        for (int j = idx; j <= i-1; j++) {
                            dp[j] += 100;
                        }
                    }
                    dp[i] = 100;
                }
            }
        }
        int sum = 0;
        for (int i : dp) {
            sum += i;
        }
        System.out.println(sum);

    }

}
