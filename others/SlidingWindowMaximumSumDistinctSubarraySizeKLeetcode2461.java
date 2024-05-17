import java.util.HashSet;
import java.util.Set;

public class SlidingWindowMaximumSumDistinctSubarraySizeKLeetcode2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int start = 0, end = 0;
        long maxSum = 0, sum = 0;

        if (nums.length == 0 || k == 0)
            return 0L;

        // used to check duplicate numbers in the subarray
        Set<Integer> uniqueNumbers = new HashSet<Integer>();

        while (end < nums.length) {
            Integer val = nums[end];

            // If number already exists in hashset,
            // we need to advance to consider the next subarray starting at the next index
            if (uniqueNumbers.contains(val)) {
                sum -= nums[start];
                uniqueNumbers.remove(nums[start]);
                start++; // increase start only if the current character number condition
            }
            else {
                // At this point we are sure the number is not duplicate. so add it
                uniqueNumbers.add(val);
                sum += val;

                // subarray is of the desired length
                if (end - start + 1 == k) {
                    maxSum = Math.max(maxSum, sum);

                    // Prepare to consider the subarray staring at the next index
                    sum -= nums[start];
                    uniqueNumbers.remove(nums[start]);
                    // consider from the next starting point
                    start++;
                }

                end++;  // increase end only if the current number does not violate any condition
            }

        }

        return maxSum;
    }

    public static void main(String[] args) {
        int [] nums = {1,5,4,2,9,9,9}; //expected result 15
        //int [] nums = {1,1,1,7,8,9};  // expected result 24
        //int[] nums = { 4, 4, 4 };  // expected result 0
        int k=3;

        SlidingWindowMaximumSumDistinctSubarraySizeKLeetcode2461 ob = new SlidingWindowMaximumSumDistinctSubarraySizeKLeetcode2461();
        System.out.println(ob.maximumSubarraySum(nums, k));
    }
}

/*
 * You are given an integer array nums and an integer k. Find the maximum
 * subarray sum of all the subarrays of nums that meet the following conditions:
 * 
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the
 * conditions. If no subarray meets the conditions, return 0.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * 
 * Input: nums = [4,4,4], k = 3
 * Output: 0
 */
