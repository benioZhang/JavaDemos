package leetcode.hash;

import org.junit.Assert;
import org.junit.Test;

public class HashSolutionsTest {
    @Test
    public void containsDuplicate() throws Exception {
        int[] nums;
        nums = new int[]{1, 2, 3, 1};
        Assert.assertTrue(HashSolutions.containsDuplicate(nums));
        Assert.assertTrue(HashSolutions.containsDuplicate2(nums));

        nums = new int[]{1, 2, 3, 4};
        Assert.assertFalse(HashSolutions.containsDuplicate(nums));
        Assert.assertFalse(HashSolutions.containsDuplicate2(nums));

        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        Assert.assertTrue(HashSolutions.containsDuplicate(nums));
        Assert.assertTrue(HashSolutions.containsDuplicate2(nums));
    }

}