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

}