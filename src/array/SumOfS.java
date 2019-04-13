package array;

import java.util.ArrayList;

public class SumOfS {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (array.length == 0) return ret;
        int l = 0, r = array.length-1;
        while (l < r){
            int total = array[l] + array[r];
            if (total == sum){
                ret.add(array[l]);
                ret.add(array[r]);
                return ret;
            }else if (total > sum){
                r--;
            }else{
                l++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<Integer> val;
        val = new SumOfS().FindNumbersWithSum(new int[]{1,2,4,7,11,15}, 15);
        val.forEach(System.out::println);
    }
}
