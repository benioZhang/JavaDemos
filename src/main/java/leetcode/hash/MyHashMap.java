package leetcode.hash;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/design-hashmap/
 * 706. 设计哈希映射
 */
public class MyHashMap {
    private int[] mKeys;
    private int[] mValues;
    private int mSize;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        mKeys = new int[16];
        mValues = new int[mKeys.length];
    }

    public static int[] insert(int[] array, int currentSize, int index, int element) {
        // 判断是否需要扩容
        if (currentSize + 1 <= array.length) {
            System.arraycopy(array, index, array, index + 1, currentSize - index);
            array[index] = element;
            return array;
        }
        // 每次扩容为当前容量的2倍
        int[] newArray = new int[currentSize * 2];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = element;
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        return newArray;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int i = Arrays.binarySearch(mKeys, 0, mSize, key);
        if (i >= 0) {
            mValues[i] = value;
        } else {
            // Arrays.binarySearch 返回 i = -(insertion point) - 1;
            i = -i - 1;
            mKeys = insert(mKeys, mSize, i, key);
            mValues = insert(mValues, mSize, i, value);
            mSize++;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int i = Arrays.binarySearch(mKeys, 0, mSize, key);
        return i >= 0 ? mValues[i] : -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int i = Arrays.binarySearch(mKeys, 0, mSize, key);
        if (i >= 0) {
            // 数组向左移一位
            System.arraycopy(mKeys, i + 1, mKeys, i, mSize - 1 - i);
            System.arraycopy(mValues, i + 1, mValues, i, mSize - 1 - i);
            mSize--;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */