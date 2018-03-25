package sortingalgorithm;

import static org.junit.Assert.*;

public class CountingSortTest extends SortingAlgorithmTest {

    @Override
    SortingAlgorithm getSortingAlgorithm() {
        return new CountingSort();
    }
}