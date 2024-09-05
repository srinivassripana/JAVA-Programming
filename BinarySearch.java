import java.util.Scanner;

public class BinarySearch {
    // A recursive binary search function. It returns the index of x in given array
    // arr[l..r]
    // if present, otherwise returns -1
    public static int binarySearch(int arr[], int l, int r, int x) {
        // Checking if there are elements in the subarray
        if (r >= l) {
            // Calculating mid point
            int mid = l + (r - l) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking a sorted array as input
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of the array in sorted order:");
        for (int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();

        // Element to be searched
        System.out.print("Enter the element to search: ");
        int x = scanner.nextInt();

        // Calling binary search
        int index = binarySearch(arr, 0, size - 1, x);

        if (index == -1) {
            System.out.println("Element is not present in array");
        } else {
            System.out.println("Element is present at index " + index);
        }

        scanner.close();
    }
}