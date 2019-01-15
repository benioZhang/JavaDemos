package leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

public class StackQuestionsTest {

    @Test
    public void isValid() {
        Assert.assertTrue(StackQuestions.isValid(""));
        Assert.assertTrue(StackQuestions.isValid("()"));
        Assert.assertTrue(StackQuestions.isValid("()[]{}"));
        Assert.assertFalse(StackQuestions.isValid("(]"));
        Assert.assertFalse(StackQuestions.isValid("([)]"));
        Assert.assertTrue(StackQuestions.isValid("{[]}"));
    }

    @Test
    public void dailyTemperatures() {
        int T[];
        int result[];
        T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        result = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        Assert.assertArrayEquals(result, StackQuestions.dailyTemperatures(T));

        T = new int[]{73};
        result = new int[]{0};
        Assert.assertArrayEquals(result, StackQuestions.dailyTemperatures(T));

        T = new int[]{73, 74, 70, 65, 73, 70, 74, 70};
        result = new int[]{1, 0, 2, 1, 2, 1, 0, 0};
        Assert.assertArrayEquals(result, StackQuestions.dailyTemperatures(T));
    }

    @Test
    public void evalRPN() {
        Assert.assertEquals(9, StackQuestions.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        Assert.assertEquals(6, StackQuestions.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        Assert.assertEquals(22, StackQuestions.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    @Test
    public void decodeString() {
        Assert.assertEquals("aaabcbc", StackQuestions.decodeString("3[a]2[bc]"));
        Assert.assertEquals("accaccacc", StackQuestions.decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", StackQuestions.decodeString("2[abc]3[cd]ef"));
        Assert.assertEquals("aaabFFFFcbFFFFc", StackQuestions.decodeString("3[a]2[b4[F]c]"));
        Assert.assertEquals("baaacbbdebaaacbbdef", StackQuestions.decodeString("2[b3[a]c2[b]de]f"));
    }
}