package sortingalgorithm;

/**
 * 快速排序
 */
public class QuickSort extends SortingAlgorithm {
    @Override
    public void sort(int[] arr) {
        checkArray(arr);
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    private static int partition(int arr[], int left, int right) {
        int pivotKey = arr[left]; // 枢轴
        while (left < right) {
            while (left < right && arr[right] >= pivotKey)
                right--;
            arr[left] = arr[right];// 小于枢轴的移到左边
            while (left < right && arr[left] <= pivotKey)
                left++;
            arr[right] = arr[left];// 大于枢轴的移到右边
        }
        arr[left] = pivotKey;
        return left;
    }
}
