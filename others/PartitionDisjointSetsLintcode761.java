import java.util.*;

class PartitionDisjointSetsLintcode761 {
  public int minElements(int[] arr) {
    // write your code here
    Arrays.sort(arr);

    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }

    int runningSum = 0;
    for (int i = arr.length - 1; i > 0; i--) {
      runningSum += arr[i];

      if (runningSum > sum - runningSum)
        return arr.length - i;
    }

    return 0;
  }

  public static void main(String[] args) {
    // int[] nums = { 3, 1, 7, 1 };
    int[] nums = { 2, 1, 2 };

    PartitionDisjointSetsLintcode761 ob = new PartitionDisjointSetsLintcode761();
    System.out.println(ob.minElements(nums));
  }
}

/*
 * Given an array of non-negative integers. Our task is to find minimum number
 * of elements
 * such that their sum should be greater than the sum of rest of the elements of
 * the array.
 * At least one positive integer is in the array.
 * 
 * Example
 * Example 1:
 * 
 * Input: nums = [3, 1, 7, 1],
 * Output: 1
 * Example 2:
 * 
 * Input: nums = [2, 1, 2],
 * Output: 2
 * 
 * 
 */
