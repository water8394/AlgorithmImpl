
package nowcode.mood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        LinkedList<Mood> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Mood(l[i],w[i]));
        }
        Collections.sort(list, (a,b) -> b.l-a.l);
        int layer = helper(list,Integer.MAX_VALUE,Integer.MAX_VALUE) + 1;
        System.out.println(layer);

    }

    private static int helper(LinkedList<Mood> list, int maxL, int maxW) {

        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(0);
        for (int i = 0; i < list.size(); i++) {
            Mood tmp = list.get(i);
            if (tmp.l <maxL && tmp.w < maxW){
                LinkedList<Mood> newList = new LinkedList<>();
                newList.addAll(list);
                newList.remove(i);
                int min = Math.min(tmp.w * 7, maxW-tmp.w);
                ret.add(helper(newList, tmp.l, min)+1);
            }
        }
        int max = 0;
        for (int i = 0; i < ret.size(); i++) {
            max = Math.max(ret.get(i), max);
        }
        return max;
    }

    public static class Mood{
        int l;
        int w;

        public Mood(int l, int w) {
            this.l = l;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Mood{" +
                    "l=" + l +
                    ", w=" + w +
                    '}';
        }
    }


}
