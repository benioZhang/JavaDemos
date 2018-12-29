package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackQuestions {

    /**
     * https://leetcode-cn.com/problems/valid-parentheses/submissions/
     * Q:有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * <p>
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        List<Character> stack = new ArrayList<>(s.length());
        char[] chars = s.toCharArray();
        Character top;
        for (char c : chars) {
            //如果遍历到相应符号，存进栈中
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                // 栈为空，c为')' ']' '}'其中之一，肯定不匹配
                if (stack.isEmpty()) {
                    return false;
                }
                top = stack.remove(stack.size() - 1);
                if (top != '(' && c == ')') {
                    return false;
                }
                if (top != '[' && c == ']') {
                    return false;
                }
                if (top != '{' && c == '}') {
                    return false;
                }
            }
        }
        // 全部匹配成功，则为有效字符串
        return stack.isEmpty();
    }

    /**
     * https://leetcode-cn.com/problems/daily-temperatures/
     * Q:739. 每日温度
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
     * <p>
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * <p>
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        final int length = T.length;
        int[] result = new int[length];
        // 最后一天，肯定为0
        result[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            // 遍历今日之后的温度
            int j = i + 1;
            while (j < length) {
                if (T[i] < T[j]) {
                    break;
                }
                // 说明之后温度都不会升高，则可提前结束遍历
                if (result[j] == 0) {
                    j = length;
                    break;
                }
                // 利用之前计算的结果进行快速跳转
                // 天数  1   2   3   4   5   6   7   8
                // 温度 [73, 74, 75, 71, 69, 72, 76, 73]
                // 输出 [1,  1,  4,  2,  1,  1,  0,  0 ]
                // 举例：计算第3天对应的输出4
                // 第3天和第4天温度比较，75>71
                // 另外我们从前面计算的结果得知，第4天之后2天温度升高，则我们可以直接拿第3天与第6天比较，75>72
                // 从前面计算的结果知道第7天比第6天温度高，继续比较第3天与第7天的温度，75<76，7-3=4天，比较结束
                j = j + result[j];
            }
            // 如果遍历到最后都没找到比今天温度高的，则输入0
            // 否则计算间隔天数即可
            result[i] = j >= length ? 0 : (j - i);
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
     * Q:150.逆波兰表达式求值
     * 根据逆波兰表示法，求表达式的值。
     * <p>
     * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * <p>
     * 说明：
     * <p>
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     * 示例 1：
     * <p>
     * 输入: ["2", "1", "+", "3", "*"]
     * 输出: 9
     * 解释: ((2 + 1) * 3) = 9
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer left, right;
        for (int i = 0, length = tokens.length; i < length; i++) {
            String str = tokens[i];
            // 遇到+, -, *, /，则将栈顶两个元素出栈，执行运算后再将结果入栈
            switch (str) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left / right);
                    break;
                default:
                    stack.add(Integer.parseInt(str));
                    break;
            }
        }
        return stack.pop();
    }
}
