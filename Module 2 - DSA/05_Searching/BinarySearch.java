// ============================================================
//  BINARY SEARCH
//  Best Case:    O(1)      → element is at mid
//  Average Case: O(log n)
//  Worst Case:   O(log n)
//  Space:        O(1) Iterative | O(log n) Recursive (call stack)
//  Requirement:  Array MUST be sorted
//  Reference: https://www.geeksforgeeks.org/searching-algorithms/
// ============================================================

public class BinarySearch {

    // ----------------------------------------------------------
    // Method 1: Simple Iterative Binary Search
    // ----------------------------------------------------------
    static int binarySearchSimple(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)        return mid;   // found
            else if (arr[mid] > key)    high = mid - 1; // search left
            else                        low = mid + 1;  // search right
        }
        return -1; // not found
    }

    // ----------------------------------------------------------
    // Method 2: Iterative with named parameters (clean version)
    // ----------------------------------------------------------
    static int binarySearch(int[] a, int l, int r, int x) {
        while (l <= r) {
            int m = (l + r) / 2;

            if (a[m] == x)      return m;       // index returned
            else if (a[m] > x)  r = m - 1;     // left subarray
            else                l = m + 1;      // right subarray
        }
        return -1; // not found
    }

    // ----------------------------------------------------------
    // Method 3: Recursive Binary Search
    // ----------------------------------------------------------
    static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) return -1;  // base case - not found

        int mid = (low + high) / 2;

        if (arr[mid] == target)         return mid;
        else if (arr[mid] > target)     return binarySearchRecursive(arr, low, mid - 1, target);
        else                            return binarySearchRecursive(arr, mid + 1, high, target);
    }

    // ----------------------------------------------------------
    // MAIN
    // ----------------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Sorted Array: [10, 20, 30, 40, 50]");

        // Method 1 - Simple
        System.out.println("\n[Method 1] Search 40: index " + binarySearchSimple(arr, 40));
        System.out.println("[Method 1] Search 25: index " + binarySearchSimple(arr, 25));

        // Method 2 - With named params
        int[] a = {2, 3, 4, 10, 40};
        int n = a.length;
        int target = 10;
        int result = binarySearch(a, 0, n - 1, target);
        System.out.println("\n[Method 2] Search " + target + " in [2,3,4,10,40]: " +
                (result == -1 ? "Not Found" : "Found at index " + result));

        // Method 3 - Recursive
        int idx = binarySearchRecursive(arr, 0, arr.length - 1, 30);
        System.out.println("\n[Method 3 Recursive] Search 30: index " + idx);

        // Not found
        int notFound = binarySearchRecursive(arr, 0, arr.length - 1, 99);
        System.out.println("[Method 3 Recursive] Search 99: " +
                (notFound == -1 ? "Not Found" : "Found at " + notFound));

        /*
         * HOW IT WORKS:
         * Array: [10, 20, 30, 40, 50], Search: 40
         *
         * Step 1: low=0, high=4, mid=2 → arr[2]=30 < 40 → go right
         * Step 2: low=3, high=4, mid=3 → arr[3]=40 == 40 → FOUND at index 3
         *
         * Each step halves the search space → O(log n)
         *
         * MUST USE SORTED ARRAY — otherwise results are wrong.
         */
    }
}
