package array;

import java.util.Arrays;

public class Poker {

    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
            }
        }
        if (count >= numbers.length-1){
            return true;
        }
        int diff = 0;
        for (int i = count+1; i < numbers.length; i++) {
            diff += numbers[i] - numbers[i-1] - 1;
        }
        if (diff <= count && diff > 0){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(new Poker().isContinuous(new int[]{1,2,3,4,5}));
    }
}
