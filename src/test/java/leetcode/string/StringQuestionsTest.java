package leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class StringQuestionsTest {
    @Test
    public void addBinary() throws Exception {
        Assert.assertEquals("100", StringQuestions.addBinary("11", "1"));
        Assert.assertEquals("10101", StringQuestions.addBinary("1010", "1011"));
        Assert.assertEquals("1000", StringQuestions.addBinary("1", "111"));
        Assert.assertEquals("1110", StringQuestions.addBinary("111", "111"));
    }

    @Test
    public void strStr() {
        Assert.assertEquals(0, StringQuestions.strStr("hello", ""));
        Assert.assertEquals(2, StringQuestions.strStr("hello", "ll"));
        Assert.assertEquals(-1, StringQuestions.strStr("aaaaa", "bba"));
    }

    @Test
    public void longestCommonPrefix() {
        Assert.assertEquals("", StringQuestions.longestCommonPrefix(new String[]{"", "b"}));
        Assert.assertEquals("flower", StringQuestions.longestCommonPrefix(new String[]{"flower"}));
        Assert.assertEquals("fl", StringQuestions.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", StringQuestions.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

        Assert.assertEquals("", StringQuestions.longestCommonPrefix2(new String[]{"", "b"}));
        Assert.assertEquals("flower", StringQuestions.longestCommonPrefix2(new String[]{"flower"}));
        Assert.assertEquals("fl", StringQuestions.longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
        Assert.assertEquals("", StringQuestions.longestCommonPrefix2(new String[]{"dog", "racecar", "car"}));
    }

    @Test
    public void reverseString() {
        Assert.assertEquals("olleh", StringQuestions.reverseString("hello"));
        Assert.assertEquals("amanaP :lanac a ,nalp a ,nam A", StringQuestions.reverseString("A man, a plan, a canal: Panama"));
    }

    @Test
    public void reverseWords() {
        Assert.assertEquals("", StringQuestions.reverseWords(""));
        Assert.assertEquals("blue is sky the", StringQuestions.reverseWords("   the sky is    blue   "));
    }

    @Test
    public void reverseWords2() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", StringQuestions.reverseWords2("Let's take LeetCode contest"));
    }
}