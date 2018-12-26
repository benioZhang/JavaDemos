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
public class MinStack2 {

    private List<Integer> data;
    //存储栈的最小元素
    private List<Integer> minData;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        data = new ArrayList<>();
        minData = new ArrayList<>();
    }

    public void push(int x) {
        if (minData.isEmpty()) {
            // 如果为空，则x为最小元素
            minData.add(x);
        } else {
            // 与当前的最小元素对比
            int min = getMin();
            minData.add(min > x ? x : min);
        }
        data.add(x);
    }

    public void pop() {
        if (data.isEmpty()) {
            return;
        }
        data.remove(data.size() - 1);
        minData.remove(minData.size() - 1);
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return minData.get(minData.size() - 1);
    }
}