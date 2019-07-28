package nowcode.upSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");
        int[] a = new int[line1.length];
        int[] b = new int[line2.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(line1[i]);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(line2[i]);
        }

        Arrays.sort(b);
        int cur = 0;
        int pre = a[0];
        int idx = -1;
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;

        for (int i = 1; i < a.length; i++) {
            if (a[i] < pre) {
                idx = i;
                left = a[i-1];
                right = i <a.length-1 ? a[i+1] : Integer.MAX_VALUE;
                break;
            }else {
                pre = a[i];
            }
        }

        if (helper(idx, a, b, right, left))
        {
            output(a);
            return;
        }
        right = a[idx];
        left = idx-2 >= 0 ? a[idx-2] : Integer.MIN_VALUE;
        if (helper(idx-1,a,b, right, left)){

        output(a);
        return;
        }
        System.out.println("No");

    }

    private static boolean helper(int idx, int[] a, int[] b,int right, int left) {
        for (int i = b.length-1; i >= 0; i--) {
            if (b[i] < right && b[i] > left){
                a[idx] = b[i];
                return true;
            }
        }
        return false;
    }

    private static void output(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }
}
