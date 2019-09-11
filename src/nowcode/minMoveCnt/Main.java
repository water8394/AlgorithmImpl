package nowcode.minMoveCnt;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{7,6,4,2};
        // 2 7 4 6
        // 2 4 6 7
        int t = solution(arr);
        System.out.println(t);
    }

    private static int solution(int[] arr) {

        int n = arr.length;
        int[] tmp = new int[n];
        int[] comp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i];
            comp[i] = arr[i];
        }

        Arrays.sort(tmp);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (tmp[i] != arr[i]){
                cnt++;
                int idx = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[j] == tmp[i]){
                        idx = j;
                        break;
                    }
                }
                int value = arr[idx];
                arr[idx] = arr[i];
                arr[i] = value;
            }
        }
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2-i1;
            }
        };
        List<Integer> list= new ArrayList<>();
        for (int tt : tmp) list.add(tt);
        Collections.sort(list,Collections.reverseOrder());
        int[] tmp2 = new int[n];
        for (int i = 0; i < n; i++) {
            tmp2[i] = list.get(i);
        }
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (tmp2[i] != comp[i]){
                cnt2++;
                int idx = 0;
                for (int j = 0; j < n; j++) {
                    if (comp[j] == tmp2[i]){
                        idx = j;
                        break;
                    }
                }
                int value = comp[idx];
                comp[idx] = comp[i];
                comp[i] = value;
            }
        }

        return Math.min(cnt,cnt2);
    }
}
