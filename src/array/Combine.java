package array;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        backup(ans, 1, n, k, new ArrayList<>());

        return ans;
    }

    private void backup(List<List<Integer>> ans, int i, int n, int k, List<Integer> list) {
        if (k == 0) {
            ans.add(list);
        }
        for (int j = i; j <= n; j++) {
            List<Integer> inp = new ArrayList<>();
            inp.addAll(list);
            inp.add(j);
            backup(ans, j+1, n, k-1, inp);
        }
    }

}
