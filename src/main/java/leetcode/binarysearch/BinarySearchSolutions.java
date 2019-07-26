package leetcode.binarysearch;

public class BinarySearchSolutions {
    /**
     * https://leetcode-cn.com/problems/binary-search/
     * 704. 二分查找
     */
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
