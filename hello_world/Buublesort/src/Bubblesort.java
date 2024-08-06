public class Bubblesort {
    static void bubblesort(int[] array, int lenght) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < lenght - 1;i++) {
            swapped = false;
            for (j = 0; j < lenght - i - 1;j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    static void printArray(int[] array, int size) {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 10, 5, 2, 3, 8, 4, 6};
        int lenght = array.length;
        bubblesort(array, lenght);
        System.out.println("Sorted array: ");
        printArray(array, lenght);

        System.out.println("\n");
        int[] array1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int lenght1 = array1.length;
        bubblesort(array1, lenght1);
        System.out.println("Sorted array: ");
        printArray(array1, lenght1);
    }
}
