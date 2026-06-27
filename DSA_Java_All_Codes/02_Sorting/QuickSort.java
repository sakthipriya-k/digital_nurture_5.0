// ============================================================
//  QUICK SORT
//  Best Case:    O(n log n) → pivot divides evenly
//  Average Case: O(n log n)
//  Worst Case:   O(n^2)    → already sorted array
//  Space:        O(log n)  → recursive call stack
//  Reference: https://www.geeksforgeeks.org/sorting-algorithms/
// ============================================================

import java.util.Arrays;

public class QuickSort {

    // ----------------------------------------------------------
    // Quick Sort - picks a pivot and partitions array around it
    // ----------------------------------------------------------
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;    // base case

        int s = low;
        int e = high;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];       // pick middle as pivot

        while (s <= e) {
            while (arr[s] < pivot) s++;     // find element >= pivot from left
            while (arr[e] > pivot) e--;     // find element <= pivot from right

            if (s <= e) {
                // swap
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        // recursively sort left and right partitions
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};

        System.out.println("Original array:   " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After Quick Sort: " + Arrays.toString(arr));

        /*
         * HOW IT WORKS:
         * [6,5,4,3,2,1] → pivot = 3 (mid)
         * Left part  [1,2,3] → sorted
         * Right part [4,5,6] → sorted
         * Final: [1,2,3,4,5,6]
         *
         * Fastest in practice due to cache efficiency.
         * Worst case O(n^2) avoided by good pivot choice.
         */
    }
}
