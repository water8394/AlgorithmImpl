package book;

import java.util.LinkedList;

/**
 * 寻找窗口中的最大值
 */
public class GetMaxWindow {

    public static int[] getMaxWindow(int[] arr, int w) {

        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            // 队尾小于当前值的全部剔除
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            //当前元素进队
            qmax.addLast(i);
            // 删除窗口过期元素
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            // 添加窗口最大值
            if (i >= w - 1) {
                res[idx++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] inp = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] ret = getMaxWindow(inp, 3);
        for (int i : ret) {
            System.out.print(i + " ");
        }
    }

}
