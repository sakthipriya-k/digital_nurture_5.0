// ============================================================
//  ARRAYS - All Operations
//  Topics: Traversal, Insert, Delete, Search, Reverse,
//          Rotate, Sorting checks, Kadane's, Sliding Window
//  Reference: https://www.geeksforgeeks.org/array-data-structure-guide/
// ============================================================

import java.util.Arrays;

public class ArrayOperations {

    // ----------------------------------------------------------
    // 1. Array Traversal
    // ----------------------------------------------------------
    static void traversal(int[] arr) {
        System.out.println("--- Traversal ---");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ----------------------------------------------------------
    // 2. Insert element at a specific position
    // ----------------------------------------------------------
    static int[] insertAtPosition(int[] arr, int pos, int ele) {
        int n = arr.length;
        int[] newArr = new int[n + 1];

        for (int i = 0; i < pos; i++)       newArr[i] = arr[i];
        newArr[pos] = ele;
        for (int i = pos; i < n; i++)       newArr[i + 1] = arr[i];

        return newArr;
    }

    // ----------------------------------------------------------
    // 3. Delete element by value
    // ----------------------------------------------------------
    static int[] deleteByValue(int[] arr, int deleteVal) {
        int n = arr.length;
        int[] newArr = new int[n - 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != deleteVal) newArr[j++] = arr[i];
        }
        return newArr;
    }

    // ----------------------------------------------------------
    // 4. Linear Search
    // ----------------------------------------------------------
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // ----------------------------------------------------------
    // 5. Binary Search (array must be sorted)
    // ----------------------------------------------------------
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)      return mid;
            else if (arr[mid] < target)  low = mid + 1;
            else                         high = mid - 1;
        }
        return -1;
    }

    // ----------------------------------------------------------
    // 6. Reverse an Array
    // ----------------------------------------------------------
    static void reverse(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // ----------------------------------------------------------
    // 7. Rotate Left by 1
    // ----------------------------------------------------------
    static void rotateLeft1(int[] arr) {
        int first = arr[0];
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) arr[i] = arr[i + 1];
        arr[n - 1] = first;
    }

    // ----------------------------------------------------------
    // 8. Rotate Left by K positions
    // ----------------------------------------------------------
    static void rotateLeftK(int[] arr, int k) {
        int n = arr.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++)          temp[i] = arr[i];
        for (int i = k; i < n; i++)          arr[i - k] = arr[i];
        for (int i = 0; i < k; i++)          arr[n - k + i] = temp[i];
    }

    // ----------------------------------------------------------
    // 9. Rotate Right by 1
    // ----------------------------------------------------------
    static void rotateRight1(int[] arr) {
        int n = arr.length;
        int last = arr[n - 1];
        for (int i = n - 1; i > 0; i--) arr[i] = arr[i - 1];
        arr[0] = last;
    }

    // ----------------------------------------------------------
    // 10. Find Largest and Smallest
    // ----------------------------------------------------------
    static void findLargestSmallest(int[] arr) {
        int largest = arr[0], smallest = arr[0];
        for (int x : arr) {
            if (x > largest)  largest = x;
            if (x < smallest) smallest = x;
        }
        System.out.println("Largest: " + largest + ", Smallest: " + smallest);
    }

    // ----------------------------------------------------------
    // 11. Check if Array is Sorted (Ascending)
    // ----------------------------------------------------------
    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    // ----------------------------------------------------------
    // 12. Sum and Average
    // ----------------------------------------------------------
    static void sumAndAverage(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        System.out.println("Sum: " + sum + ", Average: " + (float) sum / arr.length);
    }

    // ----------------------------------------------------------
    // 13. Count Even and Odd
    // ----------------------------------------------------------
    static void countEvenOdd(int[] arr) {
        int even = 0, odd = 0;
        for (int x : arr) {
            if (x % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even count: " + even + ", Odd count: " + odd);
    }

    // ----------------------------------------------------------
    // 14. Move All Zeros to End
    // ----------------------------------------------------------
    static int[] moveZerosToEnd(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];
        int index = 0;
        for (int x : arr) {
            if (x != 0) newArr[index++] = x;
        }
        return newArr;
    }

    // ----------------------------------------------------------
    // 15. Remove Duplicates from Sorted Array
    // ----------------------------------------------------------
    static void removeDuplicates(int[] arr) {
        System.out.print("Without duplicates: " + arr[0] + " ");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ----------------------------------------------------------
    // 16. Find Missing Number from 1 to N
    // ----------------------------------------------------------
    static int findMissing(int[] arr) {
        int n = arr.length + 1;
        int totalSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int x : arr) actualSum += x;
        return totalSum - actualSum;
    }

    // ----------------------------------------------------------
    // 17. Kadane's Algorithm - Maximum Subarray Sum
    // ----------------------------------------------------------
    static int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // ----------------------------------------------------------
    // 18. Sliding Window - Subarray with given sum
    // ----------------------------------------------------------
    static void slidingWindow(int[] arr, int target) {
        int start = 0, sum = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum > target) { sum -= arr[start]; start++; }
            if (sum == target) {
                System.out.println("Subarray found from index " + start + " to " + end);
                return;
            }
        }
        System.out.println("No subarray found");
    }

    // ----------------------------------------------------------
    // MAIN
    // ----------------------------------------------------------
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Original: " + Arrays.toString(arr));

        // Traversal
        traversal(arr);

        // Insert
        int[] after = insertAtPosition(arr, 2, 25);
        System.out.println("After insert 25 at pos 2: " + Arrays.toString(after));

        // Delete
        int[] del = deleteByValue(arr, 30);
        System.out.println("After delete 30: " + Arrays.toString(del));

        // Linear Search
        System.out.println("Linear Search 30: index " + linearSearch(arr, 30));

        // Binary Search
        System.out.println("Binary Search 40: index " + binarySearch(arr, 40));

        // Reverse
        int[] rev = arr.clone();
        reverse(rev);
        System.out.println("Reversed: " + Arrays.toString(rev));

        // Rotate Left by 1
        int[] rl1 = arr.clone();
        rotateLeft1(rl1);
        System.out.println("Rotate Left 1: " + Arrays.toString(rl1));

        // Rotate Left by K
        int[] rlk = arr.clone();
        rotateLeftK(rlk, 2);
        System.out.println("Rotate Left K=2: " + Arrays.toString(rlk));

        // Largest / Smallest
        findLargestSmallest(arr);

        // Sorted?
        System.out.println("Is sorted: " + isSorted(arr));

        // Sum & Average
        sumAndAverage(arr);

        // Even/Odd
        countEvenOdd(arr);

        // Move Zeros
        int[] z = {0, 12, 0, 43, 78, 0, 54};
        System.out.println("Move zeros: " + Arrays.toString(moveZerosToEnd(z)));

        // Remove Duplicates
        int[] dup = {1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(dup);

        // Missing Number
        int[] mis = {1, 3, 4, 5};
        System.out.println("Missing number: " + findMissing(mis));

        // Kadane
        int[] kad = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum (Kadane): " + kadane(kad));

        // Sliding Window
        int[] sw = {1, 4, 20, 3, 10, 5};
        slidingWindow(sw, 33);
    }
}
