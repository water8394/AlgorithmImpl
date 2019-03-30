package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private int[] list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new int[10];
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.length);
            reSize(list.length + 1);
            list[list.length - 1] = val;
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int oldIndex = map.get(val);
            map.put(list[list.length - 1],oldIndex);
            list[oldIndex] = list[list.length - 1];

            reSize(list.length-1);
            map.remove(val);
            return true;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int max = map.size();
        if (max <= 0) return 0;
        Random random = new Random();
        int idx = random.nextInt(max);
        return list[idx];
    }

    private void reSize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        if (newCapacity < list.length) {
            System.arraycopy(list, 0, newArray, 0, newCapacity);
        }else {
            System.arraycopy(list, 0, newArray, 0, list.length);
        }
        list = newArray;
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(3);
        set.insert(-2);
        set.remove(2);

        set.insert(1);
        set.insert(-3);
        set.insert(-2);
        set.remove(3);
        set.remove(-1);
        set.insert(-3);
        System.out.println(set.getRandom());
    }
}
