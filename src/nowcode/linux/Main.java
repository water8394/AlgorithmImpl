package nowcode.linux;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ret = 0;
        int start = n;
        int end = 0;
        int pre = arr[0];
        boolean flag = false;
        for (int i = 1; i < n; i++) {

            if (arr[i] <= pre && !flag) {
                start = i;
                flag = !flag;
            }
            if (arr[i] >= pre && flag) {
                end = i - 1;
            }
            pre = arr[i];
        }

        if (end - start > 0) {
            int l = arr[start - 1];
            int r = arr[end + 1];
            int max = Math.max(l, r);
            int k = end - start;
            int f = max + k; // 区间需要保证的峰值
            if (l == r && end - start == 1) f++;
            int t = arr[start];
            int idx = start;
            for (int i = start + 1; i <= end; i++) {
                if (arr[i] > t) t = arr[i];
                idx = i;
            }
            if (t > f){
                ret += t - arr[idx];
                int tmp = 1;
                for (int i = start; i < idx; i++) {
                    ret += l - arr[i] + tmp;
                    tmp++;
                }
                tmp = 1;
                for (int i = end; i > idx; i--) {
                    ret += r - arr[i] + tmp;
                    tmp++;
                }
            }else{
                int sum = 0;
                for (int i = 0; i < end-start; i++) {
                    sum += f;
                    f--;
                }
                sum+=f;
                if (end - start > 1) sum++;
                for (int i = start; i <= end; i++) {
                    sum -= arr[i];
                }
                ret = sum;
            }

        }
        if (start == end){

            int min = Math.min(arr[start-1], arr[start+1]);
            ret += min+1 - arr[start];
        }
        if (!flag){

        }

        System.out.println(ret);

    }


}

