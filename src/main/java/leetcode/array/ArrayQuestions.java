package leetcode.array;

import java.util.*;

public class ArrayQuestions {

    /**
     * https://leetcode-cn.com/problems/find-pivot-index/description/
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     * <p>
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * <p>
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * nums = [1, 7, 3, 6, 5, 6]
     * 输出: 3
     * 解释:
     * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
     * 同时, 3 也是第一个符合要求的中心索引。
     * 示例 2:
     * <p>
     * 输入:
     * nums = [1, 2, 3]
     * 输出: -1
     * 解释:
     * 数组中不存在满足此条件的中心索引。
     * 说明:
     * <p>
     * nums 的长度范围为 [0, 10000]。
     * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
     * A:
     * 1.从左累加num得出left数组
     * 2.从右累加num得出right数组
     * 3.同时遍历left和right，出现值相等的位置即为中心索引
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        final int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        // 从左开始累加
        left[0] = nums[0];
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] + nums[i];
        }
        // 从右开始累加
        right[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
        }

        for (int i = 0; i < length; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/description/
     * Q:至少是其他数字两倍的最大数
     * 在一个给定的数组nums中，总是存在一个最大元素 。
     * <p>
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     * <p>
     * 如果是，则返回最大元素的索引，否则返回-1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [3, 6, 1, 0]
     * 输出: 1
     * 解释: 6是最大的整数, 对于数组中的其他整数,
     * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入: nums = [1, 2, 3, 4]
     * 输出: -1
     * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
     * <p>
     * <p>
     * 提示:
     * <p>
     * nums 的长度范围在[1, 50].
     * 每个 nums[i] 的整数范围在 [0, 99].
     *
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            // 只有一个元素，则该元素最大
            return 0;
        }
        int max = 0, second = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[max] < nums[i]) {
                second = max;
                max = i;
            } else if (nums[second] < nums[i]) {
                second = i;
            }
        }
        if (nums[max] >= nums[second] << 1) {
            return max;
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/plus-one/description/
     * Q:给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        int value, carry = 1;// 给最低位进位作+1用途
        for (int i = digits.length - 1; i >= 0; i--) {
            value = digits[i] + carry;
            if (value >= 10) {
                digits[i] = value - 10;
                carry = 1;
            } else {
                digits[i] = value;
                carry = 0;
            }
        }
        if (carry > 0) {
            //仍有进位
            int[] tmp = new int[digits.length + 1];
            tmp[0] = 1;
            System.arraycopy(digits, 0, tmp, 1, digits.length);
            digits = tmp;
        }
        return digits;
    }

    /**
     * https://leetcode-cn.com/problems/diagonal-traverse/description/
     * Q:给定一个含有 M x N 个元素的矩阵（M行，N列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出:  [1,2,4,7,5,3,6,8,9]
     *
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        if (matrix.length == 0) {
            return new int[0];
        }
        final int row = matrix.length, col = matrix[0].length;
        int[] result = new int[row * col];
        int k = 0;// 记录result当前下标
        //横纵坐标用(x,y)表示
        //观察得x的最小值为x = max(0, i - col + 1), x的最大值为x = min(i, row-1)，且y = i - x
        int xMax, xMin;// 当前层数的x的最大与最小下标
        for (int i = 0; i < row + col - 1; i++) { // 共row + col - 1层
            xMax = Math.min(i, row - 1);
            xMin = Math.max(0, i - col + 1);
            if (i % 2 == 0) {
                // 偶数层往上遍历，x逐渐变小
                for (int j = xMax; j >= xMin; j--) {
                    result[k++] = matrix[j][i - j];
                }
            } else {
                // 奇数层往下遍历, x逐渐变大
                for (int j = xMin; j <= xMax; j++) {
                    result[k++] = matrix[j][i - j];
                }
            }
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/spiral-matrix/description/
     * Q:螺旋矩阵
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * A:定义下标(i,j)，当前旋转圈数k
     * 1.从左上到右上，(i,j)从(k,k)到(k,col - k - 1)
     * 2.从右上到右下, (i,j)从(k+1,col - k - 1)到(row - k - 1,col - k - 1)
     * 3.从右下到左下，(i,j)从(row - k - 1,col - k - 1 - 1)到(row - k - 1,k)
     * 4.从左下到左上，(i,j)从(row - k - 1 - 1,k)到(k + 1,k)
     * 5.边界不符合条件则退出遍历
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        if (matrix.length == 0) {
            return new ArrayList<>(0);
        }
        final int row = matrix.length, col = matrix[0].length;
        final int count = row * col;
        List<Integer> result = new ArrayList<>(count);
        int i = 0, j = 0;// 下标(i,j)
        int k = 0;// 当前圈数
        while (result.size() < count) {
            // 从左上到右上
            i = j = k;
            while (j < col - k) {
                result.add(matrix[i][j]);
                j++;
            }
            if (j == k) {
                break;
            }
            // 从右上到右下
            j = col - k - 1;
            i = k + 1;
            while (i < row - k) {
                result.add(matrix[i][j]);
                i++;
            }
            if (i == k + 1) {
                break;
            }
            // 从右下到左下
            i = row - k - 1;
            j = col - k - 1 - 1;
            while (j >= k) {
                result.add(matrix[i][j]);
                j--;
            }
            if (j == col - k - 1 - 1) {
                break;
            }
            // 从左下到左上
            j = k;
            i = row - k - 1 - 1;
            while (i >= k + 1) {
                result.add(matrix[i][j]);
                i--;
            }
            if (i == row - k - 1 - 1) {
                break;
            }
            k++;
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/pascals-triangle/description/
     * Q:杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例:
     * <p>
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> row, lastRow;
        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    lastRow = result.get(i - 1);
                    row.add(lastRow.get(j) + lastRow.get(j - 1));
                }
            }
            result.add(row);
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/array-partition-i/description/
     * Q:数组拆分 I
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,4,3,2]
     * <p>
     * 输出: 4
     * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
     * 提示:
     * <p>
     * n 是正整数,范围在 [1, 10000].
     * 数组中的元素范围在 [-10000, 10000].
     * A：
     * 1.排序
     * 2.每两个数，取最小相加求和
     *
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 桶排序
        int[] arr = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] + 10000]++;
        }
        boolean flag = true;// 每隔一个数便加一次
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                if (flag) {
                    sum += i - 10000;
                }
                flag = !flag;
                arr[i]--;
            }
        }
        return sum;
    }

    /**
     * 虽然此方法减少了遍历的次数，但是乘法运算比加法运算慢，所以耗时比上一种方法长
     *
     * @param nums
     * @return
     */
    public static int arrayPairSum2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 桶排序
        int[] arr = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] + 10000]++;
        }
        boolean flag = true;// 每隔一个数便加一次
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                // 假设n=arr[i]，j为arr中下一个不为0的下标，则(i,i,i,i...j,j)
                if (flag) {
                    // 若n为奇数，则下一次不会与第一个j相加 (i,i),(i,j)
                    // 若n为偶数，则下一次必定与第一个j相加 (i,i),(i,i),(j,j)
                    // 观察易得n个i的求arrayPairSum为 (arr[i] + 1) / 2 * i
                    flag = arr[i] % 2 == 0;
                    sum += ((arr[i] + 1) >> 1) * (i - 10000);
                } else {
                    flag = arr[i] % 2 != 0;
                    sum += (arr[i] >> 1) * (i - 10000);
                }
            }
        }
        return sum;
    }

    /**
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
     * Q:两数之和 II - 输入有序数组
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * <p>
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * <p>
     * 说明:
     * <p>
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     * <p>
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            map.put(target - numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                // 下标值（index1 和 index2）不是从零开始的
                int[] result = new int[2];
                result[0] = i + 1;
                result[1] = map.get(numbers[i]) + 1;
                return result;
            }
        }
        return null;
    }

    /**
     * 因为数组是升序的，所以可以用两个指针直接扫描
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int val = numbers[i] + numbers[j];
            if (val == target) {
                break;
            } else if (val < target) {
                i++;
            } else {
                j--;
            }
        }
        result[0] = i + 1;
        result[1] = j + 1;
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/remove-element/description/
     * Q:移除元素
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [3,2,2,3], val = 3,
     * <p>
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     * A:
     * 使用两个指针：一个用于迭代，第二个指针总是指向下一次添加的位置。
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != j) {
                    nums[j] = nums[i];
                }
                j++;
            }
        }
        return j;
    }

    /**
     * https://leetcode-cn.com/problems/max-consecutive-ones/description/
     * Q: 最大连续1的个数
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * 注意：
     * <p>
     * 输入的数组只包含 0 和1。
     * 输入数组的长度是正整数，且不超过 10,000。
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                n++;
            } else {
                // 已完成前面n个1的遍历，n为连续1的个数
                if (max < n) {
                    max = n;
                }
                // 重置n
                n = 0;
            }
        }

        // 这里的判断是为了防止nums最后一个元素为1
        // 导致max没和最后最后一个n对比
        if (max < n) {
            max = n;
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/problems/minimum-size-subarray-sum/description/
     * Q:长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     * <p>
     * 示例:
     * <p>
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     * 进阶:
     * <p>
     * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        // O(n^2)复杂度，暴力破解，第一时间想到的算法
        // 1.子数组长度i:1<=i<=nums.length
        // 2.子数组求和，可利用上一个长度的子数组和求当前长度的和
        // 3.将所求和与s对比，若符合条件，则i为所求长度
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {// 当前子数组长度
            for (int j = 0; j < nums.length - i; j++) {// 遍历数组求子数组和
                sums[j] = sums[j] + nums[j + i];
                if (sums[j] >= s) {
                    return i + 1;
                }
            }
        }
        return 0;
    }

    public static int minSubArrayLen2(int s, int[] nums) {
        int l = 0, r = 0;// 左右窗口边界，nums[l ... r] 为我们的滑动窗口
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (l < nums.length) {
            if (r < nums.length && sum < s) {
                sum += nums[r++];//扩大窗口
            } else {
                sum -= nums[l++];//缩小窗口
            }
            if (sum >= s) {
                len = Math.min(len, r - l);//注意此时r或l已+1
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    /**
     * https://leetcode-cn.com/problems/rotate-array/description/
     * Q:旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 说明:
     * <p>
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的原地算法。
     * A:三步翻转法
     * 1.将数组从k位置分为前后两半；
     * 2.翻转前半部分；
     * 3.翻转后半部分；
     * 4.翻转整个数组；
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        final int length = nums.length;
        k = k % length;
        if (k == 0) {
            return;
        }

        // 翻转前半部分
        for (int i = 0; i < (length - k) >> 1; i++) {
            swap(nums, i, length - k - 1 - i);
        }
        // 翻转后半部分
        for (int i = 0; i < k >> 1; i++) {
            swap(nums, length - k + i, length - 1 - i);
        }
        // 翻转整个数组
        for (int i = 0; i < length >> 1; i++) {
            swap(nums, i, length - 1 - i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
     * Q:杨辉三角 II
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * <p>
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例:
     * <p>
     * 输入: 3
     * 输出: [1,3,3,1]
     * 进阶：
     * <p>
     * 你可以优化你的算法到 O(k) 空间复杂度吗？
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {// 这里需要从后边开始遍历，否则会覆盖前面的值
                if (j == 0 || j == i) {
                    if (j >= result.size()) {
                        result.add(j, 1);
                    }
                } else {
                    result.set(j, result.get(j - 1) + result.get(j));
                }
            }
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
     * Q: 删除排序数组中的重复项
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i, j = 1, val = nums[0];
        for (i = 1; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
                val = nums[i];
            }
        }
        return j;
    }

    /**
     * https://leetcode-cn.com/problems/move-zeroes/description/
     * Q:移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        if (index == 0) {
            // 所有元素均为0
            return;
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
