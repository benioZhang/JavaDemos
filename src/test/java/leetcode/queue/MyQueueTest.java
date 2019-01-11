package leetcode.queue;

import org.junit.Assert;
import org.junit.Test;

public class MyQueueTest {

    @Test
    public void test() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        Assert.assertEquals(1, queue.peek());  // 返回 1
        Assert.assertEquals(1, queue.pop());  // 返回 1
        Assert.assertFalse(queue.empty());  // 返回 false
        Assert.assertEquals(2, queue.pop());  // 返回 2
        Assert.assertTrue(queue.empty());  // 返回 true
    }
}