package nowcode.reverse01;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(arr[0]);
        int cnt = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] != list.peekLast()){
                list.add(arr[i]);
                cnt = 1;
                max = Math.max(max, cnt);
            }else{
                cnt++;
            }
        }
        max = Math.max(max, cnt);
        int ans = list.size();
        if (max > 2) ans +=2;
        System.out.println(ans);
    }
}
