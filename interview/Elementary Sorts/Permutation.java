/**
 * @date 2018/03/28
 * Question: Given two integer arrays of size n,
 * design a subquadratic algorithm to determine
 * whether one is a permutation of the other.
 * That is, do they contain exactly the same entries
 * but, possibly, in a different order.
 *
 * Solution:
 * Assume that the two array are a and b.
 * 1.Copy a and b, so I get a1 and b1.    O(2*n)
 * 2.Sort a1 and b1.     O(2*n^(3/2))
 * 3.Compare a1 with b at the same position.    O(n)
 * 4.Compare a with b2 at the same position.    O(n)
 *
 */

