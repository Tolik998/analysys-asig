import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.swap;

public class DeterministicSelect {

    public static int deterministicSelect(int[] array, int k) {
        return deterministicSelectHelper(array, k, 0, array.length - 1);
    }

    private static int deterministicSelectHelper(int[] array, int k, int left, int right) {
        if (left == right) {
            return array[left];
        }

        int pivotIndex = medianOfMedians(array, left, right);
        pivotIndex = partition(array, left, right, pivotIndex);

        if (k == pivotIndex) {
            return array[k];
        } else if (k < pivotIndex) {
            return deterministicSelectHelper(array, k, left, pivotIndex - 1);
        } else {
            return deterministicSelectHelper(array, k, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right, int pivotIndex) {
        return 0;
    }

    private static void swap(int[] array, int pivotIndex, int right) {
    }

    private static int medianOfMedians(int[] array, int left, int right) {
        int numElements = right - left + 1;
        int numMedians = (numElements + 4) / 5;

        int[] medians = new int[numMedians];
        for (int i = 0; i < numMedians; i++) {
            int subRight = Math.min(left + 5 * (i + 1) - 1, right);
            insertionSort(array, left + 5 * i, subRight);
            medians[i] = array[left + 5 * i + (subRight - (left + 5 * i)) / 2];
        }

        return deterministicSelectHelper(medians, medians.length / 2, 0, medians.length - 1);
    }

    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7, 2, 1, 0, 25, 10, 3};
        int kthElement = deterministicSelect(array, 4);

        System.out.println("К-ый элемент: " + kthElement);
    }
}
