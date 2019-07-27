package nowcode.lostDirection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L'){
                cnt++;
            }else{
                cnt--;
            }
        }
        boolean flag = cnt>0 ? true :false;
        cnt = Math.abs(cnt);
        String[] direction = {"N", "W","S","E"};
        String[] rDirection = {"N","E","S","W"};
        int left = cnt % 4;
        if (flag) {
            System.out.println(direction[left]);
        }else{
            System.out.println(rDirection[left]);
        }

    }
}
