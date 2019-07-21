package tree;

import java.util.*;

public class FindMode {


    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            int val = root.val;
            if (map.containsKey(val)){
                map.put(val, map.get(val)+1);
            }else {
                map.put(val, 1);
            }
            root = root.right;
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, (a, b) ->{
            return a.getValue() - b.getValue();
        });

        int count = -1;
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int cnt = list.get(i).getValue();
            if (cnt >= count) ret.add(list.get(i).getKey());
            count = cnt;
        }
        int[] ans = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            ans[i] = ret.get(i);
        }
        return ans;
    }

}
