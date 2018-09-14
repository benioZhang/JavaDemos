package leetcode.array;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> result = new ArrayList<>(row * col);
        int i = 0, j = 0, k = 0;// k为当前圈数
        int n = 0;
        while (n < row * col) {
            // 从左上到右上
            while (j < col - k) {
                System.out.print(matrix[i][j] + ",");
                j++;
                n++;
            }
            j = col - k - 1;
            i++;
            System.out.println("\ni,j=" + i + "," + j);

            // 从右上到右下
            while (i < row - k) {
                System.out.print(matrix[i][j] + ",");
                i++;
                n++;
            }
            i = row - k - 1;

            System.out.println("\ni,j=" + i + "," + j);

            // 从右下到左下
            j--;
            while (j >= k) {
                System.out.print(matrix[i][j] + ",");
                j--;
                n++;
            }
            j++;

            System.out.println("\ni,j=" + i + "," + j);

            // 从左下到左上
            i--;
            while (i >= k + 1) {
                System.out.print(matrix[i][j] + ",");
                i--;
                n++;
            }
            i++;
            j++;
            System.out.println("\ni,j=" + i + "," + j);
            k++;
        }
        return result;
    }
}
