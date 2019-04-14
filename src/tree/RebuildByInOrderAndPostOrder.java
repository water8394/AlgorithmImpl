package tree;


import java.util.HashMap;

public class RebuildByInOrderAndPostOrder {

    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        System.out.println();
        return reBuild(postorder, 0, postorder.length-1, 0);
    }

    private TreeNode reBuild(int[] postOrder, int postL, int postR, int inL){
        if (postL > postR) return null;
        TreeNode root = new TreeNode(postOrder[postR]);
        int idx = map.get(postOrder[postR]);
        int size = idx - inL;
        root.left = reBuild(postOrder, postL, postL+size-1, inL);
        root.right = reBuild(postOrder, postL+size, postR-1, idx+1);

        return root;
    }

    private void printNode(TreeNode root){
        if (root != null){
            System.out.println(root.val);
            printNode(root.left);
            printNode(root.right);
        }

    }

    public static void main(String[] args) {
        RebuildByInOrderAndPostOrder sol = new RebuildByInOrderAndPostOrder();

        TreeNode ans = sol.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

        sol.printNode(ans);
    }
}
