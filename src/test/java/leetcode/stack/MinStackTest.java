package leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {
    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin()); // --> 返回 -3
        minStack.pop();
        Assert.assertEquals(0, minStack.top()); // --> 返回 0.
        Assert.assertEquals(-2, minStack.getMin()); // --> 返回 -2.
    }
}