package tree;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return createNode(t1, t2);
    }

    private TreeNode createNode(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 ==null) return null;
        int a = t1 != null ? t1.val : 0;
        int b = t2 != null ? t2.val : 0;
        TreeNode ret = new TreeNode(a + b);
        if (t1 == null && t2 != null){
        ret.left = createNode(null, t2.left);
        ret.right = createNode(null, t2.right);
        }else if (t2 == null && t1 != null){
            ret.left = createNode(t1.left, null);
            ret.right = createNode(t1.right, null);
        }else if (t1 != null){
            ret.left = createNode(t1.left, t2.left);
            ret.right = createNode(t1.right, t2.right);
        }
        return ret;
    }

}
