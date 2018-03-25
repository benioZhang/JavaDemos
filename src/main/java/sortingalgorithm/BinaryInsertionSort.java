package sortingalgorithm;

/**
 * 折半插入排序
 */
public class BinaryInsertionSort extends SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        checkArray(numbers);
        int i, j, low, high, middle;
        int length = numbers.length, insertNum;
        for (i = 1; i < length; i++) {
            insertNum = numbers[i];
            low = 0;
            high = i - 1;
            while (low <= high) { // 在numbers[low..high]中折半查找有序插入的位置
                middle = (low + high) / 2; // 折半
                if (numbers[middle] > insertNum) {
                    high = middle - 1;// 插入点在低半区
                } else {
                    low = middle + 1;// 插入点在高半区
                }
            }
            for (j = i - 1; j >= high + 1; j--) {
                numbers[j + 1] = numbers[j]; //后移
            }
            numbers[high + 1] = insertNum; // 插入
        }
    }
}
