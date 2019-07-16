package leetcode.hash;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 380. 常数时间插入、删除和获取随机元素
 */
public class RandomizedSet2 {
    // val - index
    private Map<Integer, Integer> map = new HashMap<>();
    // val
    private List<Integer> vals = new ArrayList<>();
    private Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet2() {
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, vals.size());
        vals.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int end = vals.size() - 1;
        int i = map.get(val);
        if (i != end) {
            // 更新最后一个元素的值对应的下标
            map.put(vals.get(end), i);
            // 将最后一个元素更新到要删除的元素位置上
            vals.set(i, vals.get(end));
        }
        // 删除最后一个元素
        vals.remove(end);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return vals.get(random.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */