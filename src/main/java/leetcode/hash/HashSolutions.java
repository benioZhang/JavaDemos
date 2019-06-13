package leetcode.hash;

import java.util.*;

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

    /**
     * https://leetcode-cn.com/problems/intersection-of-two-arrays/
     * 349. 两个数组的交集
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        // 将num1加入到HashSet中
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        // 判断nums2的元素是否在num1中，存在则加入到intersection
        Set<Integer> intersection = new HashSet<>(nums2.length);
        for (Integer num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for (Integer num : intersection) {
            result[i++] = num;
        }
        return result;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] intersection = new int[nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // 判断nums1[i]是否已添加到intersections中
                if (k == 0 || intersection[k - 1] != nums1[i]) {
                    intersection[k++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[k];
        System.arraycopy(intersection, 0, result, 0, result.length);
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/happy-number/
     * 202. 快乐数
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int sum, tmp;
        while (n != 1) {
            // 分拆n的每一位，并计算其每个位置上的数字的平方和
            sum = 0;
            while (n != 0) {
                tmp = n % 10;
                sum += tmp * tmp;
                n = n / 10;
            }
            // 如果set中已经包含这个数，则说明无限循环了，则退出循环
            // 如果set中不包含n，则继续循环计算
            if (!set.add(sum)) {
                return false;
            }
            n = sum;
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/two-sum/
     * 1. 两数之和
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        Integer delta, value;
        for (int i = 0; i < nums.length; i++) {
            delta = target - nums[i];
            value = map.get(delta);
            if (value != null) {
                return new int[]{value, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * https://leetcode-cn.com/problems/isomorphic-strings/
     * 205. 同构字符串
     * 在s中相同字符的位置，t中这些位置的字符都相同
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 查找当前字符在字符串中出现的位置，如果是同构字符串，每个字符出现的位置是相同的
        for (int i = 0; i < s.length(); i++) {
            // 比较s[i]在s中出现的位置和t[i]在t中出现的位置，如果是同构字符串，两者相等
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
