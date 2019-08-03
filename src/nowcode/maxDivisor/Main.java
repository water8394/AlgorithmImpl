package nowcode.maxDivisor;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b= new BigInteger(sc.next());
        if (a.equals(0) || b.equals(0)) {
            System.out.println("0");
            return;
        }
        int i = 10;
        for (i = 10; i < 1000000000; i++) {
            if (a.subtract(b.multiply(new BigInteger(i + ""))).compareTo(new BigInteger("0")) < 0) {
                break;
            }
        }
        a = a.subtract(b.multiply(new BigInteger(i/10 + "")));
        long m = a.longValue();
        long n = b.longValue();

        while (n > 0){
            long r = m%n;
            m = n;
            n = r;
        }
        System.out.println(m);
    }
}
