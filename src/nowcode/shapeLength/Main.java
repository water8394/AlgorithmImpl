package nowcode.shapeLength;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = sc.nextInt();
                matrix[i][j] = t;
                sum += t*6;
                if (t > 1) sum -= (t-1)*2;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] >0 && matrix[i][j-1] > 0){
                    sum -= Math.min(matrix[i][j] ,matrix[i][j-1]) * 2;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] >0 && matrix[i-1][j] > 0){
                    sum -= Math.min(matrix[i][j],matrix[i-1][j]) * 2;
                }
            }
        }
        System.out.println(sum);
    }

}
