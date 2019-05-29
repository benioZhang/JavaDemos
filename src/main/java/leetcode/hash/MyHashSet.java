package leetcode.hash;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/design-hashset/
 * 705. 设计哈希集合
 */
public class MyHashSet {
    private int[] mValues;
    private int mSize;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        mValues = new int[10];
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

    public void add(int key) {
        int i = Arrays.binarySearch(mValues, 0, mSize, key);
        if (i >= 0) {
            // key 已在集合中
            return;
        }
        // Arrays.binarySearch 返回 i = -(insertion point) - 1;
        i = -i - 1;
        mValues = insert(mValues, mSize, i, key);
        mSize++;
    }

    public void remove(int key) {
        int i = Arrays.binarySearch(mValues, 0, mSize, key);
        if (i >= 0) {
            // 数组向左移一位
            System.arraycopy(mValues, i + 1, mValues, i, mSize - 1 - i);
            mSize--;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return Arrays.binarySearch(mValues, 0, mSize, key) >= 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */