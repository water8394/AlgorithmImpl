package sortAndSearch;

import java.util.Arrays;
import java.util.List;

public class testSort {
    public static void main(String[] args) {
        Sort<Integer> sol = new HeapSort<>();
        List<Integer> a = Arrays.asList(1,2,5,3,4);
        Integer[] b = (Integer[]) a.toArray();

        sol.sort(b);

        Arrays.asList(b).forEach(e -> System.out.print(e+","));
    }
}
