package leetcode.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 232. 用栈实现队列
 */
public class MyQueue {
    // 负责入栈操作
    private List<Integer> push;
    // 负责出栈操作
    private List<Integer> pop;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        push = new ArrayList<>(16);
        pop = new ArrayList<>(16);
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        push.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (pop.isEmpty()) {
            while (!push.isEmpty()) {
                pop.add(push.remove(push.size() - 1));
            }
        }
        return pop.remove(pop.size() - 1);
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (pop.isEmpty()) {
            while (!push.isEmpty()) {
                pop.add(push.remove(push.size() - 1));
            }
        }
        return pop.get(pop.size() - 1);
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return push.isEmpty() && pop.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */