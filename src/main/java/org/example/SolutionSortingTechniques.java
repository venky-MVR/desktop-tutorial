import java.util.Arrays;
import java.util.Random;

public class SortComparison {
    public static void main(String[] args) {
        int n = 100000; // large input size
        int[] arr = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000000);
        }

        // Clone arrays for fair comparison
        int[] arr1 = arr.clone();
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();

        // Measure Arrays.sort()
        long start = System.currentTimeMillis();
        Arrays.sort(arr1);
        long end = System.currentTimeMillis();
        System.out.println("Arrays.sort() time: " + (end - start) + " ms");

        // Measure Bubble Sort
        start = System.currentTimeMillis();
        bubbleSort(arr2);
        end = System.currentTimeMillis();
        System.out.println("Bubble Sort time: " + (end - start) + " ms");

        // Measure Selection Sort
        start = System.currentTimeMillis();
        selectionSort(arr3);
        end = System.currentTimeMillis();
        System.out.println("Selection Sort time: " + (end - start) + " ms");

        // Measure Insertion Sort
        start = System.currentTimeMillis();
        insertionSort(arr4);
        end = System.currentTimeMillis();
        System.out.println("Insertion Sort time: " + (end - start) + " ms");
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
