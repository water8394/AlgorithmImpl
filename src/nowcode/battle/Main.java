package nowcode.battle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int k = lowerBound(arr, i, n-1, arr[i]/0.9);
            sum += k-i - 1;
        }

        System.out.println(sum);


    }

    private static int lowerBound(int[] nums, int l, int r, double v) {
        while (l <= r){
            int m = l + (r-l)/2;
            if (nums[m] > v){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }

}
