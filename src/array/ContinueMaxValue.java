package array;

public class ContinueMaxValue {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) return 0;
        int sumValue = Integer.MIN_VALUE;
        int sum = 0;
        for (int num: array) {
            sum = sum <= 0 ? num : num+sum;
            sumValue = Math.max(sum, sumValue);
        }

        return sumValue;
    }
}
