package tree;

import java.util.LinkedList;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(root);
        while (!list.isEmpty()){
            TreeNode t1 = list.poll();
            TreeNode t2 = list.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            list.add(t1.left);
            list.add(t2.right);
            list.add(t1.right);
            list.add(t2.left);
        }

        return true;
    }

}
