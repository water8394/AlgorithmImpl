package nowcode.findIndex;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ss = s.substring(1,s.length()-1);
        String[] sArr = ss.split(",");
        int[] arr = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.valueOf(sArr[i]);
        }
        Arrays.sort(arr);
        int target = 19;
        // 递归调用方法
        int idx = find(arr, target, 0, arr.length-1);
        if (idx == -1) System.out.println(-1);
        else System.out.println(idx+1);
    }

    private static int find(int[] arr, int target, int l, int h) {
        if (l == h && arr[l]== target) return l;
        if (l >= h) return -1;
        int mid = l + (h-l)/2;
        int tmp = arr[mid];
        if (tmp == target){
            return mid;
        }else if (tmp < target){
            return find(arr,target,mid+1,h);
        }else{
            return find(arr,target,l,mid-1);
        }
    }
}
