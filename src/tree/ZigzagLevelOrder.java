package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelsize = queue.size();
            for(int i = 0; i < levelsize; i++){
                TreeNode node = queue.remove();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);

                if(flag) level.add(node.val); // list尾部添加
                else level.add(0, node.val); // list头部添加
            }
            flag = !flag;
            res.add(level);
        }
        return res;
    }

}
