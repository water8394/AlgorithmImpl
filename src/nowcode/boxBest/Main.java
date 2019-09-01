package nowcode.boxBest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] box = new int[n];
        int[] key = new int[m];
        int box_a = 0;
        int box_b = 0;
        int key_a = 0;
        int key_b = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t% 2== 0){
                box_a++;
            }else{
                box_b++;
            }
            box[i] = t;
        }
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            if (t% 2== 0){
                key_a++;
            }else{
                key_b++;
            }
            key[i] = t;
        }

        if ((box_a== 0 && key_a==0) || (box_b==0 && key_b == 0)) {
            System.out.println(0);
            return;
        }
        System.out.println(Math.min(box_a,key_b) + Math.min(box_b,key_a));
    }

}
