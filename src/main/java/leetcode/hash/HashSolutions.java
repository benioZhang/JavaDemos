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
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
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
     * 在s中相同字符的位置与t中相同字符的位置相同
     */
    public static boolean isIsomorphic(String s, String t) {
        // 查找当前字符在字符串中出现的位置，如果是同构字符串，每个字符出现的位置是相同的
        for (int i = 0; i < s.length(); i++) {
            // 比较s[i]在s中出现的位置和t[i]在t中出现的位置，如果是同构字符串，两者相等
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        // 在s中相同字符的位置与t中相同字符的位置相同
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        char sChar, tChar;
        for (int i = 0; i < s.length(); i++) {
            // 在s中相同字符的位置与t中相同字符的位置相同
            sChar = s.charAt(i);
            tChar = t.charAt(i);
            if (sMap[sChar] != tMap[tChar]) {
                return false;
            }
            // 此处加1是因为 0 为无效值，所以将所有index加1
            sMap[sChar] = i + 1;
            tMap[tChar] = i + 1;
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
     * 599. 两个列表的最小索引总和
     * A:
     * 1. map保存list1中 value - index 的映射
     * 2. 遍历list2，判断list2的元素是否在map中
     * 3. 若list2的元素不在map中，则忽略
     * 4. 若list2的元素在map中，则将该元素在list2中的下标与该元素在ist1中的下标相加，得出索引和
     * 5. 如果当前索引和等于最小索引和，则将该元素添加到返回结果中
     * 6. 如果当前索引和小于最小索引和，则当前返回结果无效。此时需清空返回结果列表，并将该元素添加到返回结果中，更新最小索引和
     * 7. 如果当前索引和大于最小索引和，则忽略
     * 8. 遍历list2结束后，返回维护的返回结果列表
     */
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE, tmp;
        Integer index;
        for (int i = 0; i < list2.length; i++) {
            index = map.get(list2[i]);
            if (index != null) {
                tmp = index + i;
                if (tmp < min) {
                    min = tmp;
                    result.clear();
                    result.add(list2[i]);
                } else if (tmp == min) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

    /**
     * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
     * 387. 字符串中的第一个唯一字符
     */
    public static int firstUniqChar(String s) {
        // 注意事项：您可以假定该字符串只包含小写字母。
        int[] map = new int[26];
        // 遍历s，得出每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        // 遍历s，找出第一个出现一次的字符，返回其下标
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
     * 350. 两个数组的交集 II
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        // 将nums1加入到HashMap中，记录元素与其在nums1中出现次数的映射
        Integer count;
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (Integer num : nums1) {
            count = map.get(num);
            count = count == null ? 1 : count + 1;
            map.put(num, count);
        }
        // 判断nums2的元素在nums1出现的次数是否大于0，是则加入到intersection，并更新map中其出现的次数
        List<Integer> intersection = new ArrayList<>(nums2.length);
        for (Integer num : nums2) {
            count = map.get(num);
            if (count != null && count > 0) {
                map.put(num, count - 1);
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
}
