package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder1 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            ret.add(new ArrayList<>());
            int l = queue.size();

            for (int i = 0; i < l; i++) {
                TreeNode t = queue.remove();
                ret.get(level).add(t.val);
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            level ++;
        }
        return ret;
    }


}
