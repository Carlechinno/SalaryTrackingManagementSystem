package HR;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int count = 10000;
        Worker[] workers = Generator.generateWorkers(count);

        long startTime = System.currentTimeMillis();
        var sortedArray = customSort(workers);
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;
        System.out.println("Execution Time: " + executionTime + "ms.");

        for (Worker worker : sortedArray)
        {
            System.out.println(worker.getMonthlySalary());
        }
    }


/* commented out as required by the task.
    public static <T extends Comparable<T>> T[] BubbleSort(T[] array) {
        int n = array.length;
        T[] sortedArray = Arrays.copyOf(array, n);
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (sortedArray[i - 1].compareTo(sortedArray[i]) > 0) {
                    // Swap elements if they are in the wrong order
                    T temp = sortedArray[i - 1];
                    sortedArray[i - 1] = sortedArray[i];
                    sortedArray[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        return sortedArray;
    } */

    public static <T extends Comparable<T>> T[] customSort(T[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        T[] result = Arrays.copyOf(array, array.length);
        mergeSort(result, 0, result.length - 1);
        return result;
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Create temporary arrays
        T[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray[] if any
        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray[] if any
        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }


}