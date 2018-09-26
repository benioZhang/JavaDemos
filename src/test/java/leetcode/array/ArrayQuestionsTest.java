package leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        matrix = new int[][]{{1, 2, 3}};//1*3
        Assert.assertEquals(Arrays.asList(1, 2, 3), ArrayQuestions.spiralOrder(matrix));

        matrix = new int[][]{{1}, {2}, {3}};//3*1
        Assert.assertEquals(Arrays.asList(1, 2, 3), ArrayQuestions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2}, {3, 4}};//2*2
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3), ArrayQuestions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};//2*3
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 5, 4), ArrayQuestions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};// 3*3
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), ArrayQuestions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};// 3*4
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), ArrayQuestions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};// 4*4
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), ArrayQuestions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};// 4*5
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12), ArrayQuestions.spiralOrder(matrix));
    }

    @Test
    public void generate() {
        List<Integer> row1 = Arrays.asList(1);
        List<Integer> row2 = Arrays.asList(1, 1);
        List<Integer> row3 = Arrays.asList(1, 2, 1);
        List<Integer> row4 = Arrays.asList(1, 3, 3, 1);
        List<Integer> row5 = Arrays.asList(1, 4, 6, 4, 1);
        Assert.assertEquals(Arrays.asList(), ArrayQuestions.generate(0));
        Assert.assertEquals(Arrays.asList(row1), ArrayQuestions.generate(1));
        Assert.assertEquals(Arrays.asList(row1, row2), ArrayQuestions.generate(2));
        Assert.assertEquals(Arrays.asList(row1, row2, row3), ArrayQuestions.generate(3));
        Assert.assertEquals(Arrays.asList(row1, row2, row3, row4), ArrayQuestions.generate(4));
        Assert.assertEquals(Arrays.asList(row1, row2, row3, row4, row5), ArrayQuestions.generate(5));
    }

    @Test
    public void arrayPairSum() {
        Assert.assertEquals(4, ArrayQuestions.arrayPairSum(new int[]{1, 4, 3, 2}));
        Assert.assertEquals(12, ArrayQuestions.arrayPairSum(new int[]{8, 5, 2, 4, 7, 1}));
        Assert.assertEquals(4, ArrayQuestions.arrayPairSum2(new int[]{1, 4, 3, 2}));
        Assert.assertEquals(12, ArrayQuestions.arrayPairSum2(new int[]{8, 5, 2, 4, 7, 1}));
        Assert.assertEquals(5, ArrayQuestions.arrayPairSum2(new int[]{2, 2, 2, 2, 1, 4}));
        Assert.assertEquals(5, ArrayQuestions.arrayPairSum2(new int[]{2, 1, 2, 2, 1, 4}));
    }

    @Test
    public void twoSum() {
        Assert.assertArrayEquals(new int[]{1, 2}, ArrayQuestions.twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 4}, ArrayQuestions.twoSum(new int[]{1, 2, 3, 4}, 5));

        Assert.assertArrayEquals(new int[]{1, 2}, ArrayQuestions.twoSum2(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 4}, ArrayQuestions.twoSum2(new int[]{1, 2, 3, 4}, 5));
    }

    @Test
    public void removeElement() {
        int[] nums, nums2;
        int len;

        nums = new int[]{3, 2, 2, 3};
        len = ArrayQuestions.removeElement(nums, 3);
        nums2 = new int[len];
        System.arraycopy(nums, 0, nums2, 0, len);
        Assert.assertArrayEquals(new int[]{2, 2}, nums2);
        Assert.assertEquals(2, len);

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        len = ArrayQuestions.removeElement(nums, 2);
        nums2 = new int[len];
        System.arraycopy(nums, 0, nums2, 0, len);
        Assert.assertArrayEquals(new int[]{0, 1, 3, 0, 4}, nums2);
        Assert.assertEquals(5, len);
    }

    @Test
    public void findMaxConsecutiveOnes() {
        Assert.assertEquals(1, ArrayQuestions.findMaxConsecutiveOnes(new int[]{1}));
        Assert.assertEquals(0, ArrayQuestions.findMaxConsecutiveOnes(new int[]{0}));
        Assert.assertEquals(0, ArrayQuestions.findMaxConsecutiveOnes(new int[]{0, 0}));
        Assert.assertEquals(2, ArrayQuestions.findMaxConsecutiveOnes(new int[]{1, 1}));
        Assert.assertEquals(3, ArrayQuestions.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    @Test
    public void minSubArrayLen() {
        Assert.assertEquals(0, ArrayQuestions.minSubArrayLen(100, new int[]{1, 2, 3}));
        Assert.assertEquals(1, ArrayQuestions.minSubArrayLen(7, new int[]{2, 3, 1, 2, 7, 3}));
        Assert.assertEquals(2, ArrayQuestions.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(3, ArrayQuestions.minSubArrayLen(9, new int[]{2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(4, ArrayQuestions.minSubArrayLen(10, new int[]{2, 3, 1, 2, 4, 3}));

        Assert.assertEquals(0, ArrayQuestions.minSubArrayLen2(100, new int[]{1, 2, 3}));
        Assert.assertEquals(1, ArrayQuestions.minSubArrayLen2(7, new int[]{2, 3, 1, 2, 7, 3}));
        Assert.assertEquals(2, ArrayQuestions.minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(3, ArrayQuestions.minSubArrayLen2(9, new int[]{2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(4, ArrayQuestions.minSubArrayLen2(10, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    public void rotate() {
        int[] nums;
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayQuestions.rotate(nums, 3);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayQuestions.rotate(nums, 4);
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, nums);
    }

    @Test
    public void getRow() {
        Assert.assertEquals(Arrays.asList(1), ArrayQuestions.getRow(0));
        Assert.assertEquals(Arrays.asList(1, 1), ArrayQuestions.getRow(1));
        Assert.assertEquals(Arrays.asList(1, 2, 1), ArrayQuestions.getRow(2));
        Assert.assertEquals(Arrays.asList(1, 3, 3, 1), ArrayQuestions.getRow(3));
        Assert.assertEquals(Arrays.asList(1, 4, 6, 4, 1), ArrayQuestions.getRow(4));
    }
}