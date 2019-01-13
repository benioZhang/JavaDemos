package leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

public class MyStackTest {

    @Test
    public void test() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.top());
        Assert.assertEquals(3, stack.pop());
        Assert.assertFalse(stack.empty());
        Assert.assertEquals(2, stack.pop());
        Assert.assertFalse(stack.empty());
        Assert.assertEquals(1, stack.pop());
        Assert.assertTrue(stack.empty());
    }

    @Test
    public void test2() {
        MyStack2 stack = new MyStack2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.top());
        Assert.assertEquals(3, stack.pop());
        Assert.assertFalse(stack.empty());
        Assert.assertEquals(2, stack.pop());
        Assert.assertFalse(stack.empty());
        Assert.assertEquals(1, stack.pop());
        Assert.assertTrue(stack.empty());
    }
}