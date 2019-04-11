package leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySolutionsTest {

    @Test
    public void pivotIndex() {
        int[] nums = null;
        Assert.assertEquals(-1, ArraySolutions.pivotIndex(nums));

        nums = new int[]{1, 1, 1};
        Assert.assertEquals(1, ArraySolutions.pivotIndex(nums));
        Assert.assertEquals(1, ArraySolutions.pivotIndex2(nums));

        nums = new int[]{1, 2, 3};
        Assert.assertEquals(-1, ArraySolutions.pivotIndex(nums));
        Assert.assertEquals(-1, ArraySolutions.pivotIndex2(nums));

        nums = new int[]{1, 7, 3, 6, 5, 6};
        Assert.assertEquals(3, ArraySolutions.pivotIndex(nums));
        Assert.assertEquals(3, ArraySolutions.pivotIndex2(nums));
    }

    @Test
    public void dominantIndex() {
        int[] nums;
        nums = new int[]{1};
        Assert.assertEquals(0, ArraySolutions.dominantIndex(nums));
        Assert.assertEquals(0, ArraySolutions.dominantIndex2(nums));

        nums = new int[]{1, 0};
        Assert.assertEquals(0, ArraySolutions.dominantIndex(nums));
        Assert.assertEquals(0, ArraySolutions.dominantIndex2(nums));

        nums = new int[]{3, 6, 1, 0};
        Assert.assertEquals(1, ArraySolutions.dominantIndex(nums));
        Assert.assertEquals(1, ArraySolutions.dominantIndex2(nums));

        nums = new int[]{1, 2, 3, 4};
        Assert.assertEquals(-1, ArraySolutions.dominantIndex(nums));
        Assert.assertEquals(-1, ArraySolutions.dominantIndex2(nums));

        nums = new int[]{0, 0, 3, 2};
        Assert.assertEquals(-1, ArraySolutions.dominantIndex(nums));
        Assert.assertEquals(-1, ArraySolutions.dominantIndex2(nums));
    }

    @Test
    public void plusOne() throws Exception {
        int[] digits;
        digits = new int[]{9, 9, 9};
        digits = ArraySolutions.plusOne(digits);
        Assert.assertArrayEquals(new int[]{1, 0, 0, 0}, digits);

        digits = new int[]{1, 2, 3};
        digits = ArraySolutions.plusOne(digits);
        Assert.assertArrayEquals(new int[]{1, 2, 4}, digits);
    }

    @Test
    public void plusOne2() throws Exception {
        int[] digits;
        digits = new int[]{9, 9, 9};
        digits = ArraySolutions.plusOne2(digits);
        Assert.assertArrayEquals(new int[]{1, 0, 0, 0}, digits);

        digits = new int[]{1, 2, 3};
        digits = ArraySolutions.plusOne2(digits);
        Assert.assertArrayEquals(new int[]{1, 2, 4}, digits);
    }

    @Test
    public void findDiagonalOrder() {
        int[][] matrix;
        matrix = null;
        Assert.assertNull(ArraySolutions.findDiagonalOrder(matrix));

        matrix = new int[][]{};
        Assert.assertArrayEquals(new int[0], ArraySolutions.findDiagonalOrder(matrix));
        Assert.assertArrayEquals(new int[0], ArraySolutions.findDiagonalOrder2(matrix));

        matrix = new int[][]{{1, 2, 3}};//1*3
        Assert.assertArrayEquals(new int[]{1, 2, 3}, ArraySolutions.findDiagonalOrder(matrix));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, ArraySolutions.findDiagonalOrder2(matrix));

        matrix = new int[][]{{1}, {2}, {3}};//3*1
        Assert.assertArrayEquals(new int[]{1, 2, 3}, ArraySolutions.findDiagonalOrder(matrix));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, ArraySolutions.findDiagonalOrder2(matrix));

        matrix = new int[][]{{1, 2}, {3, 4}};//2*2
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, ArraySolutions.findDiagonalOrder(matrix));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, ArraySolutions.findDiagonalOrder2(matrix));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};//2*3
        Assert.assertArrayEquals(new int[]{1, 2, 4, 5, 3, 6}, ArraySolutions.findDiagonalOrder(matrix));

        matrix = new int[][]{{1, 2}, {3, 4}, {5, 6}};//3*2
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5, 4, 6}, ArraySolutions.findDiagonalOrder(matrix));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5, 4, 6}, ArraySolutions.findDiagonalOrder2(matrix));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};// 3*3
        Assert.assertArrayEquals(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}, ArraySolutions.findDiagonalOrder(matrix));
        Assert.assertArrayEquals(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}, ArraySolutions.findDiagonalOrder2(matrix));
    }

    @Test
    public void spiralOrder() {
        int[][] matrix;
        matrix = null;
        Assert.assertNull(ArraySolutions.spiralOrder(matrix));

        matrix = new int[][]{};
        Assert.assertEquals(Collections.emptyList(), ArraySolutions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3}};//1*3
        Assert.assertEquals(Arrays.asList(1, 2, 3), ArraySolutions.spiralOrder(matrix));

        matrix = new int[][]{{1}, {2}, {3}};//3*1
        Assert.assertEquals(Arrays.asList(1, 2, 3), ArraySolutions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2}, {3, 4}};//2*2
        Assert.assertEquals(Arrays.asList(1, 2, 4, 3), ArraySolutions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};//2*3
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 5, 4), ArraySolutions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};// 3*3
        Assert.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), ArraySolutions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};// 3*4
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), ArraySolutions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};// 4*4
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), ArraySolutions.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};// 4*5
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12), ArraySolutions.spiralOrder(matrix));
    }

    @Test
    public void generate() {
        List<Integer> row1 = Arrays.asList(1);
        List<Integer> row2 = Arrays.asList(1, 1);
        List<Integer> row3 = Arrays.asList(1, 2, 1);
        List<Integer> row4 = Arrays.asList(1, 3, 3, 1);
        List<Integer> row5 = Arrays.asList(1, 4, 6, 4, 1);
        Assert.assertEquals(Arrays.asList(), ArraySolutions.generate(0));
        Assert.assertEquals(Arrays.asList(row1), ArraySolutions.generate(1));
        Assert.assertEquals(Arrays.asList(row1, row2), ArraySolutions.generate(2));
        Assert.assertEquals(Arrays.asList(row1, row2, row3), ArraySolutions.generate(3));
        Assert.assertEquals(Arrays.asList(row1, row2, row3, row4), ArraySolutions.generate(4));
        Assert.assertEquals(Arrays.asList(row1, row2, row3, row4, row5), ArraySolutions.generate(5));
    }

    @Test
    public void arrayPairSum() {
        Assert.assertEquals(4, ArraySolutions.arrayPairSum(new int[]{1, 4, 3, 2}));
        Assert.assertEquals(12, ArraySolutions.arrayPairSum(new int[]{8, 5, 2, 4, 7, 1}));
        Assert.assertEquals(4, ArraySolutions.arrayPairSum2(new int[]{1, 4, 3, 2}));
        Assert.assertEquals(12, ArraySolutions.arrayPairSum2(new int[]{8, 5, 2, 4, 7, 1}));
        Assert.assertEquals(5, ArraySolutions.arrayPairSum2(new int[]{2, 2, 2, 2, 1, 4}));
        Assert.assertEquals(5, ArraySolutions.arrayPairSum2(new int[]{2, 1, 2, 2, 1, 4}));
    }

    @Test
    public void twoSum() {
        Assert.assertArrayEquals(new int[]{1, 2}, ArraySolutions.twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 4}, ArraySolutions.twoSum(new int[]{1, 2, 3, 4}, 5));

        Assert.assertArrayEquals(new int[]{1, 2}, ArraySolutions.twoSum2(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 4}, ArraySolutions.twoSum2(new int[]{1, 2, 3, 4}, 5));
    }

    @Test
    public void removeElement() {
        int[] nums, nums2;
        int len;

        nums = new int[]{3, 3, 3};
        len = ArraySolutions.removeElement(nums, 3);
        nums2 = new int[len];
        System.arraycopy(nums, 0, nums2, 0, len);
        Assert.assertArrayEquals(new int[]{}, nums2);
        Assert.assertEquals(0, len);

        nums = new int[]{3, 2, 2, 3};
        len = ArraySolutions.removeElement(nums, 3);
        nums2 = new int[len];
        System.arraycopy(nums, 0, nums2, 0, len);
        Assert.assertArrayEquals(new int[]{2, 2}, nums2);
        Assert.assertEquals(2, len);

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        len = ArraySolutions.removeElement(nums, 2);
        nums2 = new int[len];
        System.arraycopy(nums, 0, nums2, 0, len);
        Assert.assertArrayEquals(new int[]{0, 1, 3, 0, 4}, nums2);
        Assert.assertEquals(5, len);
    }

    @Test
    public void findMaxConsecutiveOnes() {
        Assert.assertEquals(1, ArraySolutions.findMaxConsecutiveOnes(new int[]{1}));
        Assert.assertEquals(0, ArraySolutions.findMaxConsecutiveOnes(new int[]{0}));
        Assert.assertEquals(0, ArraySolutions.findMaxConsecutiveOnes(new int[]{0, 0}));
        Assert.assertEquals(2, ArraySolutions.findMaxConsecutiveOnes(new int[]{1, 1}));
        Assert.assertEquals(3, ArraySolutions.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    @Test
    public void minSubArrayLen() {
        Assert.assertEquals(0, ArraySolutions.minSubArrayLen(100, new int[]{1, 2, 3}));
        Assert.assertEquals(1, ArraySolutions.minSubArrayLen(7, new int[]{2, 3, 1, 2, 7, 3}));
        Assert.assertEquals(2, ArraySolutions.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(3, ArraySolutions.minSubArrayLen(9, new int[]{2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(4, ArraySolutions.minSubArrayLen(10, new int[]{2, 3, 1, 2, 4, 3}));

        Assert.assertEquals(0, ArraySolutions.minSubArrayLen2(100, new int[]{1, 2, 3}));
        Assert.assertEquals(1, ArraySolutions.minSubArrayLen2(7, new int[]{2, 3, 1, 2, 7, 3}));
        Assert.assertEquals(2, ArraySolutions.minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(3, ArraySolutions.minSubArrayLen2(9, new int[]{2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(4, ArraySolutions.minSubArrayLen2(10, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    public void rotate() {
        int[] nums;
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArraySolutions.rotate(nums, 3);
        Assert.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArraySolutions.rotate(nums, 4);
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, nums);
    }

    @Test
    public void getRow() {
        Assert.assertEquals(Arrays.asList(1), ArraySolutions.getRow(0));
        Assert.assertEquals(Arrays.asList(1, 1), ArraySolutions.getRow(1));
        Assert.assertEquals(Arrays.asList(1, 2, 1), ArraySolutions.getRow(2));
        Assert.assertEquals(Arrays.asList(1, 3, 3, 1), ArraySolutions.getRow(3));
        Assert.assertEquals(Arrays.asList(1, 4, 6, 4, 1), ArraySolutions.getRow(4));
        Assert.assertEquals(Arrays.asList(1, 5, 10, 10, 5, 1), ArraySolutions.getRow(5));
        Assert.assertEquals(Arrays.asList(1), ArraySolutions.getRow2(0));
        Assert.assertEquals(Arrays.asList(1, 1), ArraySolutions.getRow2(1));
        Assert.assertEquals(Arrays.asList(1, 2, 1), ArraySolutions.getRow2(2));
        Assert.assertEquals(Arrays.asList(1, 3, 3, 1), ArraySolutions.getRow2(3));
        Assert.assertEquals(Arrays.asList(1, 4, 6, 4, 1), ArraySolutions.getRow2(4));
        Assert.assertEquals(Arrays.asList(1, 5, 10, 10, 5, 1), ArraySolutions.getRow2(5));
    }

    @Test
    public void removeDuplicates() {
        int[] nums, nums2;
        int len;

        nums = new int[]{3, 3, 3};
        len = ArraySolutions.removeDuplicates(nums);
        nums2 = new int[len];
        System.arraycopy(nums, 0, nums2, 0, len);
        Assert.assertArrayEquals(new int[]{3}, nums2);
        Assert.assertEquals(1, len);

        nums = new int[]{1, 1, 2};
        len = ArraySolutions.removeDuplicates(nums);
        nums2 = new int[len];
        System.arraycopy(nums, 0, nums2, 0, len);
        Assert.assertArrayEquals(new int[]{1, 2}, nums2);
        Assert.assertEquals(2, len);

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        len = ArraySolutions.removeDuplicates(nums);
        nums2 = new int[len];
        System.arraycopy(nums, 0, nums2, 0, len);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4}, nums2);
        Assert.assertEquals(5, len);
    }

    @Test
    public void moveZeroes() {
        int[] nums;
        nums = new int[]{0, 0, 0};
        ArraySolutions.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 0}, nums);

        nums = new int[]{1, 1, 1};
        ArraySolutions.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 1, 1}, nums);

        nums = new int[]{0, 1, 0, 3, 12};
        ArraySolutions.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    public void moveZeroes2() {
        int[] nums;
        nums = new int[]{0, 0, 0};
        ArraySolutions.moveZeroes2(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 0}, nums);

        nums = new int[]{1, 1, 1};
        ArraySolutions.moveZeroes2(nums);
        Assert.assertArrayEquals(new int[]{1, 1, 1}, nums);

        nums = new int[]{0, 1, 0, 3, 12};
        ArraySolutions.moveZeroes2(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }
}