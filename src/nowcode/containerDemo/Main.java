package nowcode.containerDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        String[] ret = new String[q];
        for (int i = 0; i <q; i++) {
            int x = sc.nextInt();
            int quiry = sc.nextInt();
            if (x == 1) list.add(quiry);
            if (x == 2) {
                System.out.println(helper(list, quiry));
            }
        }

    }

    private static String helper(List<Integer> list, int quiry) {

        for (int i = 1; i < list.size(); i++) {
            int check = 0;
            for (int j = 0; j < list.size()-i; j++) {
                for (int k = j; k < i+j; k++) {
                    check |= list.get(k);
                }
                if (check == quiry) return "YES";
                check = 0;
            }
        }
        return "NO";
    }

}
