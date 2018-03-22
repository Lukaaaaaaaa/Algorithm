/**
 * Search in a bitonic array. An array is bitonic if it is comprised of 
 * an increasing sequence of integers followed immediately by a decreasing 
 * sequence of integers. Write a program that, given a bitonic array of 
 * n distinct integer values, determines whether a given integer is in the array.

 * Standard version: Use ∼3lgn compares in the worst case.
 * Signing bonus: Use ∼2lgn compares in the worst case (and prove 
   that no algorithm can guarantee to perform fewer than ∼2lgn compares
   in the worst case).
 */


/**
 * 1.find the peak;
 * 2.perform binary search on the both half of the array;
 */
public class BitonicSearch {
    public static int FindPeak(int[] arr) {
        int start = 0;
        int end = arr.length;
        while ((arr[peak] < arr[peak+1]) || (arr[peak] < arr[peak-1])) {
            int peak = start + (end - start) / 2;
            if (arr[peak] < arr[peak + 1]) start = peak + 1;
            if (arr[peak] < arr[peak - 1]) end = peak - 1;
        }
        return peak;
    }

    private static int BinarySearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) {
                start = mid + 1;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            }
        }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 9, 12, 17, 24, 15, 10, 3, 0, -1};
        int peak = FindPeak(arr); //bonus: choose a peak randomly
        int start = 0;
        int end = arr.length - 1;
        int target = Integer.parseInt(args[0]);
        //perform binary search on the left side
        int res1 = BinarySearch(arr, start, peak, target);
        //perform binary search on the left side
        int res2 = BinarySearch(arr, peak, end, target);

    }
}
