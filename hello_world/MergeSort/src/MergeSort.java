public class MergeSort {
    public static void mergeSort(int[] arr, int lenght) {
        if (lenght < 2) {
            return;
        }
        int mid = lenght / 2;
        int[] left = new int[mid];
        int[] right = new int[lenght - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < lenght; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left, mid);
        mergeSort(right, lenght - mid);

        merge(arr, left, right, mid, lenght - mid);
    }

    public static void merge(int[] arr, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }

        while (i < left) {
            arr[k++] = l[i++];
        }

        while (j < right) {
            arr[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 10};

        System.out.println("Given array:");
        for (int i : array) {
            System.out.print(i + " ");
        }

        mergeSort(array, array.length);

        System.out.println("\nSorted array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
