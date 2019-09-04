package nowcode.diffJob;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m,int[] array) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = 0;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int t : array) list.add(t);
        Collections.sort(list);
        boolean isLeft = true;
        while (!list.isEmpty()){
            for (int i = 0; i < arr.length; i++) {
                if (!list.isEmpty()){
                    if (isLeft){
                        int k = list.pollFirst();
                        arr[i] += k;
                    }else{
                        int k = list.pollLast();
                        arr[i] += k;
                    }
                }else{
                    break;
                }
            }
            isLeft = !isLeft;
        }
        
        int max = Integer.MIN_VALUE;
        for(int t : arr) max = Math.max(max, t);
        return max;
    
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
