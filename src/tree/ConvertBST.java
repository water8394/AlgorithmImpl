package tree;

public class ConvertBST {

    private int total = 0;

    public TreeNode convertBST(TreeNode root) {
        sum(root);
        return root;
    }

    private void sum(TreeNode root) {
        if (root != null) {
            sum(root.right);
            total += root.val;
            root.val = total;
            sum(root.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        ConvertBST sol = new ConvertBST();
        sol.convertBST(root);

        System.out.println("-");


    }
}
