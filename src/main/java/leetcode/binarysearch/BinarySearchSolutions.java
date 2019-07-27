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
}
