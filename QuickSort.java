import java.util.Arrays;

public class QuickSort {

    // Public function to start quicksort
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    // Recursive helper
    private static void quickSortHelper(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot position
            int pivot = partition(array, low, high);

            // Sort elements before and after pivot
            quickSortHelper(array, low, pivot - 1);
            quickSortHelper(array, pivot + 1, high);
        }
    }

    // Partition function: put all smaller elements to the left of pivot,
    // and bigger ones to the right
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // pick last element as pivot
        int i = low - 1; // index for smaller elements

        // Go through the array and move elements smaller than pivot to the left
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // Put pivot in its correct place
        swap(array, i + 1, high);
        return i + 1; // return pivot index
    }

    // Simple swap function
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7, 2, 1, 0, 25, 10, 3};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(array));

        quickSort(array);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(array));
    }
}
