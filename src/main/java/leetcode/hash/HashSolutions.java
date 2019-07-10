package leetcode.hash;

import leetcode.binarytree.TreeNode;

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

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersection[k++] = nums1[i];
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
     * https://leetcode-cn.com/problems/contains-duplicate-ii/
     * 219. 存在重复元素 II
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // 记录元素与其下标的映射
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        Integer index;
        for (int i = 0; i < nums.length; i++) {
            index = map.get(nums[i]);
            // 获取前一个重复元素的下标，判断i - index是否最大为k
            if (index != null && i - index <= k) {
                return true;
            }
            // 两种情况需要更新元素与其下标的映射
            // 1.map中不存在该元素与其下标的映射
            // 2.前一个重复元素的下标与当前下标的差的绝对值大于k
            // 这里说下第二种情况需要更新的原因
            // 因为i - index > k，所以i之后的下标i'都不可能满足i' - index <= k。但是i与i'仍有可能满足该条件
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/group-anagrams/
     * 49. 字母异位词分组
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            // 将s的字母排序
            Arrays.sort(chars);
            String key = new String(chars);
            // 获取同一组字母异位词
            List<String> val = map.get(key);
            if (val == null) {
                val = new ArrayList<>();
                map.put(key, val);
            }
            val.add(s);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * https://leetcode-cn.com/problems/valid-sudoku/
     * 36. 有效的数独
     * box_index = (row / 3) * 3 + col / 3
     */
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        int num, boxIndex;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // '.'表示空白，忽略
                if (board[i][j] != '.') {
                    // 获取数字，数字范围 1-9
                    num = board[i][j] - '1';
                    boxIndex = (i / 3) * 3 + j / 3;
                    // 如果该数字已经出现过，则返回false
                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }
                    // 第i行，数字board[i][j]出现，标记为true
                    rows[i][num] = true;
                    // 第j列，数字board[i][j]出现，标记为true
                    cols[j][num] = true;
                    // 第((i / 3) * 3 + j / 3)个3x3宫，数字board[i][j]出现，标记为true
                    boxes[boxIndex][num] = true;
                }
            }
        }
        return true;
    }

    /**
     * 参考leetcode用时1ms的解答
     * 利用位，记录数字是否出现过
     */
    public static boolean isValidSudoku2(char[][] board) {
        // 用一维数组记录board中元素是否出现过
        // 若rows[i]的二进制第j位为0，表示第i行值为j的元素没出现过
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];
        int num, boxIndex;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // '.'表示空白，忽略
                if (board[i][j] != '.') {
                    // num的二进制只有第board[i][j]位为1
                    num = 1 << (board[i][j] - '1');
                    boxIndex = (i / 3) * 3 + j / 3;
                    // 如果第board[i][j]位上，任何一个为1都返回false。
                    if ((rows[i] & num) != 0 || (cols[j] & num) != 0 || (boxes[boxIndex] & num) != 0) {
                        return false;
                    }
                    // 将rows，cols，boxes第board[i][j]位置为1
                    rows[i] |= num;
                    cols[j] |= num;
                    boxes[boxIndex] |= num;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku3(char[][] board) {
        // 表示正在访问行的所有元素出现的情况
        int row = 0;
        int[] cols = new int[9];
        int[] boxes = new int[9];
        int num, boxIndex;
        for (int i = 0; i < 9; i++) {
            // 重置该行
            row = 0;
            for (int j = 0; j < 9; j++) {
                // '.'表示空白，忽略
                if (board[i][j] != '.') {
                    // num的二进制只有第board[i][j]位为1
                    num = 1 << (board[i][j] - '1');
                    boxIndex = (i / 3) * 3 + j / 3;
                    // 如果第board[i][j]位上，任何一个为1都返回false。
                    if ((row & num) != 0 || (cols[j] & num) != 0 || (boxes[boxIndex] & num) != 0) {
                        return false;
                    }
                    // 将rows，cols，boxes第board[i][j]位置为1
                    row |= num;
                    cols[j] |= num;
                    boxes[boxIndex] |= num;
                }
            }
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/find-duplicate-subtrees/
     * 652. 寻找重复的子树
     */
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        findDuplicateSubtrees(root, map, result);
        return result;
    }

    private static String findDuplicateSubtrees(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) {
            return "#";
        }
        // 将树序列化，顺序：根，左子树，右子树
        String str = root.val +
                findDuplicateSubtrees(root.left, map, result) +
                findDuplicateSubtrees(root.right, map, result);
        Integer count = map.get(str);
        count = count == null ? 1 : count + 1;
        map.put(str, count);
        // 同样的结构的树的出现次数为2时，将节点加入到返回结果中
        if (count == 2) {
            result.add(root);
        }
        return str;
    }

    /**
     * https://leetcode-cn.com/problems/jewels-and-stones/
     * 771. 宝石与石头
     */
    public static int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0, len = J.length(); i < len; i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0, len = S.length(); i < len; i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static int numJewelsInStones2(String J, String S) {
        // low负责存储`a-z`类型的宝石
        // high负责存储`A-Z`类型的宝石
        int low = 0, high = 0;
        char c;
        for (int i = 0, len = J.length(); i < len; i++) {
            c = J.charAt(i);
            // 将代表该类型的宝石的位，置为1
            if (c >= 'a') {
                low |= 1 << c - 'a';
            } else {
                high |= 1 << c - 'A';
            }
        }
        int count = 0;
        for (int i = 0, len = S.length(); i < len; i++) {
            c = S.charAt(i);
            // 判断c是否为宝石
            if (c >= 'a') {
                if (((1 << c - 'a') & low) != 0) {
                    count++;
                }
            } else {
                if (((1 << c - 'A') & high) != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numJewelsInStones3(String J, String S) {
        boolean[] gems = new boolean['z' - 'A' + 1];
        for (int i = 0, len = J.length(); i < len; i++) {
            gems[J.charAt(i) - 'A'] = true;
        }
        int count = 0;
        for (int i = 0, len = S.length(); i < len; i++) {
            if (gems[S.charAt(i) - 'A']) {
                count++;
            }
        }
        return count;
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     * 3. 无重复字符的最长子串
     */
    public static int lengthOfLongestSubstring(String s) {
        // 保存滑动窗口中的字符及其所在的下标
        Map<Character, Integer> map = new HashMap<>();
        // 维护一个滑动窗口[j,i]
        int i = 0, j = i, len = s.length(), result = 0;
        while (i < len) {
            Character c = s.charAt(i);
            Integer index = map.get(c);
            // 判断字符是否在滑动窗口内
            if (index != null && index >= j) {
                j = index + 1;
            }
            result = Math.max(result, i - j + 1);
            map.put(c, i);
            i++;
        }
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 保存字符及其所在的下标+1
        int[] index = new int[128];
        // 维护一个滑动窗口[j,i]
        int len = s.length(), result = 0;
        for (int i = 0, j = 0; i < len; i++) {
            // 取j与s.charAt(i)字符上一次出现的位置+1的较大值
            j = Math.max(index[s.charAt(i)], j);
            result = Math.max(result, i - j + 1);
            // 这里加1，就不用像上面那种做法那样判断是否在滑动窗口内再加1了，牛皮
            index[s.charAt(i)] = i + 1;
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/4sum-ii/
     * 454. 四数相加 II
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Integer sum, count;
        // 记录A与B的组合和，与其出现的次数的映射
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum = A[i] + B[j];
                count = map1.get(sum);
                map1.put(sum, count == null ? 1 : count + 1);
            }
        }
        // 记录C与D的组合和，与其出现的次数的映射
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                sum = C[i] + D[j];
                count = map2.get(sum);
                map2.put(sum, count == null ? 1 : count + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> e : map1.entrySet()) {
            // 在map2中查找和map1互为相反数的组合和
            sum = map2.get(-e.getKey());
            if (sum != null) {
                result += sum * e.getValue();
            }
        }
        return result;
    }
}
