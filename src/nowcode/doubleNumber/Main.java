package nowcode.doubleNumber;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 两数之和小于n
        int n = sc.nextInt();
        // x % y >= k
        int k = sc.nextInt();

        long cnt= 0L;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
//                System.out.println(i + " " +j);
                if ((i % j) >= k) {
                    cnt++;
//                    System.out.println("----->"+i+" "+j);
                }
            }
        }
        System.out.println(cnt);
    }

}
