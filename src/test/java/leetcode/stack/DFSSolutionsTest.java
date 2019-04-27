package leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

public class DFSSolutionsTest {
    @Test
    public void numIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        Assert.assertEquals(3, DFSSolutions.numIslands(grid));

        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Assert.assertEquals(1, DFSSolutions.numIslands(grid2));

        char[][] grid3 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(3, DFSSolutions.numIslands(grid3));
    }

    @Test
    public void getSum() {
        int[] nums = new int[]{1, 2, 3};
        Assert.assertEquals(6, DFSSolutions.getSum(nums, 0));
        Assert.assertEquals(4, DFSSolutions.getSum(nums, 1));
        Assert.assertEquals(2, DFSSolutions.getSum(nums, 2));
        Assert.assertEquals(0, DFSSolutions.getSum(nums, 3));
        Assert.assertEquals(0, DFSSolutions.getSum(nums, 4));
        Assert.assertEquals(-2, DFSSolutions.getSum(nums, 5));
        Assert.assertEquals(-4, DFSSolutions.getSum(nums, 6));
        Assert.assertEquals(-6, DFSSolutions.getSum(nums, 7));

        int sum = 6;
        Assert.assertEquals(6, DFSSolutions.getSum(nums, 0, sum));
        Assert.assertEquals(4, DFSSolutions.getSum(nums, 1, sum));
        Assert.assertEquals(2, DFSSolutions.getSum(nums, 2, sum));
        Assert.assertEquals(0, DFSSolutions.getSum(nums, 3, sum));
        Assert.assertEquals(0, DFSSolutions.getSum(nums, 4, sum));
        Assert.assertEquals(-2, DFSSolutions.getSum(nums, 5, sum));
        Assert.assertEquals(-4, DFSSolutions.getSum(nums, 6, sum));
        Assert.assertEquals(-6, DFSSolutions.getSum(nums, 7, sum));

        sum = 6;
        int sum2 = sum;
        sum2 = DFSSolutions.getSum(nums, 0, sum2, 0);
        Assert.assertEquals(6, sum2);
        sum2 = DFSSolutions.getSum(nums, 0, sum2, 1);
        Assert.assertEquals(4, sum2);
        sum2 = DFSSolutions.getSum(nums, 1, sum2, 2);
        Assert.assertEquals(2, sum2);
    }

    @Test
    public void findTargetSumWays() {
        int[] nums;
        nums = new int[]{1, 1, 1, 1, 1};
        Assert.assertEquals(5, DFSSolutions.findTargetSumWays(nums, 3));
        Assert.assertEquals(5, DFSSolutions.findTargetSumWays2(nums, 3));
        Assert.assertEquals(5, DFSSolutions.findTargetSumWays3(nums, 3));
        Assert.assertEquals(5, DFSSolutions.findTargetSumWays4(nums, 3));
        Assert.assertEquals(5, DFSSolutions.findTargetSumWays5(nums, 3));

        nums = new int[]{1, 2, 1};
        Assert.assertEquals(2, DFSSolutions.findTargetSumWays(nums, 0));
        Assert.assertEquals(2, DFSSolutions.findTargetSumWays2(nums, 0));
        Assert.assertEquals(2, DFSSolutions.findTargetSumWays3(nums, 0));
        Assert.assertEquals(2, DFSSolutions.findTargetSumWays4(nums, 0));
        Assert.assertEquals(2, DFSSolutions.findTargetSumWays5(nums, 0));

        nums = new int[]{1000};
        Assert.assertEquals(1, DFSSolutions.findTargetSumWays(nums, -1000));
        Assert.assertEquals(1, DFSSolutions.findTargetSumWays2(nums, -1000));
        Assert.assertEquals(1, DFSSolutions.findTargetSumWays3(nums, -1000));
        Assert.assertEquals(1, DFSSolutions.findTargetSumWays4(nums, -1000));
        Assert.assertEquals(1, DFSSolutions.findTargetSumWays5(nums, -1000));

        nums = new int[]{1, 0, 2, 3};
        Assert.assertEquals(4, DFSSolutions.findTargetSumWays(nums, 0));
        Assert.assertEquals(4, DFSSolutions.findTargetSumWays2(nums, 0));
        Assert.assertEquals(4, DFSSolutions.findTargetSumWays3(nums, 0));
        Assert.assertEquals(4, DFSSolutions.findTargetSumWays4(nums, 0));
        Assert.assertEquals(4, DFSSolutions.findTargetSumWays5(nums, 0));

        nums = new int[]{1, 2, 7, 9, 981};
        Assert.assertEquals(0, DFSSolutions.findTargetSumWays(nums, 1000000000));
        Assert.assertEquals(0, DFSSolutions.findTargetSumWays2(nums, 1000000000));
        Assert.assertEquals(0, DFSSolutions.findTargetSumWays3(nums, 1000000000));
        Assert.assertEquals(0, DFSSolutions.findTargetSumWays4(nums, 1000000000));
        Assert.assertEquals(0, DFSSolutions.findTargetSumWays5(nums, 1000000000));

        nums = new int[]{9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        Assert.assertEquals(40, DFSSolutions.findTargetSumWays(nums, 2));
        Assert.assertEquals(40, DFSSolutions.findTargetSumWays2(nums, 2));
        Assert.assertEquals(40, DFSSolutions.findTargetSumWays3(nums, 2));
        Assert.assertEquals(40, DFSSolutions.findTargetSumWays4(nums, 2));
        Assert.assertEquals(40, DFSSolutions.findTargetSumWays5(nums, 2));
    }
}