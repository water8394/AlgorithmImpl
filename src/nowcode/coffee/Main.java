package nowcode.coffee;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        People[] t = new People[n];
        for (int i = 0; i < n; i++) {
            t[i] = new People(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(t);


        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += t[i-1].a * (i-1) + t[i-1].b*(n-i);
        }
        System.out.println(sum);
    }


    public static class People implements Comparable<People>{
        int a;
        int b;
        public People(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(People o) {
            if (this.a == o.a) return this.b-o.b;
            if (this.b == o.b) return o.a - this.a;
            if (this.a > o.a && this.b > o.b) return -this.a+this.b;
            if (this.a < o.a && this.b < o.b) return -o.a+o.b;

            return -this.a-this.b + o.a+o.b;

        }
    }

}
