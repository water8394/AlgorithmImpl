package nowcode.Apple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            start += sc.nextInt();
            a[i] = start;
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            System.out.println(search(a, s));
        }
    }

    private static int search(int[] a, int s) {

        int l = 0;
        int r = a.length-1;
        while (l < r){
            int mid = l + (r-l)/2;
            if (a[mid] < s){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return s>a[l] ? l+1 : r+1;
    }

}
