package nowcode.aqiyi;

public class Main {
    public static void main(String[] args) {
        int[][] mat = new int[2][6];
        mat[0] = new int[]{0,2,4,6,8,10};
        mat[1] = new int[]{1,3,5,7,9,11};
        int row = 2;
        int col = 6;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = mat[i][mat[0].length-1-j];
            }
        }
        for (int i : mat[0]) {
            System.out.print(i + " ");

        }
        System.out.println(" ");
        for (int i : mat[1]) {
            System.out.print(i + " ");

        }
    }
}
