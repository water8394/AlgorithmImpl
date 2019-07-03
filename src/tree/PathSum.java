package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        sum(root, new ArrayList<Integer>(), ans);

        int ret = 0;
        for (int i = 0; i < ans.size(); i++) {
            int total = 0;
            for (int j = ans.get(i).size()-1; j > 0 ; j--) {
                total += ans.get(i).get(j);
                if (total == sum){
                    ret += 1;
                    break;
                }
            }
        }
        return ret;

    }

    private void sum(TreeNode root, List<Integer> list, List<List<Integer>> ans) {
        if (root != null){
            list.add(root.val);
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            left.addAll(list);
            right.addAll(list);
            sum(root.left, left, ans);
            sum(root.right, right, ans);

        }
        ans.add(list);
    }
}
