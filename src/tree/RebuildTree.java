package tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RebuildTree {


    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        return reBuild(pre,0,pre.length-1,0);
    }

    private TreeNode reBuild(int[] pre, int preL, int preR, int inL){
        if (preL > preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int idx = map.get(pre[preL]);
        int leftSize = idx  - inL;
        root.left = reBuild(pre, preL+1, preL+leftSize,inL);
        root.right = reBuild(pre, preL+leftSize+1, preR,idx+1);
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
        RebuildTree sol = new RebuildTree();

        TreeNode ans = sol.reConstructBinaryTree(new int[]{3,1,2,4}, new int[]{1,2,3,4});

        sol.printNode(ans);
    }
}
