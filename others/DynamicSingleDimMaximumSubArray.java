import java.util.Arrays;

public class DynamicSingleDimMaximumSubArray {

    // bottom up approach
    public int solve(int[] a) {
        int[] solution = new int[a.length];
        solution[0] = a[0];

        for (int j = 1; j < solution.length; j++) {
            solution[j] = Math.max(solution[j - 1] + a[j], a[j]);
        }

        // this will print the solution matrix
        // System.out.println(Arrays.toString(solution));
        // now return the maximum in the solution array
        int result = solution[0];
        for (int j = 1; j < solution.length; j++) {
            if (solution[j] > result)
                result = solution[j];
        }

        return result;
    }

    public static void main(String[] args) {
        int array[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        DynamicSingleDimMaximumSubArray ob = new DynamicSingleDimMaximumSubArray();
        System.out.println("Maximum subarray is  " + ob.solve(array));
    }
}

/*
 * Objective: The maximum subarray problem is the task of finding the contiguous
 * subarray within
 * a one-dimensional array of numbers which has the largest sum.
 * Example:
 * int [] A = {−2, 1, −3, 4, −1, 2, 1, −5, 4};
 * Output: contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
 * The problem will be solved in bottom-up manner.
 * let’s say
 * “MS(i) is maximum sum ending at index i”
 * Recursive Solution:
 * MS(i) = Max[MS(i-1) + A[i] , A[i]]
 * To calculate the solution for any element at index “i” has two options:
 * 1. added to the solution found till “i-1“th index
 * OR
 * 2. start a new sum from the index “i“.
 */
