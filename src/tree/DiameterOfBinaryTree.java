package tree;

public class DiameterOfBinaryTree {

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root != null) return 0;
        int left = root.left == null ? 0 : 1 + dfs(root.left);
        int right = root.right == null ? 0 : 1 + dfs(root.right);
        max = Math.max(max, right + right);
        return Math.max(right, left);
    }

}
