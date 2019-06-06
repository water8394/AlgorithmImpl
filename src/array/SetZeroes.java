package array;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean flagH = false;
        boolean flagV = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i]==0) flagH=true;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==0) flagV=true;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0){
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (flagH){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flagV){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1};
        int[] b = new int[]{0,1,2};
        int[] c = new int[]{4,1,2};
        int[][] matrix = new int[][]{a,b,c};
        SetZeroes sol = new SetZeroes();
        sol.setZeroes(matrix);

    }
}
