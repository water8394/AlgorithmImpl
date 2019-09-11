package leftMoveMatrix;

public class Main {
    public static void main(String[] args) {
        
        String[][] matrix = new String[4][4];
        String s = solution(matrix);
        System.out.println(s);
        
    }

    private static String solution(String[][] matrix) {
        
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            int c = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == "0") c++;
            }
            cnt = Math.max(cnt, c);
        }
        int t = 0;

        while (t < cnt){
            for (int j = 0; j < matrix.length; j++) {
                for (int i = 1; i < matrix[0].length; i++) {
                    if (matrix[j][i-1] == "0"){

                    }
                }

            }


            t++;
        }
        
        return null;
        
    }
}
