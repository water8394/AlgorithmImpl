package book.online.minLoad;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix =  new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int res = minPathSum(matrix);
        System.out.println(res);
    }

    private static int minPathSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0){
            return 0;
        }
        int more = Math.max(m.length, m[0].length);
        int less = Math.min(m.length, m[0].length);

        boolean rowmore = more == m.length;
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i-1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j], arr[j-1]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less-1];
    }
}
