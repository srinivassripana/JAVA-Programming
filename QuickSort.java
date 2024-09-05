import java.util.Scanner;

public class QuickSort {
    // Function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition function
    static int partition(int[] arr, int low, int high) {
        // Initialize pivot to be the first element
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            // Condition 1: Find the first element greater than the pivot (from starting)
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            // Condition 2: Find the first element smaller than the pivot (from last)
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    // QuickSort function
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Call Partition function to find Partition Index
            int partitionIndex = partition(arr, low, high);

            // Recursively call quickSort() for left and right half based on partition Index
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Printing the original array
        System.out.print("Original array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Calling quickSort() to sort the given array
        quickSort(arr, 0, n - 1);

        // Printing the sorted array
        System.out.print("\nSorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}
