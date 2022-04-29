
import java.io.*;
import java.util.*;


class PartitionEqualSumKSubsets {

  public boolean canPartition(int [] array, int k)
  {
    int sum = 0;

    for(int i=0; i< array.length; i++) {
      sum += array[i];
    }

    if (sum % k !=0)
      return false;


    int [] partition = new int[k];

    return kPartition(array, partition, sum/k, 0);

  }

  public boolean kPartition(int [] array, int [] partition, int target, int index) {

    // we have assigned all numbers to one partition
    if(index == array.length)
    {
        for(int i=0; i < partition.length; i++)
          if (partition[i] != target)
            return false;

        return true;
    }

    for(int i=0; i < partition.length; i++)
    {
      // we do not assign a number to a partition
      // if the partition sum exceeds the target
      if(partition[i] + array[index] > target)
        continue;

      partition[i] += array[index];

      //Call again to assign the next number. If solution found, return
      if(kPartition(array, partition, target, index + 1))
        return true;
      else
        // solution not found, backtrack and try to assign to another partition
         partition[i] -= array[index]; 
    }

    return false;
  }

  public static void main(String[] args) {
    int [] array = {4, 3, 2, 3, 5, 2, 1};
    int k = 4; 

    /*int [] array = {1, 2, 3, 4};
    int k = 3; */

    PartitionEqualSumKSubsets ob = new PartitionEqualSumKSubsets();
    System.out.println(ob.canPartition(array, k));
  }
}

/* Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 
Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false

*/
