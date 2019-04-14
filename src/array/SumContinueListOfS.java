package array;

import java.util.ArrayList;

public class SumContinueListOfS {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) return ret;
        int l = 1, r = 2;
        int cur = 3;
        int mid = sum / 2;
        while (r < mid || l < r) {
            if (cur == sum)
                ret.add(saveList(l, r));

            r++;
            cur += r;
            while (cur > sum) {
                cur -= l;
                l++;
            }
        }

        return ret;
    }

    private ArrayList<Integer> saveList(int l, int r) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = l; i < r; i++) {
            ret.add(i);
        }

        return ret;
    }


}
