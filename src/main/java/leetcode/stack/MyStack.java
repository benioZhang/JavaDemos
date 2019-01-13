package leetcode.stack;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * 225. 用队列实现栈
 */
public class MyStack {
    // 负责存储栈元素
    private Queue<Integer> queue;
    // 中转站
    private Queue<Integer> tempQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        tempQueue.add(x);
        // 将queue中所有元素入队tempQueue，目的是为了反转元素顺序
        while (!queue.isEmpty()) {
            tempQueue.add(queue.poll());
        }
        // 互换
        Queue<Integer> q = tempQueue;
        tempQueue = queue;
        queue = q;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */