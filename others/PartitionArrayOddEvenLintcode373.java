class PartitionArrayOddEvenLintcode373 {
  /**
   * @param nums: an array of integers
   * @return: nothing
   */
  public void partitionArray(int[] nums) {
    // write your code here

    int leftPointer = nums[0];
    int rightPointer = nums.length - 1;

    while (leftPointer < rightPointer) {
      while (leftPointer < nums.length && nums[leftPointer] % 2 != 0)
        leftPointer++;

      while (rightPointer >= 0 && nums[rightPointer] % 2 == 0)
        rightPointer--;

      if (leftPointer < rightPointer && leftPointer < nums.length && rightPointer >= 0)
        swap(nums, leftPointer, rightPointer);
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    // int[] nums = { 1,2,3,4 };
    int[] nums = { 1, 4, 2, 3, 5, 6 };

    PartitionArrayOddEvenLintcode373 ob = new PartitionArrayOddEvenLintcode373();
    ob.partitionArray(nums);

    for (int i = 0; i < nums.length; i++)
      System.out.print(nums[i] + " ");
  }
}

/*
 * Partition an integers array into odd number first and even number second.
 * 
 * The answer is not unique. All you have to do is give a vaild answer.
 * 
 * Example
 * Example 1:
 * 
 * Input: [1,2,3,4]
 * Output: [1,3,2,4]
 * Example 2:
 * 
 * Input: [1,4,2,3,5,6]
 * Output: [1,3,5,4,2,6]
 * Challenge
 * Do it in-place.
 * 
 */
