package leetcode.hash;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void singleNumber() {
        int[] nums;
        nums = new int[]{2, 2, 1};
        Assert.assertEquals(1, HashSolutions.singleNumber(nums));
        Assert.assertEquals(1, HashSolutions.singleNumber2(nums));

        nums = new int[]{4, 1, 2, 1, 2};
        Assert.assertEquals(4, HashSolutions.singleNumber(nums));
        Assert.assertEquals(4, HashSolutions.singleNumber2(nums));
    }

    @Test
    public void intersection() {
        int[] nums1, nums2;
        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        Assert.assertArrayEquals(new int[]{2}, HashSolutions.intersection(nums1, nums2));
        Assert.assertArrayEquals(new int[]{2}, HashSolutions.intersection2(nums1, nums2));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        Assert.assertArrayEquals(new int[]{9, 4}, HashSolutions.intersection(nums1, nums2));
        Assert.assertArrayEquals(new int[]{4, 9}, HashSolutions.intersection2(nums1, nums2));
    }

    @Test
    public void isHappy() {
        Assert.assertTrue(HashSolutions.isHappy(19));
        Assert.assertFalse(HashSolutions.isHappy(4));
    }

    @Test
    public void twoSum() {
        int[] nums;
        nums = new int[]{2, 7, 11, 15};
        Assert.assertArrayEquals(new int[]{0, 1}, HashSolutions.twoSum(nums, 9));
    }

    @Test
    public void isIsomorphic() {
        Assert.assertTrue(HashSolutions.isIsomorphic("egg", "add"));
        Assert.assertFalse(HashSolutions.isIsomorphic("foo", "bar"));
        Assert.assertTrue(HashSolutions.isIsomorphic("paper", "title"));
        Assert.assertFalse(HashSolutions.isIsomorphic("ab", "aa"));
        Assert.assertFalse(HashSolutions.isIsomorphic("aa", "ab"));

        Assert.assertTrue(HashSolutions.isIsomorphic2("egg", "add"));
        Assert.assertFalse(HashSolutions.isIsomorphic2("foo", "bar"));
        Assert.assertTrue(HashSolutions.isIsomorphic2("paper", "title"));
        Assert.assertFalse(HashSolutions.isIsomorphic2("ab", "aa"));
        Assert.assertFalse(HashSolutions.isIsomorphic2("aa", "ab"));
    }

    @Test
    public void findRestaurant() {
        String[] list1, list2;
        list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        Assert.assertArrayEquals(new String[]{"Shogun"}, HashSolutions.findRestaurant(list1, list2));

        list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        list2 = new String[]{"KFC", "Shogun", "Burger King"};
        Assert.assertArrayEquals(new String[]{"Shogun"}, HashSolutions.findRestaurant(list1, list2));

        list1 = new String[]{"Shogun", "Burger King", "Tapioca Express", "KFC"};
        list2 = new String[]{"Burger King", "Shogun", "KFC"};
        Assert.assertArrayEquals(new String[]{"Burger King", "Shogun"}, HashSolutions.findRestaurant(list1, list2));
    }

    @Test
    public void firstUniqChar() {
        Assert.assertEquals(0, HashSolutions.firstUniqChar("leetcode"));
        Assert.assertEquals(2, HashSolutions.firstUniqChar("loveleetcode"));
    }

    @Test
    public void intersect() {
        int[] nums1, nums2;
        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        Assert.assertArrayEquals(new int[]{2, 2}, HashSolutions.intersect(nums1, nums2));
        Assert.assertArrayEquals(new int[]{2, 2}, HashSolutions.intersect2(nums1, nums2));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        Assert.assertArrayEquals(new int[]{9, 4}, HashSolutions.intersect(nums1, nums2));
        Assert.assertArrayEquals(new int[]{4, 9}, HashSolutions.intersect2(nums1, nums2));

        nums1 = new int[]{1, 2};
        nums2 = new int[]{1, 1};
        Assert.assertArrayEquals(new int[]{1}, HashSolutions.intersect(nums1, nums2));
        Assert.assertArrayEquals(new int[]{1}, HashSolutions.intersect2(nums1, nums2));
    }

    @Test
    public void containsNearbyDuplicate() {
        Assert.assertEquals(true, HashSolutions.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        Assert.assertEquals(true, HashSolutions.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        Assert.assertEquals(false, HashSolutions.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        Assert.assertEquals(true, HashSolutions.containsNearbyDuplicate(new int[]{1, 1}, 2));
    }

    @Test
    public void groupAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new ArrayList<>();
        result.add(Arrays.asList("eat", "tea", "ate"));
        result.add(Arrays.asList("bat"));
        result.add(Arrays.asList("tan", "nat"));
        Assert.assertEquals(result, HashSolutions.groupAnagrams(strs));
    }

    @Test
    public void isValidSudoku() {
        char[][] board;
        board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Assert.assertTrue(HashSolutions.isValidSudoku(board));
        Assert.assertTrue(HashSolutions.isValidSudoku2(board));
        Assert.assertTrue(HashSolutions.isValidSudoku3(board));

        board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Assert.assertFalse(HashSolutions.isValidSudoku(board));
        Assert.assertFalse(HashSolutions.isValidSudoku2(board));
        Assert.assertFalse(HashSolutions.isValidSudoku3(board));
    }
}