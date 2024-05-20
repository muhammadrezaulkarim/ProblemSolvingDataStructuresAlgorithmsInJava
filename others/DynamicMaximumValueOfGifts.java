
public class DynamicMaximumValueOfGifts {

    public static void main(String[] args) {
        double[][] giftValues = {
                { 1, 10, 3, 8 },
                { 12, 2, 9, 6 },
                { 5, 7, 4, 11 },
                { 3, 7, 16, 5 }
        };

        DynamicMaximumValueOfGifts ob = new DynamicMaximumValueOfGifts();
        System.out.println(ob.maxValueGifts(giftValues));
    }

    public double maxValueGifts(double[][] gifts) {
        int m = gifts.length;
        int n = gifts[0].length;

        // array to store results
        double solution[][] = new double[m][n];

        // solution[i][j] = maximum attainable value of gifts for the matrix of rows i
        // and columns j only

        // Initialize the gift value for the first column in different rows
        for (int i = 0; i < m; i++) {
            if (i == 0)
                solution[i][0] = gifts[i][0];
            else
                solution[i][0] = solution[i - 1][0] + gifts[i][0]; // we can reach from the rows above, same column
        }

        // Initialize the gift value for the first row in different columns
        for (int j = 0; j < n; j++) {
            if (j == 0)
                solution[0][j] = gifts[0][j];
            else
                solution[0][j] = solution[0][j - 1] + gifts[0][j]; // we can reach from the columns on the left, same
                                                                   // column
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // There are two ways to reach colums (i,j)
                // one from above and one from left, pick the one which gives more value
                solution[i][j] = Math.max(solution[i][j - 1], solution[i - 1][j]) + gifts[i][j];
            }

        }

        return solution[m - 1][n - 1];
    }

}
/*
 * Fill the solution matrix from the top row one by one
 */

/*
 * 
 * 
 * You are given a matrix of order N*M. Each cell of the matrix has a gift of
 * certain value.
 * Starting from the top-left cell, you have to reach the bottom-right cell of
 * the matrix collecting gifts of the visited cells.
 * But you can visit either the cell below the current cell or the cell to right
 * of current cell.
 * Determine the maximum value of gifts you can collect.
 * 
 * 
 * Input:
 * 
 * 1 10 3 8
 * 12 2 9 6
 * 5 7 4 11
 * 3 7 16 5
 * 
 * Output:
 * maximum attainable value of gifts
 * 53
 * 
 */
