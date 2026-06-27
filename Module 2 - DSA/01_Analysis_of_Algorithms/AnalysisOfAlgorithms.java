// ============================================================
//  ANALYSIS OF ALGORITHMS
//  Topics: Time Complexity, Space Complexity, Asymptotic Notations
//          Best / Average / Worst Case, Iterative & Recursive Examples
//  Reference: https://www.geeksforgeeks.org/design-and-analysis-of-algorithms/
// ============================================================

public class AnalysisOfAlgorithms {

    // ----------------------------------------------------------
    // 1. O(1) - Constant Time
    //    No loop, no recursion → always 1 step
    // ----------------------------------------------------------
    static int getFirstElement(int[] arr) {
        return arr[0]; // O(1)
    }

    // ----------------------------------------------------------
    // 2. O(n) - Linear Time
    //    Single loop → time grows with input size
    // ----------------------------------------------------------
    static void printAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // O(n)
            System.out.println(arr[i]);
        }
    }

    // ----------------------------------------------------------
    // 3. O(n^2) - Quadratic Time
    //    Nested loop → common in bubble/insertion sort
    // ----------------------------------------------------------
    static void printPairs(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {        // O(n)
            for (int j = 0; j < n; j++) {    // O(n)
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
        // Total: O(n * n) = O(n^2)
    }

    // ----------------------------------------------------------
    // 4. O(log n) - Logarithmic Time
    //    Input halves each step → Binary Search
    // ----------------------------------------------------------
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {           // O(log n)
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // ----------------------------------------------------------
    // 5. O(n log n) - Linearithmic Time
    //    Divide & conquer → Merge Sort, Quick Sort
    // ----------------------------------------------------------
    // (See 02_Sorting folder for full Merge Sort implementation)

    // ----------------------------------------------------------
    // 6. Recursive Algorithm - Time Complexity
    //    Fibonacci: T(n) = T(n-1) + T(n-2) → O(2^n)
    // ----------------------------------------------------------
    static int fibonacci(int n) {
        if (n < 2) return n;             // base case
        return fibonacci(n - 1) + fibonacci(n - 2); // O(2^n)
    }

    // ----------------------------------------------------------
    // 7. Factorial - T(n) = T(n-1) + O(1) → O(n)
    // ----------------------------------------------------------
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;  // base case
        return n * factorial(n - 1);     // O(n)
    }

    // ----------------------------------------------------------
    // 8. Sum of First N Numbers (Iterative) → O(n)
    // ----------------------------------------------------------
    static int sumIterative(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {  // O(n)
            sum += i;
        }
        return sum;
    }

    // ----------------------------------------------------------
    // 9. Sum of First N Numbers (Formula) → O(1)
    // ----------------------------------------------------------
    static int sumFormula(int n) {
        return n * (n + 1) / 2;          // O(1)
    }

    // ----------------------------------------------------------
    // MAIN - Demo all cases
    // ----------------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("=== O(1) - First Element ===");
        System.out.println(getFirstElement(arr));

        System.out.println("\n=== O(n) - Print All ===");
        printAll(arr);

        System.out.println("\n=== O(log n) - Binary Search for 30 ===");
        int index = binarySearch(arr, 30);
        System.out.println("Found at index: " + index);

        System.out.println("\n=== O(2^n) - Fibonacci(6) ===");
        System.out.println("Fibo(6) = " + fibonacci(6));

        System.out.println("\n=== O(n) - Factorial(5) ===");
        System.out.println("5! = " + factorial(5));

        System.out.println("\n=== O(n) vs O(1) Sum ===");
        System.out.println("Iterative sum(5) = " + sumIterative(5));
        System.out.println("Formula sum(5)   = " + sumFormula(5));

        /*
         * ASYMPTOTIC NOTATIONS SUMMARY:
         * ─────────────────────────────
         *  Big O    → Worst Case  (upper bound)
         *  Omega Ω  → Best Case   (lower bound)
         *  Theta θ  → Average Case (tight bound)
         *
         * COMMON TIME COMPLEXITIES (Best to Worst):
         *  O(1)       → Constant
         *  O(log n)   → Logarithmic  (Binary Search)
         *  O(n)       → Linear       (Linear Search)
         *  O(n log n) → Linearithmic (Merge Sort)
         *  O(n^2)     → Quadratic    (Bubble Sort)
         *  O(2^n)     → Exponential  (Fibonacci recursive)
         *  O(n!)      → Factorial    (Permutations)
         */
    }
}
