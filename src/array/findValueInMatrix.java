package array;

public class findValueInMatrix {
    public boolean Find(int target, int[][] array){

        if (array==null || array.length==0) return false;

        int rows = array.length;
        int cols = array[0].length;
        int r = 0, c = cols -1;
        while (r < rows && c >= 0) {
            if (target == array[r][c]) return true;
            else if (target > array[r][c]) r++;
            else c --;
        }

        return false;
    }
}
