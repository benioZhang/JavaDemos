package leetcode.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class BinarySearchSolutionsTest {

    @Test
    public void search() {
        Assert.assertEquals(4, BinarySearchSolutions.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        Assert.assertEquals(-1, BinarySearchSolutions.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    @Test
    public void mySqrt() {
        for (int i = 0; i < 20; i++) {
            int expected = (int) Math.sqrt(i);
            int actual = BinarySearchSolutions.mySqrt(i);
            System.out.println("i = " + i + ", expected = " + expected + ", actual = " + actual);
            Assert.assertEquals(expected, actual);
        }
        System.out.println("---------------------");
        for (int i = 0; i < 20; i++) {
            int expected = (int) Math.sqrt(i);
            int actual = BinarySearchSolutions.mySqrt2(i);
            System.out.println("i = " + i + ", expected = " + expected + ", actual = " + actual);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void guessNumber() {
        Assert.assertThat(6, is(BinarySearchSolutions.guessNumber(10)));
    }
}