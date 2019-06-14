package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backup(ans, candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void backup(List<List<Integer>> ans, int[] candidates, int target, int i, List<Integer> list) {

        if (target == 0){
            ans.add(list);
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] <= target){
                int t = target - candidates[j];
                List<Integer> inp = new ArrayList<>();
                inp.addAll(list);
                inp.add(candidates[j]);
                backup(ans, candidates, t, j, inp);
            }
        }

    }

    public static void main(String[] args) {
        CombinationSum sol = new CombinationSum();
        List<List<Integer>> lists = sol.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println("-");
    }

}
