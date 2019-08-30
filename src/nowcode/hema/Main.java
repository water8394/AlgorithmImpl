package nowcode.hema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int k = helper(matrix, n, m);
        System.out.println(k);
    }

    private static int helper(int[][] matrix, int n, int m) {
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                if (matrix[i][j]==1 && isOpen(matrix, i, j)){
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean isOpen(int[][] matrix, int i, int j) {
        if (matrix[i+1][j] == 1 &&matrix[i+1][j+1] == 1 &&matrix[i][j+1] == 1 ){
            matrix[i][j] = 2;
            matrix[i+1][j+1] = 2;
            matrix[i][j+1] = 2;
            matrix[i+1][j] = 2;
            return true;
        }
        return false;
    }
}
