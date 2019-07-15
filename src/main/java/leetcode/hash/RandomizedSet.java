package leetcode.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 380. 常数时间插入、删除和获取随机元素
 */
public class RandomizedSet {
    // val - index
    private Map<Integer, Integer> valMap = new HashMap<>();
    // index - val
    private Map<Integer, Integer> indexMap = new HashMap<>();
    private Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valMap.containsKey(val)) {
            return false;
        }
        Integer index = valMap.size();
        valMap.put(val, index);
        indexMap.put(index, val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valMap.containsKey(val)) {
            return false;
        }
        // 将最后一个元素（当前index最大）与要删除的元素交换位置
        // 原本(val,index)，(val2,index2)，变为(val,index2)，(val2,index)
        // 并且要删除(val,index2)，所以最后只剩下(val2,index)
        Integer index = valMap.get(val);
        Integer index2 = valMap.size() - 1;
        Integer val2 = indexMap.get(index2);
        valMap.put(val2, index);
        indexMap.put(index, val2);
        valMap.remove(val);
        indexMap.remove(index2);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Integer index = random.nextInt(valMap.size());
        return indexMap.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */