package algorithm;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * http://wiki.jikexueyuan.com/project/for-offer/question-three.html
 */
public class FindInArray {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p/>
     * 规律：首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
     * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
     * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小
     * 查找的范围，直到找到要查找的数字，或者查找范围为空。
     *
     * @param a   待查找的数组
     * @param num 要查找的数
     * @return 查找结果，true找到，false没有找到
     */
    public static boolean findNum(int a[][], int num) {
        if (a == null || a.length == 0) {
            return false;
        }
        final int row = a.length;
        final int col = a[0].length;
        int i = 0, j = col - 1;
        while (i < row && i >= 0 && j >= 0 && j < col) {
            if (a[i][j] == num) {
                return true;
            } else if (a[i][j] > num) {
                // 在该行查找
                j--;
            } else {
                //在下一列查找
                i++;
            }
        }
        return false;
    }
}
