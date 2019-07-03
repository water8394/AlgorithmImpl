package array;

import java.util.*;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            list.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] -1 ;
            if (list.get(tmp) != null){
                list.set(tmp, null);
            }
        }
        list.removeIf(Objects::isNull);
        return list;
    }


    public static void main(String[] args) {
        int[] inp = {4, 3, 2, 7, 8, 2, 3, 1};
        FindDisappearedNumbers sol = new FindDisappearedNumbers();
        List<Integer> ret = sol.findDisappearedNumbers(inp);
        ret.forEach(System.out::println);
    }
}
