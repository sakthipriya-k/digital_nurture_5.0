// ============================================================
//  MERGE SORT
//  Best Case:    O(n log n)
//  Average Case: O(n log n)
//  Worst Case:   O(n log n)
//  Space:        O(n) → extra array needed
//  Stable Sort:  Yes
//  Reference: https://www.geeksforgeeks.org/sorting-algorithms/
// ============================================================

import java.util.Arrays;

public class MergeSort {

    // ----------------------------------------------------------
    // Step 1: Divide array into two halves recursively
    // ----------------------------------------------------------
    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;    // base case

        int mid = arr.length / 2;

        int[] left  = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    // ----------------------------------------------------------
    // Step 2: Merge two sorted halves into one sorted array
    // ----------------------------------------------------------
    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // copy remaining elements
        while (i < left.length)  result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println("Original array:    " + Arrays.toString(arr));
        arr = mergeSort(arr);
        System.out.println("After Merge Sort:  " + Arrays.toString(arr));

        /*
         * HOW IT WORKS:
         * [9,8,7,6,5,4,3,2,1]
         *  ↓ divide
         * [9,8,7,6] and [5,4,3,2,1]
         *  ↓ divide again...
         * [9],[8] → merge → [8,9]
         * [7],[6] → merge → [6,7]
         * [8,9],[6,7] → merge → [6,7,8,9]
         * ...finally all merged into [1,2,3,4,5,6,7,8,9]
         */
    }
}
