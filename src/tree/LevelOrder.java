package tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {

    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return ret;
        help(root, 0);
        return ret;
    }

    private void help(TreeNode root, int i) {
        if (ret.size() == i) ret.add(new ArrayList<>());

        ret.get(i).add(root.val);
        if (root.left != null) help(root.left, i+1);
        if (root.right != null) help(root.right, i+1);

    }

}
