package leetcode.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayQuestionsTest {

    @Test
    public void pivotIndex() {
        int[] nums = null;
        Assert.assertEquals(-1, ArrayQuestions.pivotIndex(nums));

        nums = new int[]{1, 1, 1};
        Assert.assertEquals(1, ArrayQuestions.pivotIndex(nums));

        nums = new int[]{1, 2, 3};
        Assert.assertEquals(-1, ArrayQuestions.pivotIndex(nums));

        nums = new int[]{1, 7, 3, 6, 5, 6};
        Assert.assertEquals(3, ArrayQuestions.pivotIndex(nums));
    }

    @Test
    public void dominantIndex() {
        int[] nums;
        nums = new int[]{1};
        Assert.assertEquals(0, ArrayQuestions.dominantIndex(nums));

        nums = new int[]{1, 0};
        Assert.assertEquals(0, ArrayQuestions.dominantIndex(nums));

        nums = new int[]{3, 6, 1, 0};
        Assert.assertEquals(1, ArrayQuestions.dominantIndex(nums));

        nums = new int[]{1, 2, 3, 4};
        Assert.assertEquals(-1, ArrayQuestions.dominantIndex(nums));

        nums = new int[]{0, 0, 3, 2};
        Assert.assertEquals(-1, ArrayQuestions.dominantIndex(nums));
    }

    @Test
    public void plusOne() throws Exception {
        int[] digits;
        digits = new int[]{9, 9, 9};
        digits = ArrayQuestions.plusOne(digits);
        Assert.assertArrayEquals(new int[]{1, 0, 0, 0}, digits);

        digits = new int[]{1, 2, 3};
        digits = ArrayQuestions.plusOne(digits);
        Assert.assertArrayEquals(new int[]{1, 2, 4}, digits);
    }
}