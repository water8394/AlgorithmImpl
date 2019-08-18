package nowcode.reverseString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String raw = sc.nextLine();
        String b = "";
        int sum = 0;
        for (char c : raw.toCharArray()){
            if (c != ' '){
                b+= c;
                sum = 0;
            }else if (c == ' ' && sum == 0){
                b += c;
                sum = 1;
            }
        }
        String[] sss = b.split(" ");
        int l = 0, r= sss.length-1;
        while (l < r){
            String tmp = sss[l];
            sss[l] = sss[r];
            sss[r] = tmp;
            l++;
            r--;
        }
        String ret = "";
        for (String s : sss) {
            ret += s + " ";
        }
        System.out.println(ret);
    }
}
