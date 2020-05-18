package techQuestions;

/*
Purpose: Given a circular array C of integers represented by A, find the maximum possible
sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.
(Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.
(Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2
 <= j with k1 % A.length = k2 % A.length.)

Example 1:

Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3
Example 2:

Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
Example 3:

Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
Example 4:

Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
Example 5:

Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1


Author: Erich Meissner
Date: 5/15/20
Time: 6:58 PM
 */


import java.io.InputStream;
import java.util.Properties;

public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        int[] A = {5,-3,5};
        System.out.println(maxSubarraySumCircular(A));
    }
    public static int maxSubarraySumCircular(int[] A) {
        // initialized these two variables to equal first array element
        int ans = A[0];
        int cur = A[0];
        int len = A.length;
        for (int i = 1; i < len; i++) {
            // for each element in the array, cur holds the maximum sum up to that point
            cur = A[i] + Math.max(cur, 0);
//            System.out.println(cur);
            ans = Math.max(ans, cur);
        }
//        System.out.println(ans);
        // the ans variable now holds the answer for 1 interval subarrays
        // next we must calculate the answer for 2 interval subarrays
        // for each i, we want to know the maximum of sum(A[j:]) with j >= i+2
        int[] rightSums = new int[len];
        // initalize the end of this rightsum array
        rightSums[len-1] = A[len-1];
        for (int i = len - 2; i >= 0; i--) {
            // start at second to last index
            rightSums[i] = rightSums[i+1] + A[i];
        }
        // we know that maxRight[i] is equal to the max(j >= 1) rightsums[j]
        int[] maxRight = new int[len];
        maxRight[len-1] = A[len-1];
        for (int i = len - 2; i>=0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], rightSums[i]);
        }
        int leftSum = 0;
        for (int i = 0; i < len-2; i++) {
            leftSum = leftSum + A[i];
            ans = Math.max(ans, leftSum + maxRight[i+2]);
        }

        return ans;
        // brute force concept: for each index i in the array,
        // test every possible length and replace maxSum with largest
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i < A.length; i++) {
//            int sum = A[i];
////            System.out.println(sum);
//            if (sum > maxSum) {
//                maxSum = sum;
//            }
//            for (int j = i + 1; j < A.length; j++) {
//                sum = sum + A[j];
//                if (sum > maxSum) {
//                    maxSum = sum;
//                }
//            }
//            if (i > 0) {
////                System.out.println(i);
//                for (int k = 0; k < i; k++) {
//                    sum = sum + A[k];
//                    if (sum > maxSum) {
//                        maxSum = sum;
//                    }
//                }
//            }
//        }
//        return maxSum;
    }
}
