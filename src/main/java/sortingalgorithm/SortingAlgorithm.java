package sortingalgorithm;

import java.util.Arrays;

public abstract class SortingAlgorithm {

    public abstract void sort(int numbers[]);

    static void swap(int[] numbers, int i, int j) {
        if (numbers[i] == numbers[j]) return;
        numbers[i] = numbers[i] ^ numbers[j];
        numbers[j] = numbers[i] ^ numbers[j];
        numbers[i] = numbers[i] ^ numbers[j];
    }

    static void checkArray(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("You can't pass a null instance as parameter.");
        }
    }

    static void print(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }
}
