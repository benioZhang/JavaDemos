package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

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
}
