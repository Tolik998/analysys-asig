import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSortHelper(array, low, pivot - 1);
            quickSortHelper(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7, 2, 1, 0, 25, 10, 3};

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));

        quickSort(array);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array));
    }
}
