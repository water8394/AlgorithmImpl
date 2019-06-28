package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalTraversal {

    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        locations = new ArrayList<>();
        dfs(root, 0, 0);

        Collections.sort(locations);
        ans.add(new ArrayList<Integer>());
        int prev = locations.get(0).x;
        for (Location loc : locations) {
            if (loc.x != prev){
                prev = loc.x;
                ans.add(new ArrayList<Integer>());
            }
            ans.get(ans.size()-1).add(loc.val);

        }
        return ans;
    }

    private void dfs(TreeNode root, int left, int right) {
        if (root != null){
            locations.add(new Location(left, right, root.val));
            dfs(root.left, left-1, right +1);
            dfs(root.right, left+1, right +1);
        }

    }

}
class Location implements Comparable<Location>{
    int x,y,val;

    public Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Location that) {
        if (this.x != that.x){
            return Integer.compare(this.x, that.x);
        }else if (this.y != that.y){
            return Integer.compare(this.x, that.x);
        }else {
            return Integer.compare(this.val, that.val);
        }
    }
}
