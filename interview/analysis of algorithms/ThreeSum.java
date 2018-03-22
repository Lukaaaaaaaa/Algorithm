/**3-SUM in quadratic time. 
 * Design an algorithm for the 3-SUM problem that takes 
 * time proportional to n2 in the worst case. You may 
 * assume that you can sort the n integers in time proportional to n2 or better.
 */

/**
 * Assuming that the array is comprised if an 
 * increasing sequence of integers.
 */ 
public class ThreeSum {
    public static void main(String[] args) {
        int i, j, k;
        int[] arr ={-10, -2, -1, -3, -4, -5, -6, -7, -8, 0, 1, 2, 3, 5, 6, 7, 8, 9};


        
        for (i = 0; i < arr.length - 2; i++) {
            j = i + 1;
            k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0)
                    System.out.println(i + " " + j + " " + k);
               
                    if (sum < 0) j++;
                    if (sum >= 0) k--;
        
                
            }
        }
    }
    
}