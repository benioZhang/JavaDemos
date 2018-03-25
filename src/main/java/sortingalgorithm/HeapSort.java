package sortingalgorithm;

/**
 * 堆排序
 */
public class HeapSort extends SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        checkArray(numbers);
        heapSort(numbers);
    }

    public static void heapSort(int arr[]) {
        // 对数组进行堆排序
        int length = arr.length;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            heapAdjust(arr, i, length - 1); //将arr[0..length-1]建成大定堆
        }
        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);  // 将堆顶和当前未经排序子序列arr[0..i]中最后一个记录交换
            heapAdjust(arr, 0, i - 1); //将arr[0..i-1]重新调整为大顶堆
        }
    }

    private static void heapAdjust(int arr[], int s, int m) {
        // 已知arr[s..m]中除arr[s]外均满足堆的定义。
        // 本函数调整arr[s]，使arr[s..m]成为一个大顶堆
        int rc = arr[s];
        for (int j = 2 * s + 1; j <= m; j = 2 * j + 1) { // 沿较大的孩子结点向下筛选
            if (j < m && arr[j] < arr[j + 1]) {
                j++; // j为key较大的记录的下标
            }
            if (rc >= arr[j]) { //rc应插入在位置s上
                break; //已经为大顶堆
            }
            arr[s] = arr[j]; //将子节点上移
            s = j; //进入下一轮筛选
        }
        arr[s] = rc; //插入正确的位置
    }
}
