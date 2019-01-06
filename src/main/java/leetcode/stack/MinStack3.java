package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack3 {
    private int min = Integer.MAX_VALUE;
    private List<Integer> data;

    public MinStack3() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        if (x <= min) {
            // 当x <= min时，将min入栈，用来保存当时的min
            // 注意顺序，必须先入栈min，后入栈x
            // 否则执行top的时候，会获取到min，而不是x
            data.add(min);
            min = x;
        }
        data.add(x);
    }

    public void pop() {
        if (data.isEmpty()) {
            return;
        }
        int top = data.remove(data.size() - 1);
        // 如果当前的 top == min，需要再次pop，恢复当时的min
        if (top == min) {
            min = data.remove(data.size() - 1);
        }
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return min;
    }
}
