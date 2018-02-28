package sortingalgorithm;

import org.junit.Assert;
import org.junit.Test;

public abstract class SortingAlgorithmTest {

    @Test
    public void sort() throws Exception {
        int numbers[] = {49, 38, 65, 97, 76, 13, 27, 49};
        SortingAlgorithm sortingAlgorithm = getSortingAlgorithm();
        sortingAlgorithm.sort(numbers);
        int expectedNumbers[] = {13, 27, 38, 49, 49, 65, 76, 97};
        Assert.assertArrayEquals(expectedNumbers, numbers);
    }

    abstract SortingAlgorithm getSortingAlgorithm();
}
