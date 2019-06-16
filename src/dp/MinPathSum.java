package dp;

import java.util.ArrayList;
import java.util.List;

public class MinPathSum {


    public int minPathSum(int[][] grid) {
        int y = grid.length-1;
        int x = grid[0].length-1;
        int[] val = grid[grid.length-1];
        int min = Integer.MAX_VALUE;
        for (int i = y; i >= 0; i--) {
            for (int j = x; j >= 0; j--) {
                if (j < x && i < y){
                    grid[i][j] = grid[i][j] + Math.min(grid[i+1][j],grid[i][j+1]);
                }else if (j < x){
                    grid[i][j] = grid[i][j] + grid[i][j+1];
                }else if (i < y){
                    grid[i][j] = grid[i][j] + grid[i+1][j];
                }
            }
        }
        return grid[0][0];
    }



    public int minPathSum2(int[][] grid) {
        List<List<Integer>> ans = new ArrayList<>();
        backup(ans,grid, 0, 0, new ArrayList<Integer>());
        int min = Integer.MAX_VALUE;
        for (List<Integer> l : ans){
            min = Math.min(min, l.stream().mapToInt(Integer::intValue).sum());
        }
        return min;
    }

    private void backup(List<List<Integer>> ans, int[][] grid, int x, int y, ArrayList<Integer> integers) {
        if (x == grid[0].length-1 && y == grid.length-1){
            integers.add(grid[y][x]);
            ans.add(integers);
            return;
        }
        if (x < grid[0].length-1 && y <= grid.length-1){
            ArrayList<Integer> inp = new ArrayList<>();
            inp.addAll(integers);
            inp.add(grid[y][x]);
            backup(ans,grid, x+1, y, inp);
        }
        if (y < grid.length-1 && x <= grid[0].length-1){
            ArrayList<Integer> inp = new ArrayList<>();
            inp.addAll(integers);
            inp.add(grid[y][x]);
            integers.add(grid[y][x]);
            backup(ans,grid, x, y+1, inp);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,5};
        int[] b = {3,2,1};
//        int[] c = {4,5,7};
        int[][] l = {a,b};
        MinPathSum sol = new MinPathSum();
        int i = sol.minPathSum(l);
        System.out.println("-:"+i);
    }

}
