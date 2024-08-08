public class QuickSort {
    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int pivot = partition(arr, begin, end);

            quickSort(arr, begin, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] < pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] array = {38, 27, 43, 10};

        System.out.println("Given array:");
        for (int i : array) {
            System.out.print(i + " ");
        }

        sorter.quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
