package sortingalgorithm;

/**
 * 选择排序
 */
public class SelectionSort extends SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        checkArray(numbers);
        int minIndex = 0;
        for (int i = 0, length = numbers.length; i < length; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) { // 遍历[i+1...size-1]
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;// 记录最小值的下标
                }
            }
            if (minIndex != i) {// 两者不等则存在更小值，交换
                swap(numbers, minIndex, i);
            }
        }
    }
}
