package leetcode.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSolutions {
    /**
     * https://leetcode-cn.com/problems/contains-duplicate/
     * 217. 存在重复元素
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (Integer n : nums) {
            // 如果set不包含这个key，add()返回true
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
