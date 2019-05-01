package leetcode.queue;

import org.junit.Assert;
import org.junit.Test;

public class BFSSolutionsTest {
    @Test
    public void numIslands() throws Exception {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        Assert.assertEquals(3, BFSSolutions.numIslands(grid));

        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Assert.assertEquals(1, BFSSolutions.numIslands(grid2));

        char[][] grid3 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(3, BFSSolutions.numIslands(grid3));

        char[][] grid4 = {
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}
        };
        Assert.assertEquals(1, BFSSolutions.numIslands(grid4));
    }

    @Test
    public void openLock() {
        String[] deadends;
        deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        Assert.assertEquals(6, BFSSolutions.openLock(deadends, "0202"));

        deadends = new String[]{"8888"};
        Assert.assertEquals(1, BFSSolutions.openLock(deadends, "0009"));

        deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        Assert.assertEquals(-1, BFSSolutions.openLock(deadends, "8888"));

        deadends = new String[]{"0000"};
        Assert.assertEquals(-1, BFSSolutions.openLock(deadends, "8888"));
    }

    @Test
    public void numSquares() {
        Assert.assertEquals(1, BFSSolutions.numSquares(4));
        Assert.assertEquals(3, BFSSolutions.numSquares(12));
        Assert.assertEquals(2, BFSSolutions.numSquares(13));

        Assert.assertEquals(1, BFSSolutions.numSquares2(4));
        Assert.assertEquals(3, BFSSolutions.numSquares2(12));
        Assert.assertEquals(2, BFSSolutions.numSquares2(13));

        Assert.assertEquals(1, BFSSolutions.numSquares3(4));
        Assert.assertEquals(3, BFSSolutions.numSquares3(12));
        Assert.assertEquals(2, BFSSolutions.numSquares3(13));
    }

    @Test
    public void updateMatrix() {
        int[][] matrix, result;
        matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        result = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        Assert.assertArrayEquals(result, BFSSolutions.updateMatrix(matrix));
        Assert.assertArrayEquals(result, BFSSolutions.updateMatrix2(matrix));

        matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        result = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}
        };
        Assert.assertArrayEquals(result, BFSSolutions.updateMatrix(matrix));
        Assert.assertArrayEquals(result, BFSSolutions.updateMatrix2(matrix));

        matrix = new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        result = new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        Assert.assertArrayEquals(result, BFSSolutions.updateMatrix(matrix));
        Assert.assertArrayEquals(result, BFSSolutions.updateMatrix2(matrix));

        matrix = new int[][]{
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1}
        };

        result = new int[][]{
                {0, 1, 0, 1, 2},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1}
        };
        Assert.assertArrayEquals(result, BFSSolutions.updateMatrix(matrix));
        Assert.assertArrayEquals(result, BFSSolutions.updateMatrix2(matrix));
    }
}