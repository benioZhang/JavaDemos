package sortingalgorithm;

/**
 * 插入排序
 */
public class InsertionSort extends SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        checkArray(numbers);
        int i, j, length = numbers.length, insertNum;
        //假设第一个数位置正确
        for (i = 1; i < length; i++) {
            insertNum = numbers[i];
            // 待插入数与numbers[i-1...0]比较，将大于insertNum的数向后移动
            for (j = i - 1; j >= 0 && numbers[j] > insertNum; j--) {
                numbers[j + 1] = numbers[j];
            }
            // 插入
            numbers[j + 1] = insertNum;
        }
    }
}
