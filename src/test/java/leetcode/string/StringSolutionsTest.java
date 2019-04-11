package leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class StringSolutionsTest {
    @Test
    public void addBinary() throws Exception {
        Assert.assertEquals("100", StringSolutions.addBinary("11", "1"));
        Assert.assertEquals("10101", StringSolutions.addBinary("1010", "1011"));
        Assert.assertEquals("1000", StringSolutions.addBinary("1", "111"));
        Assert.assertEquals("1110", StringSolutions.addBinary("111", "111"));
    }

    @Test
    public void strStr() {
        Assert.assertEquals(0, StringSolutions.strStr("hello", ""));
        Assert.assertEquals(2, StringSolutions.strStr("hello", "ll"));
        Assert.assertEquals(-1, StringSolutions.strStr("aaaaa", "bba"));
    }

    @Test
    public void longestCommonPrefix() {
        Assert.assertEquals("", StringSolutions.longestCommonPrefix(new String[]{"", "b"}));
        Assert.assertEquals("flower", StringSolutions.longestCommonPrefix(new String[]{"flower"}));
        Assert.assertEquals("fl", StringSolutions.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", StringSolutions.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

        Assert.assertEquals("", StringSolutions.longestCommonPrefix2(new String[]{"", "b"}));
        Assert.assertEquals("flower", StringSolutions.longestCommonPrefix2(new String[]{"flower"}));
        Assert.assertEquals("fl", StringSolutions.longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", StringSolutions.longestCommonPrefix2(new String[]{"dog", "racecar", "car"}));
    }

    @Test
    public void reverseString() {
        Assert.assertEquals("olleh", StringSolutions.reverseString("hello"));
        Assert.assertEquals("amanaP :lanac a ,nalp a ,nam A", StringSolutions.reverseString("A man, a plan, a canal: Panama"));
    }

    @Test
    public void reverseWords() {
        Assert.assertEquals("", StringSolutions.reverseWords(""));
        Assert.assertEquals("blue is sky the", StringSolutions.reverseWords("   the sky is    blue   "));
    }

    @Test
    public void reverseWordsIII() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", StringSolutions.reverseWordsIII("Let's take LeetCode contest"));
    }
}