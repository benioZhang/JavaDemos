package sortingalgorithm;

import static org.junit.Assert.*;

public class BinaryInsertionSortTest extends SortingAlgorithmTest {

    @Override
    SortingAlgorithm getSortingAlgorithm() {
        return new BinaryInsertionSort();
    }
}