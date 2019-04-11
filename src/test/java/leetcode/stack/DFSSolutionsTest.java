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
}