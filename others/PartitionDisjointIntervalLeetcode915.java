class PartitionDisjointIntervalLeetcode915 {
    public int partitionDisjoint(int[] nums) {
        int[] minRight = new int[nums.length];

        minRight[nums.length - 1] = nums[nums.length - 1];
        // compute minimum upto each index starting from the end
        // minRight[j] holds minimum of the values from minRight[j,j+1,j+2,...n]
        for (int i = nums.length - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        int[] maxLeft = new int[nums.length];
        maxLeft[0] = nums[0];
        // compute max upto each index from the left
        // maxLeft[j] holds maximum of the values from maxRight[0,1,...j]
        for (int i = 1; i < nums.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        int index = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // Comparing maxLeft[i] with minRight[i + 1] is enough to
            // ensure that every element in left partition is less than or equal to every
            // element in right partition

            // please note we compare index with index i+1 as we partition the array
            if (maxLeft[i] <= minRight[i + 1]) {
                index = i;
                break;
            }
        }

        return index + 1;
    }

    public static void main(String[] args) {
        // int[] nums = { 5, 0, 3, 8, 6 };
        // int[] nums = { 1, 1, 1, 0, 6, 12 };
        int[] nums = { 6, 0, 8, 30, 37, 6, 75, 98, 39, 90, 63, 74, 52, 92, 64 };

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
