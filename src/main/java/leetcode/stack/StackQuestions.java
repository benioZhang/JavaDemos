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

    /**
     * https://leetcode-cn.com/problems/decode-string/
     * Q: 394. 字符串解码
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     * 示例:
     * <p>
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        // 存储重复次数
        List<Integer> countStack = new ArrayList<>();
        // 存储编码的字符串
        List<String> stringStack = new ArrayList<>();
        int i = 0, j, len = s.length();
        char c;
        while (i < len) {
            c = s.charAt(i);
            if (Character.isLetter(c)) {
                // 如果当前字符是字母，则需要将该字符串解析出来
                j = i;
                while (j + 1 < len && Character.isLetter(s.charAt(j + 1))) {
                    j++;
                }
                // 将解析出来的字符串入栈
                stringStack.add(s.substring(i, j + 1));
                // 更新当前遍历的下标
                i = j;
            } else if (Character.isDigit(c)) {
                // 如果当前字符是数字，则需要将该数字解析出来
                j = i;
                while (j + 1 < len && Character.isDigit(s.charAt(j + 1))) {
                    j++;
                }
                // 将解析出来的数字入栈
                countStack.add(Integer.parseInt(s.substring(i, j + 1)));
                // 更新当前遍历的下标
                i = j;
            } else if (c == ']') {
                // 将'['到']'间的字符串出栈
                String str = stringStack.remove(stringStack.size() - 1);
                StringBuilder sb = new StringBuilder(str);
                while (stringStack.size() > 0) {
                    str = stringStack.remove(stringStack.size() - 1);
                    if ("[".equals(str)) {
                        break;
                    } else {
                        sb.insert(0, str);
                    }
                }

                // str为'['到']'间的字符串
                str = sb.toString();
                // 将重复次数出栈
                int k = countStack.remove(countStack.size() - 1);
                sb = new StringBuilder(str.length() * k);
                j = 0;
                while (j < k) {
                    sb.append(str);
                    j++;
                }
                // 将运算的结果入栈
                stringStack.add(sb.toString());
            } else if (c == '[') {
                stringStack.add("[");
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stringStack.isEmpty()) {
            sb.insert(0, stringStack.remove(stringStack.size() - 1));
        }
        return sb.toString();
    }

    public static String decodeString2(String s) {
        // 存储重复次数
        List<Integer> countStack = new ArrayList<>();
        // 存储编码的字符串
        List<String> stringStack = new ArrayList<>();
        int i = 0, len = s.length();
        char c;
        // 记录'['前的数字
        int count = 0;
        // 记录'['之前的字符串
        StringBuilder result = new StringBuilder();
        while (i < len) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                // 计算'['前面的数字
                count = count * 10 + c - '0';
            } else if (c == '[') {
                // 将'['前面的数字和字符串入栈
                stringStack.add(result.toString());
                countStack.add(count);
                // 入栈后，重置count和result
                count = 0;
                result.delete(0, result.length());
            } else if (c == ']') {
                // 将'['前面的数字和字符串出栈
                String string = stringStack.remove(stringStack.size() - 1);
                int repeatCount = countStack.remove(countStack.size() - 1);
                StringBuilder sb = new StringBuilder(string.length() + repeatCount * result.length());
                sb.append(string);
                for (int j = 0; j < repeatCount; j++) {
                    sb.append(result);
                }
                result = sb;
            } else {
                // 字母，拼接到result
                result.append(c);
            }
            i++;
        }
        return result.toString();
    }
}
