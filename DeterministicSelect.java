import java.util.Arrays;

public class DeterministicSelect {

    // Main function: find the k-th smallest element in the array
    public static int deterministicSelect(int[] array, int k) {
        return deterministicSelectHelper(array, k, 0, array.length - 1);
    }

    // Recursive helper
    private static int deterministicSelectHelper(int[] array, int k, int left, int right) {
        // If only one element, that's the answer
        if (left == right) {
            return array[left];
        }

        // Pick a "good" pivot using median of medians
        int pivotIndex = medianOfMedians(array, left, right);

        // Partition array around pivot
        pivotIndex = partition(array, left, right, pivotIndex);

        // If pivot is at the k-th position → done
        if (k == pivotIndex) {
            return array[k];
        }
        // If k is smaller, search in left side
        else if (k < pivotIndex) {
            return deterministicSelectHelper(array, k, left, pivotIndex - 1);
        }
        // Otherwise, search in right side
        else {
            return deterministicSelectHelper(array, k, pivotIndex + 1, right);
        }
    }

    // Partition array around pivot
    private static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];

        // Move pivot to the end
        swap(array, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] < pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }

        // Move pivot to its final place
        swap(array, storeIndex, right);

        return storeIndex; // final index of pivot
    }

    // Swap helper
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Find pivot using Median of Medians method
    private static int medianOfMedians(int[] array, int left, int right) {
        int numElements = right - left + 1;
        int numMedians = (numElements + 4) / 5; // groups of 5

        int[] medians = new int[numMedians];

        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + 5 * i;
            int subRight = Math.min(subLeft + 4, right);

            // Sort each small group
            insertionSort(array, subLeft, subRight);

            // Pick median of that group
            medians[i] = array[subLeft + (subRight - subLeft) / 2];
        }

        // If only one median, return it
        if (medians.length == 1) {
            return findIndex(array, left, right, medians[0]);
        }

        // Otherwise, recursively find median of medians
        int medianOfMedianValue = deterministicSelectHelper(medians, medians.length / 2, 0, medians.length - 1);

        // Find actual index of that value in the array
        return findIndex(array, left, right, medianOfMedianValue);
    }

    // Simple insertion sort for small groups
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

    // Find index of a value in the array between left and right
    private static int findIndex(int[] array, int left, int right, int value) {
        for (int i = left; i <= right; i++) {
            if (array[i] == value) return i;
        }
        return -1; // should not happen
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7, 2, 1, 0, 25, 10, 3};

        // Find the 4th smallest element (k = 4 means index 4 if 0-based)
        int kthElement = deterministicSelect(array, 4);

        System.out.println("K-th smallest element: " + kthElement);
    }
}
