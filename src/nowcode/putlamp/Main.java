package nowcode.putlamp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            String load = sc.next();
            int cnt = 0;
            int cur = 0;
            while (cur < len-1){
                if (load.charAt(cur) == '.'){
                    cnt++;
                    cur +=3;
                }else{
                    cur++;
                }
            }
            System.out.println(cnt);
        }
    }
}
