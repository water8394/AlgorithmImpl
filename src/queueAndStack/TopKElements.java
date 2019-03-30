package queueAndStack;

import java.util.*;

public class TopKElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> h = new HashMap<>();
        int max_freq = 1;
        for (int num: nums) {
            if (!h.containsKey(num)){
                h.put(num, 1);
            }else{
                h.put(num, h.get(num)+1);
                max_freq = Math.max(max_freq, h.get(num));
            }
        }
        HashMap<Integer, ArrayList<Integer>> buckets = new HashMap<>();

        for (HashMap.Entry<Integer, Integer> entry: h.entrySet()) {
            ArrayList<Integer> temp = buckets.get(entry.getValue());
            if (temp == null){
                temp = new ArrayList<>();
            }
            temp.add(entry.getKey());
            buckets.put(entry.getValue(), temp);
        }

        List<Integer> answer = new ArrayList<>(k);
        int idx = 0;

        for (int i = max_freq; i >= 1; i--) {
            if (buckets.containsKey(i)){
                ArrayList<Integer> v = buckets.get(i);
                for (int j = 0; j < v.size(); j++) {
                    answer.add(v.get(j));
                    idx++;
                    if (idx >= k){
                        return answer;
                    }
                }
            }
        }
        return answer;

    }


    public static void main(String[] args) {

        TopKElements top = new TopKElements();
        int[] m = new int[]{1};
        List<Integer> val = top.topKFrequent(m, 2);

        val.forEach(System.out::print);

    }
}
