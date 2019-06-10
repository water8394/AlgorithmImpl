package array;

public class Rotate2 {

    public void rotate(int[][] matrix) {
        if (matrix.length < 2) return;
        int layers = matrix.length / 2;
        int lm = matrix.length-1;
        for (int i = 0; i < (lm)/2+1; i++) {
            for (int j = 0; j < (lm)/2+1 ; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[lm-j][i];
                matrix[lm-j][i]=matrix[lm-i][lm-j];
                matrix[lm-i][lm-j]=matrix[j][lm-i];
                matrix[j][lm-i]=temp;
            }
        }

    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5,6};
        int[] c = {7,8,9};
        int[][] matrix = {a, b, c};
        Rotate2 sol = new Rotate2();
        sol.rotate(matrix);
        System.out.println("a");

    }

}
