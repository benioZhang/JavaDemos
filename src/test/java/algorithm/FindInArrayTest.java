package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class FindInArrayTest {
    @Test
    public void findNum() {
        int[][] a = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        Assert.assertTrue(FindInArray.findNum(a, 7));
        Assert.assertFalse(FindInArray.findNum(a, 5));
        Assert.assertTrue(FindInArray.findNum(a, 1));
        Assert.assertTrue(FindInArray.findNum(a, 15));
        Assert.assertFalse(FindInArray.findNum(a, 0));
        Assert.assertFalse(FindInArray.findNum(a, 16));
        Assert.assertFalse(FindInArray.findNum(null, 16));
    }
}