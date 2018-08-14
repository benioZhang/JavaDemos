package algorithm;

/**
 * 给定一个字符串，求第一个不重复的字符
 * http://wiki.jikexueyuan.com/project/for-offer/question-thirty-five.html
 * abbcad -> c
 */
public class CharStatistics {

    public static char findFirstNotRepeatingChar(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        // 所有字符的ASCII码都是在0~255之间
        int count[] = new int[256];
        char chars[] = string.toCharArray();
        for (char aChar : chars) {
            count[aChar]++;
        }
        for (char aChar : chars) {
            if (count[aChar] == 1) {
                return aChar;
            }
        }
        return '\0';
    }
}
