package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * Q:
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {

    private List<Long> data;
    // 当前栈中的最小元素
    private long min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        if (data.isEmpty()) {
            // 当前栈为空，则最小元素为x
            min = x;
        }
        // 每一次push一个delta, delta=x-min，用于记录上一次的min
        // 此处运算可能会超出int的范围
        data.add(x - min);
        // 更新min
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        if (data.isEmpty()) {
            return;
        }
        long top = data.remove(data.size() - 1);
        if (top < 0) {
            // 因为top=x-min(此处的min为上一次的min)，且如果x<min的话，min会被更新为x
            // 故top<0即x<min，上一次的min = 当前min - top
            min = min - top;
        }
    }

    public int top() {
        long top = data.get(data.size() - 1);
        if (top < 0) {
            return (int) min;
        }
        return (int) (top + min);
    }

    public int getMin() {
        return (int) min;
    }
}