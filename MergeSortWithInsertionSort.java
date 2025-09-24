import java.util.Arrays;

public class MergeSortWithInsertionSort {

    // Merge two sorted arrays (left and right) into one sorted array
    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Compare elements from left[] and right[] and put the smaller one into array[]
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy the rest of the left[] if something is left
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy the rest of the right[] if something is left
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Insertion sort (good for small subarrays)
    public static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = array[i];
            int j = i - 1;

            // Move bigger elements one step to the right
            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Public method to start merge sort
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length - 1);
    }

    // Recursive helper
    private static void mergeSortHelper(int[] array, int left, int right) {
        // If subarray size <= 8 → use insertion sort (faster on small arrays)
        if (right - left + 1 <= 8) {
            insertionSort(array, left, right);
        } else {
            if (left < right) {
                // Find the middle point
                int mid = (left + right) / 2;

                // Sort both halves
                mergeSortHelper(array, left, mid);
                mergeSortHelper(array, mid + 1, right);

                // Copy halves into temp arrays
                int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
                int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

                // Merge them back
                merge(array, leftArray, rightArray);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7, 2, 1, 0, 25, 10, 3};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(array));
    }
}
