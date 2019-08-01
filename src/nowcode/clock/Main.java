package nowcode.clock;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] start = new int[n][2];
        for (int i = 0; i < n; i++) {
            start[i][0] = sc.nextInt();
            start[i][1] = sc.nextInt();
        }
        int walk = sc.nextInt();
        int finalH = sc.nextInt();
        int finalM = sc.nextInt();

        int min = Integer.MAX_VALUE;
        String ret = "";
        for (int i = 0; i < start.length; i++) {
            int r = check(start[i][0],start[i][1],finalH,finalM, walk);
            if (r < min && r >= 0){
                min = r;
                ret = String.valueOf(start[i][0]) + " " + String.valueOf(start[i][1]);

            }
        }
        System.out.println(ret);
    }

    private static int check(int h, int m, int finalH, int finalM, int walk) {
        return (finalH-h)*60 + (finalM-m) - walk;
    }
}
