package stringAndChar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddZeros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> ret = new ArrayList<>();
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String str = scanner.next();
                if ("".equals(str)) ret.add("");
                if (str.length() <= 8) {
                    for (int j = str.length(); j < 8; j++) {
                        str += "0";
                    }
                    ret.add(str);
                }else {
                    for (int j = 0; j < str.length(); j+=8) {
                        int remain = str.length() - j;
                        if (remain <= 8) {
                            String remain_str = str.substring(j, str.length());
                            for (int k = remain; k < 8; k++) {
                                remain_str += "0";
                            }
                            ret.add(remain_str);
                        }else {
                            ret.add(str.substring(j,j+8));
                        }
                    }
                }

            }
            Collections.sort(ret);
            ret.stream().forEach(System.out::println);
        }
    }

}
