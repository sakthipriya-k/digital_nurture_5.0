// ============================================================
//  BUBBLE SORT
//  Best Case:    O(n)     → already sorted
//  Average Case: O(n^2)
//  Worst Case:   O(n^2)   → reverse sorted
//  Space:        O(1)     → in-place
//  Reference: https://www.geeksforgeeks.org/sorting-algorithms/
// ============================================================

import java.util.Arrays;

public class BubbleSort {

    // ----------------------------------------------------------
    // Bubble Sort - compares adjacent elements and swaps
    // ----------------------------------------------------------
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {          // passes
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {  // compare adjacent
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swap happened in this pass → already sorted (Best Case O(n))
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:  " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After Bubble Sort: " + Arrays.toString(arr));

        /*
         * HOW IT WORKS:
         * Pass 1: [34, 25, 12, 22, 11, 64, 90]
         * Pass 2: [25, 12, 22, 11, 34, 64, 90]
         * ...continues until sorted
         *
         * Each pass "bubbles" the largest element to the end.
         */
    }
}
