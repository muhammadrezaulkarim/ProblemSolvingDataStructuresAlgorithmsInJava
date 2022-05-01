class PartitionDisjointIntervalLintcode31 {
  public int partitionDisjoint(int[] nums, int k) {

    if (nums.length == 0)
      return 0;

    int leftPtr = 0;
    int rightPtr = nums.length - 1;

    while (leftPtr < rightPtr) {
      while (leftPtr < nums.length && nums[leftPtr] < k)
        leftPtr++;

      while (rightPtr >= 0 && nums[rightPtr] >= k)
        rightPtr--;

      if (leftPtr < rightPtr && leftPtr < nums.length && rightPtr >= 0)
        swap(nums, leftPtr, rightPtr);
    }

    return leftPtr;
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    // int[] nums = { };
    // int[] nums = { 1, 1, 1};
    int[] nums = { 3, 2, 2, 1 };
    int k = 2;

    PartitionDisjointIntervalLintcode31 ob = new PartitionDisjointIntervalLintcode31();
    System.out.println(ob.partitionDisjoint(nums, k));
  }
}

/*
 * 
 * Given an integer array nums, partition it into two (contiguous) subarrays
 * left and right so that:
 * 
 * Description
 * Given an array nums of integers and an int k, partition the array (i.e move
 * the elements in "nums") such that:
 * 
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 * 
 * If all elements in nums are smaller than k, then return nums.length
 * 0 <= nums.length <= 20000<=nums.length<=2000
 * 
 * Example
 * Example 1:
 * 
 * Input:
 * 
 * nums = []
 * k = 9
 * Output:
 * 
 * 0
 * Explanation:
 * 
 * Empty array, print 0.
 * 
 * Example 2:
 * 
 * Input:
 * 
 * nums = [3,2,2,1]
 * k = 2
 * Output:
 * 
 * 1
 * Explanation:
 * 
 * the real array is[1,2,2,3].So return 1.
 * 
 * Challenge
 * Can you partition the array in-place and in O(n)O(n)?
 * 
 */
