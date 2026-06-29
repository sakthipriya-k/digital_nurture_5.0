// ============================================================
//  LINEAR SEARCH
//  Best Case:    O(1)  → element is at first position
//  Average Case: O(n)
//  Worst Case:   O(n)  → element at last or not found
//  Space:        O(1)
//  Works on:     Both sorted and unsorted arrays
//  Reference: https://www.geeksforgeeks.org/searching-algorithms/
// ============================================================

public class LinearSearch {

    // ----------------------------------------------------------
    // Method 1: Return index if found, -1 if not found
    // ----------------------------------------------------------
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // ----------------------------------------------------------
    // Method 2: Using a static helper method
    // ----------------------------------------------------------
    static int search(int[] a, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    // ----------------------------------------------------------
    // Method 3: Boolean - found or not
    // ----------------------------------------------------------
    static boolean isPresent(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return true;
        }
        return false;
    }

    // ----------------------------------------------------------
    // Method 4: Linear Search using Scanner (user input)
    //           Uncomment below to use with Scanner
    // ----------------------------------------------------------
    /*
    static void searchWithScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements: ");
        for (int i = 0; i < size; i++) arr[i] = sc.nextInt();

        System.out.print("Enter element to search: ");
        int search = sc.nextInt();

        for (int i = 0; i < size; i++) {
            if (arr[i] == search)
                System.out.println("Element found at index: " + i);
        }
    }
    */

    // ----------------------------------------------------------
    // MAIN
    // ----------------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {10, 20, 45, 30, 65, 50};

        System.out.println("Array: [10, 20, 45, 30, 65, 50]");

        // Method 1
        int idx = linearSearch(arr, 30);
        System.out.println("\n[Method 1] Search 30: " +
                (idx != -1 ? "Found at index " + idx : "Not Found"));

        // Method 2
        int idx2 = search(arr, arr.length, 65);
        System.out.println("[Method 2] Search 65: " +
                (idx2 != -1 ? "Found at index " + idx2 : "Not Found"));

        // Method 3
        System.out.println("[Method 3] Is 20 present: " + isPresent(arr, 20));
        System.out.println("[Method 3] Is 99 present: " + isPresent(arr, 99));

        // Not found case
        int notFound = linearSearch(arr, 100);
        System.out.println("\nSearch 100: " +
                (notFound != -1 ? "Found at index " + notFound : "Element not found"));

        /*
         * HOW IT WORKS:
         * Checks each element one by one from left to right.
         * Stops as soon as element is found.
         *
         * Best for: small arrays, unsorted data
         * Not ideal for: large sorted arrays (use Binary Search instead)
         */
    }
}
