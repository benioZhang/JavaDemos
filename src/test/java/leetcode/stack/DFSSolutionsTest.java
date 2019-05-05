package leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void cloneGraph() {
        Node node1, node2, node3, node4;
        node1 = new Node();
        node1.val = 1;
        node2 = new Node();
        node2.val = 2;
        node3 = new Node();
        node3.val = 3;
        node4 = new Node();
        node4.val = 4;

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        Node _node1, _node2, _node3, _node4;
        _node1 = DFSSolutions.cloneGraph(node1);
        _node2 = _node1.neighbors.get(0);
        _node3 = _node2.neighbors.get(1);
        _node4 = _node1.neighbors.get(1);

        deepEquals(node1, _node1);
        deepEquals(node2, _node2);
        deepEquals(node3, _node3);
        deepEquals(node4, _node4);

        _node1 = DFSSolutions.cloneGraph2(node1);
        _node2 = _node1.neighbors.get(0);
        _node3 = _node2.neighbors.get(1);
        _node4 = _node1.neighbors.get(1);

        deepEquals(node1, _node1);
        deepEquals(node2, _node2);
        deepEquals(node3, _node3);
        deepEquals(node4, _node4);
    }

    private static void deepEquals(Node a, Node b) {
        // 比较节点
        Assert.assertNotEquals(a, b);
        Assert.assertEquals(a.val, b.val);

        // 比较邻节点
        Assert.assertNotNull(b.neighbors);
        Assert.assertEquals(a.neighbors.size(), b.neighbors.size());
        for (int i = 0; i < a.neighbors.size(); i++) {
            Assert.assertNotEquals(a.neighbors.get(i), b.neighbors.get(i));
            Assert.assertEquals(a.neighbors.get(i).val, b.neighbors.get(i).val);
        }
    }

    @Test
    public void floodFill() {
        int[][] image, result;
        image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},
        };
        result = new int[][]{
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1},
        };
        Assert.assertArrayEquals(result, DFSSolutions.floodFill(image, 1, 1, 2));

        image = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
        };
        result = new int[][]{
                {2, 2, 2},
                {2, 2, 2},
        };
        Assert.assertArrayEquals(result, DFSSolutions.floodFill(image, 0, 0, 2));

        image = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
        };
        result = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
        };
        Assert.assertArrayEquals(result, DFSSolutions.floodFill(image, 1, 1, 1));
    }

    @Test
    public void floodFill2() {
        int[][] image, result;
        image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},
        };
        result = new int[][]{
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1},
        };
        Assert.assertArrayEquals(result, DFSSolutions.floodFill2(image, 1, 1, 2));

        image = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
        };
        result = new int[][]{
                {2, 2, 2},
                {2, 2, 2},
        };
        Assert.assertArrayEquals(result, DFSSolutions.floodFill2(image, 0, 0, 2));

        image = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
        };
        result = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
        };
        Assert.assertArrayEquals(result, DFSSolutions.floodFill2(image, 1, 1, 1));
    }
}