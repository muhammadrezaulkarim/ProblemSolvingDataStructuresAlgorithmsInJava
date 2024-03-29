class PartitionDisjointIntervalLeetcode915 {
  
  public int partitionDisjoint(int[] nums) {
    int [] minRight = new int[nums.length];

    // compute minimum upto each index starting from the end
    minRight[nums.length - 1] = nums[nums.length - 1];

    for (int i = nums.length - 2; i >= 0; i--) {
      minRight[i] = Math.min(minRight[i + 1], nums[i]);
    }

    int index = 0;

    int maxLeft = nums[0];
    for (int i = 0; i < nums.length - 1; i++) {
      // compute max upto this index from the left
      maxLeft = Math.max(maxLeft, nums[i]);

      if (maxLeft <= minRight[i + 1]) {
        index = i;
        break;
      }
    }

    return index + 1;
  }

  public static void main(String[] args) {
    int[] nums = { 5, 0, 3, 8, 6 };
    // int[] nums = { 1, 1, 1, 0, 6, 12 };
    // int[] nums = {6,0,8,30,37,6,75,98,39,90,63,74,52,92,64};

    PartitionDisjointIntervalLeetcode915 ob = new PartitionDisjointIntervalLeetcode915();
    System.out.println(ob.partitionDisjoint(nums));
  }
}
/*
 * 
 * Given an integer array nums, partition it into two (contiguous) subarrays
 * left and right so that:
 * 
 * Every element in left is less than or equal to every element in right.
 * left and right are non-empty.
 * left has the smallest possible size.
 * Return the length of left after such a partitioning.
 * 
 * Test cases are generated such that partitioning exists.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [5,0,3,8,6]
 * Output: 3
 * Explanation: left = [5,0,3], right = [8,6]
 * Example 2:
 * 
 * Input: nums = [1,1,1,0,6,12]
 * Output: 4
 * Explanation: left = [1,1,1,0], right = [6,12]
 * 
 * 
 * Input: nums = [6,0,8,30,37,6,75,98,39,90,63,74,52,92,64]
 * Output: 2
 * 
 * 
 * Constraints:
 * 2 <= nums.length <= 105
 * 0 <= nums[i] <= 106
 * There is at least one valid answer for the given input.
 * 
 */
