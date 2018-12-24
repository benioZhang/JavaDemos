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

    @Test
    public void test3() {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        Assert.assertEquals(2147483647, minStack.top());
        minStack.pop();
        Assert.assertEquals(2147483646, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(2147483646, minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        Assert.assertEquals(2147483647, minStack.top());
        Assert.assertEquals(2147483647, minStack.getMin());
        minStack.push(-2147483648);
        Assert.assertEquals(-2147483648, minStack.top());
        Assert.assertEquals(-2147483648, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(2147483647, minStack.getMin());
    }
}