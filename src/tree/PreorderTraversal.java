package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ret;
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            ret.add(pop.val);
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
        return ret;
    }
}
