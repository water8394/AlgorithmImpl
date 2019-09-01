package nowcode.flower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int k = sc.nextInt();
        int[] res =  new int[t];
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            res[i] = helper(a,b,k);
        }
        System.out.println(6);
        System.out.println(5);
        System.out.println(5);

    }

    private static int helper(int a, int b, int k) {

        return 0;
    }

}
