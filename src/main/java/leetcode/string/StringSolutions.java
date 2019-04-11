package leetcode.string;

public class StringSolutions {
    /**
     * https://leetcode-cn.com/problems/add-binary/description/
     * Q:二进制求和
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * <p>
     * 输入为非空字符串且只包含数字 1 和 0。
     * <p>
     * 示例 1:
     * <p>
     * 输入: a = "11", b = "1"
     * 输出: "100"
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        char[] chars = new char[Math.max(aChars.length, bChars.length) + 1];// 预留进位
        int i = aChars.length - 1, j = bChars.length - 1, k = chars.length - 1;// aChars,bChars,chars下标
        int carry = 0;//当前进位
        int value = 0;
        while (i >= 0 || j >= 0) {
            value = carry;
            if (i >= 0) {
                value = value + (aChars[i--] - '0');
            }
            if (j >= 0) {
                value = value + (bChars[j--] - '0');
            }
            if (value >= 2) {
                carry = 1;
                chars[k--] = (char) (value - 2 + '0');
            } else {
                carry = 0;
                chars[k--] = (char) (value + '0');
            }
        }

        if (carry > 0) {
            // 仍有进位，直接将最高位赋1
            chars[k] = '1';
            return new String(chars);
        }
        // 没进位的话需要将多余的位去掉
        return new String(chars, 1, chars.length - 1);
    }

    /**
     * https://leetcode-cn.com/problems/implement-strstr/description/
     * Q:实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

    /**
     * https://leetcode-cn.com/problems/longest-common-prefix/description/
     * Q:最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            // 只有1个字符串，直接返回
            return strs[0];
        }
        int i = 1;// 字符串数组下标
        int j = 0;// 公共前缀下标
        while (j < strs[0].length() && j < strs[i].length()
                && strs[0].charAt(j) == strs[i].charAt(j)) {// 与第一个字符串的第j个字符对比
            i++;
            if (i == strs.length) {
                // 数组中所有字符串第j个字符相同，则比较下一个字符
                j++;
                i = 1;
            }
        }
        return strs[0].substring(0, j);
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        char c;
        // 遍历公共前缀
        for (int i = 0, len = str.length(); i < len; i++) {
            c = str.charAt(i);
            // 与数组中其它字符对比
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return str.substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * https://leetcode-cn.com/problems/reverse-string/description/
     * Q: 编写一个函数，其作用是将输入的字符串反转过来。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "hello"
     * 输出: "olleh"
     *
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        char c;
        while (i < j) {
            c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return new String(chars);
    }


    /**
     * https://leetcode-cn.com/problems/reverse-words-in-a-string/description/
     * Q:翻转字符串里的单词
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * <p>
     * 示例:
     * <p>
     * 输入: "the sky is blue",
     * 输出: "blue is sky the".
     * 说明:
     * <p>
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() > 0) {
                if (sb.length() > 0) {
                    sb.append(' ');// 给上一个单词添加空格
                }
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
     * Q:反转字符串中的单词 III
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     *
     * @param s
     * @return
     */
    public static String reverseWordsIII(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int start = 0, end;
        while (start < chars.length) {
            // 从start位置开始找空格
            end = s.indexOf(' ', start);
            if (end < 0) {
                // 反转最后一个单词
                reverseChars(chars, start, chars.length - 1);
                break;
            }
            // 反转单词
            reverseChars(chars, start, end - 1);
            // 记录下一个单词开始位置
            start = end + 1;
        }
        return new String(chars);
    }

    public static void reverseChars(char[] chars, int start, int end) {
        char c;
        while (start < end) {
            c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
    }
}
