package sortingalgorithm;

public class HeapSortTest extends SortingAlgorithmTest {

    @Override
    SortingAlgorithm getSortingAlgorithm() {
        return new HeapSort();
    }
}