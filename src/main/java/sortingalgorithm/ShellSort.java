package sortingalgorithm;

/**
 * 希尔排序
 */
public class ShellSort extends SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        checkArray(numbers);
        shellSort(numbers);
    }

    public static void shellSort(int numbers[]) {
        int dk = numbers.length / 2;// 增量
        while (dk >= 1) {
            shellInsert(numbers, dk);
            dk /= 2;
        }
    }

    private static void shellInsert(int numbers[], int dk) {
        int i, j, insertNum, length = numbers.length;
        for (i = dk; i < length; i++) { // 分别向每组的有序区域插入
            insertNum = numbers[i];// 记录要插入的数据
            for (j = i - dk; j >= 0 && numbers[j] > insertNum; j -= dk) {// 比较与记录后移同时进行
                numbers[j + dk] = numbers[j];// 向后移
            }
            numbers[j + dk] = insertNum;
        }
    }
}
