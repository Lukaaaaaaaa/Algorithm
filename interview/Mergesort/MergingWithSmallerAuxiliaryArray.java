/**
 * @Date 2018/3/30
 * Question: Merging with smaller auxiliary array
 * Suppose that the subarray a[0] to a[n−1] is sorted and
 * the subarray a[n] to a[2∗n−1] is sorted. How can you merge
 * the two subarrays so that a[0] to a[2∗n−1] is sorted using
 * an auxiliary array of length n (instead of 2n)?
 *
 * Solution:
 * 1. Merge the a[] as usual;
 * 2. When aux[] is full, copy the last a[] to the a[0] ~ a[n-1];
 * 3. Merge the last a[], using a[n] ~ a[2*n -1] as auxiliary array;
 */

public class MergingWithSmallerAuxiliaryArray {

}
