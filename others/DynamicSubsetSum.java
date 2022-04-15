import java.util.*;

public class DynamicSumOfSubset {
    public static void main(String[] args) {
        int target = 22;
        // int num[] = {1, 6, 11, 6}; // true

        int num[] = { 2, 5, 8, 6, 8, 1 }; // true

        // int num[] = {2, 6, 7}; //false

        DynamicSumOfSubset ob = new DynamicSumOfSubset();
        System.out.println(ob.sumOfSubset(num, target));
    }

    boolean sumOfSubset(int[] num, int targetSum) {

        // flag indicating the results
        boolean[][] sumPossible = new boolean[num.length][targetSum + 1];

        // sumPossible[i][j] denotes whether sum j is possible
        // with items upto i

        for (int i = 0; i < num.length; i++) {
            for (int sum = 0; sum <= targetSum; sum++) {
                // num[i] can included in the sum as it is bigger than the sum
                if (num[i] <= sum) {

                    if (sum == num[i]) {
                        sumPossible[i][sum] = true; // by default the flag is false
                    }

                    if (i > 0) // perform or operation
                        sumPossible[i][sum] = sumPossible[i][sum] || sumPossible[i - 1][sum - num[i]];
                } else // num[i] cannot be included in the sum as it is bigger
                {
                    if (i > 0)
                        sumPossible[i][sum] = sumPossible[i - 1][sum];
                }
            }
        }

        return sumPossible[num.length - 1][targetSum];
    }

}
