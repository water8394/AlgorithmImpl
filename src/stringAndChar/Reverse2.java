
package stringAndChar;

public class Reverse2 {

    public int reverse(int x) {
        int ret = 0;
        int flag = x >= 0 ? 1 : -1;
        int border = (Integer.MAX_VALUE - 7) / 10;
        if (x < 0) x *= -1;
        while (x > 0){
            int tmp;
            if ( x > 9){
                tmp = x%10;
                x = (x-tmp) / 10;
            }else {
                tmp = x;
                x = 0;
            }
            if ((ret > border) ||((ret == border) && ((flag == 1 && tmp > 7) || (flag == -1 && tmp > 8)))){
                return 0;
            }
            ret = 10 * ret + tmp;
        }
        return ret*flag;
    }

    public static void main(String[] args) {
        Reverse2 sol = new Reverse2();
        int reverse = sol.reverse(1534236469);
        System.out.println(reverse);
    }
}
