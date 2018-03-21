package sortingalgorithm;

/**
 * 归并排序
 */
public class MergeSort extends SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        checkArray(numbers);

        int[] tmp = new int[numbers.length];
        merge(numbers, 0, numbers.length - 1, tmp);
    }

    private static void merge(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int middle = (left + right) / 2;
            merge(arr, left, middle, tmp);// 左边有序
            merge(arr, middle + 1, right, tmp);// 右边有序
            mergeSortedArray(arr, left, middle, right, tmp);// 再合并两个有序数组
        }
    }

    // 将有二个有序数列arr[left...mid]和arr[mid+1...right]合并。
    private static void mergeSortedArray(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        // 将剩余的复制到temp中
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }

        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        for (k = left; k <= right; k++) {
            arr[k] = tmp[k];
        }
    }
}
