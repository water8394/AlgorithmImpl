package nowcode.wakeup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int continueTime = sc.nextInt();
        int[] value = new int[total];
        int[] isSleep = new int[total];
        int ret = 0;
        for (int i = 0; i < total; i++) {
            value[i] = sc.nextInt();
        }
        for (int i = 0; i < total; i++) {
            isSleep[i] = sc.nextInt();
        }

        for (int i = 0; i < total; i++) {
            if (isSleep[i] == 1) ret += value[i];
        }
        int max = 0;
        for (int i = 0; i < total; i++) {
            if (isSleep[i] == 0){
                max = Math.max(max, helper(value, isSleep, i, continueTime));
            }
        }
        System.out.println(ret+max);

    }

    private static int helper(int[] value, int[] isSleep, int start, int continueTime) {
        int ret = 0;
        int end = start + continueTime > value.length ? value.length-1 : start+ continueTime-1;
        for (int i = start; i <= end; i++) {
            if (isSleep[i] == 0) ret += value[i];
        }
        return ret;
    }


}
