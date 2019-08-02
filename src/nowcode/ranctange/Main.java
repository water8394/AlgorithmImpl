package nowcode.ranctange;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x2[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y2[i] = sc.nextInt();
        }

        int cnt = 1;
        int tmp = 0;
        for (int x : x1) {
            for (int y : y1) {
                for (int i = 0; i < n; i++) {
                    if (x1[i] <= x && y1[i] <= y && x2[i] >= x && y2[i] >= y){
                        tmp ++;
                    }
                }
                if (tmp > cnt) cnt = tmp;
                tmp = 0;
            }
        }
        System.out.println(cnt);
    }

}
