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

    /**
     * https://leetcode-cn.com/problems/single-number/
     * 136. 只出现一次的数字
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int num, i = 0, j;
        while (i < nums.length) {
            num = nums[i];
            j = i;
            // 相同则继续移动i
            while (i + 1 < nums.length && num == nums[i + 1]) {
                i++;
            }
            // 如果j和i相等，说明只出现了一次，直接返回对应的数值
            if (j == i) {
                return nums[i];
            }
            i++;
        }
        return 0;
    }

    // a ^ b ^ a ^ c ^ c = a ^ a ^ c ^ c ^ b = 0 ^ 0 ^ b = b
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
