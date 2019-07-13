package array;

public class CountBits {
    public int[] countBits(int num) {
        int[] ret = new int[num+1];
        for (int i = 0; i <= num; i++) {
            ret[i] = popCount(i);
        }
        return ret;
    }

    private int popCount(int i) {
        int count;
        for (count = 0;i!= 0; count++) {
            i &= i-1;
        }
        return  count;
    }


}
