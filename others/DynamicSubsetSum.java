//There is a subset A of n positive integers and a value sum. 
//Find whether or not there exists any subset of the given set, 
//the sum of whose elements is equal to the given value of sum

public class DynamicSubsetSum {
    public static boolean[][] solutionExists = null;

    public static void main(String[] args) {
        int array[] = { 92, 40, 63, 51, 36, 41, 41, 42 };
        int targetSum = 154;

        DynamicSubsetSum ob = new DynamicSubsetSum();
        System.out.println(ob.subsetSum(array, targetSum));
    }

    boolean subsetSum(int array[], int targetSum) {
        int n = array.length;

        solutionExists = new boolean[n + 1][targetSum + 1];

        // solutionExists[i][j] indicates whether sum j can be attained
        // using items up to first `i` items in the array

        int i = 0, j = 0;

        // for sum=0, there is always a subset possible (the empty set)
        for (i = 0; i <= n; i++)
            solutionExists[i][0] = true;

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

        // return the overall result
        return solutionExists[n][targetSum];
    }

}
