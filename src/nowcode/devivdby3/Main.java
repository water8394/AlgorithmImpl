package nowcode.devivdby3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int sum = 0;
        int cnt = 0;
        if (start < end){
            System.out.println(cnt);
            return;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < start; i++) {
            sb.append(String.valueOf(i));
        }
        for (int i = start; i <= end; i++) {
            sb.append(String.valueOf(i));
            int t = Integer.parseInt(sb.toString());
            if (t % 3 == 0){
                cnt ++ ;
            }
        }
        System.out.println(cnt);
    }

}
