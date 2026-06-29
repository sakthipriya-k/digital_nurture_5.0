// ============================================================
//  INSERTION SORT
//  Best Case:    O(n)   → already sorted
//  Average Case: O(n^2)
//  Worst Case:   O(n^2) → reverse sorted
//  Space:        O(1)   → in-place
//  Reference: https://www.geeksforgeeks.org/sorting-algorithms/
// ============================================================

import java.util.Arrays;

public class InsertionSort {

    // ----------------------------------------------------------
    // Insertion Sort - picks each element and inserts it
    // into the correct position in the sorted part
    // ----------------------------------------------------------
    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];   // element to be inserted
            int j = i - 1;

            // shift elements greater than key one position right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;   // place key in correct position
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original array:      " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After Insertion Sort: " + Arrays.toString(arr));

        /*
         * HOW IT WORKS:
         * Start: [12, 11, 13, 5, 6]
         * i=1: key=11 → [11, 12, 13, 5, 6]
         * i=2: key=13 → [11, 12, 13, 5, 6]
         * i=3: key=5  → [5, 11, 12, 13, 6]
         * i=4: key=6  → [5, 6, 11, 12, 13]
         *
         * Like sorting playing cards in your hand.
         */
    }
}
