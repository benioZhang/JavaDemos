package leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchSolutionsTest {

    @Test
    public void search() {
        Assert.assertEquals(4, BinarySearchSolutions.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        Assert.assertEquals(-1, BinarySearchSolutions.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}