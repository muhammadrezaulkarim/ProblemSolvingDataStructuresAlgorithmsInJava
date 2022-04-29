import java.util.*;

public class DynamicPartitionMinDiffSumTwoSubset {
    public static void main(String[] args) {
       // int num[] = { 1, 6, 11, 6 }; // difference 0
        int num[] = {10, 20, 15, 5, 25}; // difference 5

       DynamicPartitionMinDiffSumTwoSubset ob = new DynamicPartitionMinDiffSumTwoSubset();
       System.out.println(ob.dynamicTwoSubsets(num));
    }

    int dynamicTwoSubsets(int[] array) {
        int total = 0;

        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }

        // minimum possible distance between two sets is 0 when both sets has same sum
        // it's enough to find subset sums upto total/2 and use those solutions to
        // come up with the final solution
        int targetSum = total / 2;
        int n = array.length;

        boolean[][] solutionExists = new boolean[n + 1][targetSum + 1];

        // solutionExists[i][j] indicates whether sum j can be attained
        // using items up to first `i` items in the array

        int i = 0, j = 0;

        // for sum=0, there is always a subset possible (the empty set)
        for (i = 0; i <= n; i++)
            solutionExists[i][0] = true;
            
        // If sum is not 0 and set of numbers is empty,
        // then answer is false
        for (i = 0; i <= targetSum; i++)
           solutionExists[0][i] = false;

        // i represents the number of elements of array considered
        for (i = 1; i <= n; i++) {
            // j represents the sum of subset being searched for
            for (j = 1; j <= targetSum; j++) {

                // if value of i'th item is greater than the required sum
                // this element cannot be considered
                if (array[i - 1] > j)
                    solutionExists[i][j] = solutionExists[i - 1][j];
                else
                    // find the subset with sum `j` by excluding or including
                    // the i'th item
                    solutionExists[i][j] = solutionExists[i - 1][j] || solutionExists[i - 1][j - array[i - 1]];

            }
        }

        // starting from targetSum go downward to return minimum sum distance
        // consider the sum for which we had solution
        for(int k=targetSum; k >=0; k--) {
          if(solutionExists[n][k] == true)
            return Math.abs((sum-k)-k) ;  // k is the sum of one partition, (sum-k) is the sum of the other partition
        }
      
        // if no solution found, return -1
         return -1;
    }

}

/* Given a set of positive integers S, partition set S into two subsets, S1 and S2, such that the difference between the sum of elements in S1 and S2 is minimized. The solution should return the minimum absolute difference between the sum of elements of two partitions.

For example, consider S = {10, 20, 15, 5, 25}.

 
We can partition S into two partitions where the minimum absolute difference between the sum of elements is 5.

S1 = {10, 20, 5}
S2 = {15, 25}

Note that this solution is not unique. The following is another solution:

S1 = {10, 25}
S2 = {20, 15, 5}  

The minimum difference is 5

The time complexity of the above bottom-up solution is O(n × sum) and requires O(n × sum) extra space,
where n is the size of the input and sum is the sum of all elements in the input.

*/
