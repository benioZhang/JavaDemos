package leetcode.binarysearch;

public class BinarySearchSolutions {
    /**
     * https://leetcode-cn.com/problems/binary-search/
     * 704. 二分查找
     */
    public static int search(int[] nums, int target) {
        // 搜索区间是 [left, right]
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            // 一般使用下面的做法防止算数溢出，而不是用(left + right) / 2;
            mid = left + (right - left) / 2;
            // 找到立即返回
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/sqrtx/
     * 69. x 的平方根
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        // x 的平方根的搜索区间：[1, x-1]
        int left = 1, right = x - 1;
        while (left <= right) {
            // left+right会溢出
            int mid = left + (right - left) / 2;
            // 比较x与mid*mid时，mid*mid会溢出，所以使用x/mid与mid比较
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid < sqrt) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 结束循环时，left>right，返回right
        return right;
    }

    public static int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        // x 的平方根的搜索区间：[1, x-1]
        int left = 1, right = x - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 比较x与mid*mid时，mid*mid会溢出，所以使用x/mid与mid比较
            if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 结束循环时，left>right，返回right
        return right;
    }
}
