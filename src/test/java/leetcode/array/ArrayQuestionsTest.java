package leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

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

    @Test
    public void findDiagonalOrder() {
        int[][] matrix;
        matrix = null;
        Assert.assertNull(ArrayQuestions.findDiagonalOrder(matrix));

        matrix = new int[][]{};
        Assert.assertArrayEquals(new int[0], ArrayQuestions.findDiagonalOrder(matrix));

        matrix = new int[][]{{1, 2, 3}};//1*3
        Assert.assertArrayEquals(new int[]{1, 2, 3}, ArrayQuestions.findDiagonalOrder(matrix));

        matrix = new int[][]{{1}, {2}, {3}};//3*1
        Assert.assertArrayEquals(new int[]{1, 2, 3}, ArrayQuestions.findDiagonalOrder(matrix));

        matrix = new int[][]{{1, 2}, {3, 4}};//2*2
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, ArrayQuestions.findDiagonalOrder(matrix));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};//2*3
        Assert.assertArrayEquals(new int[]{1, 2, 4, 5, 3, 6}, ArrayQuestions.findDiagonalOrder(matrix));

        matrix = new int[][]{{1, 2}, {3, 4}, {5, 6}};//3*2
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5, 4, 6}, ArrayQuestions.findDiagonalOrder(matrix));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};// 3*3
        Assert.assertArrayEquals(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}, ArrayQuestions.findDiagonalOrder(matrix));
    }

    @Test
    public void spiralOrder() {
        int[][] matrix;
        matrix = null;
        Assert.assertNull(ArrayQuestions.spiralOrder(matrix));

        matrix = new int[][]{};
        Assert.assertEquals(Collections.emptyList(), ArrayQuestions.spiralOrder(matrix));

//        matrix = new int[][]{{1, 2, 3}};//1*3
//        Assert.assertEquals(Arrays.asList(1, 2, 3), ArrayQuestions.spiralOrder(matrix));
//
//        matrix = new int[][]{{1}, {2}, {3}};//3*1
//        Assert.assertEquals(Arrays.asList(1, 2, 3), ArrayQuestions.spiralOrder(matrix));

        //matrix = new int[][]{{1, 2}, {3, 4}};//2*2
        //Assert.assertEquals(Arrays.asList(1, 2, 4, 3), ArrayQuestions.spiralOrder(matrix));

        //matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};//2*3
        //Assert.assertEquals(Arrays.asList(1, 2, 4, 3), ArrayQuestions.spiralOrder(matrix));

//        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};// 3*3
//        Assert.assertEquals(Arrays.asList(1, 2, 4, 3), ArrayQuestions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};// 3*3
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3), ArrayQuestions.spiralOrder(matrix));
    }
}