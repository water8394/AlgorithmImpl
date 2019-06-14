package array;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int tmp = digits[i] + plus;
            if (tmp == 10){
                digits[i] = 0;
                plus = 1;
            }
            else {
                plus = 0;
            }
        }
        if (plus == 1){
            int[] ans = new int[digits.length+1];
            System.arraycopy(digits,0,ans,1, digits.length);
            ans[0] = 1;
            return ans;
        }
        return digits;
    }

}
