package nowcode.cityMonster;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] city = new int[n+1];
        int[] b = new int[n];
        for (int i = 0; i < n+1; i++) {
            city[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (city[i] >= b[i]){
                sum += b[i];
            }else{
                sum+= city[i];
                b[i] -= city[i];
                if (city[i+1] > b[i]){
                    sum += b[i];
                    city[i+1] -= b[i];
                }else{
                    sum += city[i+1];
                    city[i+1] = 0;
                }
            }
        }
        System.out.println(sum);
    }


}
