import java.io.*;
import java.util.*;

class MaximumSumContiguosSubArraySizeK {

  public int maximumSum(int [] array, int k) {

      int maxSum = 0;

      // k must be smaller than n
      if (array.length < k)
      {
          System.out.println("Invalid");
          return -1;
      }

      // Compute sum of first window of size k
      int i = 0 ;
      int currentWindowSum = 0;

      for(i=0; i<k; i++)
        currentWindowSum += array[i];

      // initialize maximum sum
      maxSum = currentWindowSum;

      // Compute sums of remaining windows by
      // removing first element of previous
      // window and adding last element of
      // current window.
      for(;i<array.length; i++)
      {
        currentWindowSum =  currentWindowSum - array[i-k] + array[i];

        maxSum = Math.max(maxSum, currentWindowSum);
      }

      return maxSum;
  }

  public static void main(String[] args) {
    int [] array = {1, 4, 2, 10, 23, 3, 1, 0, 20};
    int k = 4;

    MaximumSumContiguosSubArraySizeK ob = new MaximumSumContiguosSubArraySizeK();
    System.out.println(ob.maximumSum(array, k));
  }
}

/*
Given an array of integers and a number k, find the maximum sum of a subarray of size k. 

Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23}
of size 4.

An Efficient Solution is based on the fact that sum of a subarray (or window) of size k can be obtained in O(1) time using the sum of the previous subarray (or window) of size k. Except for the first subarray of size k, for other subarrays, we compute the sum by removing the first element of the last window and adding the last element of the current window.

Time Complexity: O(n)
Auxiliary Space: O(1) 

*/
