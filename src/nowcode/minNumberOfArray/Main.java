package nowcode.minNumberOfArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        boolean isSort = false;
        for (int i = arr.length-1; i >0 && !isSort; i--) {
            for (int j = 0; j < i ; j++) {
                if (!compare(arr[j+1], arr[j])){
                    isSort = false;
                    swap(arr, j, j+1);
                }
            }
        }
        String ret = "";
        for (int i : arr) {
            ret += i;
        }
        System.out.println(ret);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    public static boolean compare(int a, int b){
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        int alen = aStr.length();
        int blen = bStr.length();
        int cur1 = 0, cur2 = 0;
        while (cur1 < alen && cur2 < blen){
            int at = Integer.valueOf(aStr.charAt(cur1)+"");
            int bt = Integer.valueOf(bStr.charAt(cur2)+"");
            if (at > bt){
                return true;
            }else if (bt >at){
                return false;
            }else{
                cur1++;
                cur2++;
            }
        }
        return false;
    }

}
