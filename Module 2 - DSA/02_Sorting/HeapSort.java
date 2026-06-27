// ============================================================
//  HEAP SORT
//  Best Case:    O(n log n)
//  Average Case: O(n log n)
//  Worst Case:   O(n log n)
//  Space:        O(1)  → in-place
//  Stable:       No
//  Reference: https://www.geeksforgeeks.org/sorting-algorithms/
// ============================================================

import java.util.Arrays;

public class HeapSort {

    // ----------------------------------------------------------
    // Heapify - maintain max-heap property at index i
    // n = size of heap
    // ----------------------------------------------------------
    static void heapify(int[] arr, int n, int i) {
        int largest = i;        // assume root is largest
        int left  = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // if left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // if right child is larger
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // if largest is not root, swap and heapify down
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest); // recursively heapify affected subtree
        }
    }

    // ----------------------------------------------------------
    // Heap Sort
    // Step 1: Build max-heap from array
    // Step 2: Extract max (root) one by one
    // ----------------------------------------------------------
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build max-heap
        // Start from last non-leaf node and heapify upward
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:  " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After Heap Sort: " + Arrays.toString(arr));

        /*
         * HOW IT WORKS:
         * 1. Build Max-Heap: [13,11,12,5,6,7]
         * 2. Swap root(13) with last → [12,11,7,5,6,13] → heapify
         * 3. Swap root(12) with last → [11,6,7,5,12,13] → heapify
         * ...continues until sorted
         *
         * Guaranteed O(n log n) in all cases.
         */
    }
}
