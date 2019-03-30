package dp;

public class Fibo {

    public int Fibonacci(int n) {
        if (n <= 1) return n;
        int[] val = new int[n+1];
        val[0] = 0; val[1] = 1;
        for (int i = 2; i < n+1; i++) {
            val[i] = val[i-1] + val[i-2];
        }
        return val[n];
    }

    public int recFibo(int n){
        if (n <= 1) return n;
        return recFibo(n-1) + recFibo(n-2);
    }

    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        System.out.println(fibo.Fibonacci(5));
        System.out.println(fibo.recFibo(5));
    }
}
