import java.util.Arrays;

public class MergeSortWithInsertionSort {

    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void insertionSort(int[] array, int left, int right) {
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

    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length - 1);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (right - left + 1 <= 8) {
            insertionSort(array, left, right);
        } else {
            if (left < right) {
                int mid = (left + right) / 2;

                mergeSortHelper(array, left, mid);
                mergeSortHelper(array, mid + 1, right);

                int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
                int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);
                merge(array, leftArray, rightArray);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7, 2, 1, 0, 25, 10, 3};

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));

        mergeSort(array);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array));
    }
}
