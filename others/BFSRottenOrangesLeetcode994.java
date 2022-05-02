import java.util.*;

public class BFSRottenOrangesLeetcode994 {
    int nRows, nCols;
    int[][] minRottenTime;
    Queue<Node> queue = new LinkedList<Node>();

    public int orangesRotting(int[][] grid) {
        nRows = grid.length;
        nCols = grid[0].length;

        minRottenTime = new int[nRows][nCols];

        // keeps track of rotten time for each fresh orange
        for (int row = 0; row < nRows; row++)
            for (int col = 0; col < nCols; col++)
                minRottenTime[row][col] = Integer.MAX_VALUE;

        for (int row = 0; row < nRows; row++)
            for (int col = 0; col < nCols; col++)
                if (grid[row][col] == 2) // initiate breath first traversal for each rotten orange
                    bfs(row, col, grid);

        int maximumRottingTime = 0;

        for (int row = 0; row < nRows; row++)
            for (int col = 0; col < nCols; col++)
                if (grid[row][col] == 1) // check the rotten time for each fresh orange
                    maximumRottingTime = Math.max(minRottenTime[row][col], maximumRottingTime);

        return maximumRottingTime == Integer.MAX_VALUE ? -1 : maximumRottingTime;
    }

    public void bfs(int row, int col, int[][] grid) {
        queue.clear();

        queue.add(new Node(row, col));
        minRottenTime[row][col] = 0;

        while (!queue.isEmpty()) {

            Node node = queue.remove();

            int[] rowOffsets = { 0, 0, -1, 1 };
            int[] colOffsets = { -1, 1, 0, 0 };

            for (int i = 0; i < rowOffsets.length; i++) {
                int nextRow = node.row + rowOffsets[i];
                int nextCol = node.col + colOffsets[i];

                if (isWithinBounds(nextRow, nextCol) && grid[nextRow][nextCol] == 1) // only fresh oranges considered
                {
                    int currentMin = minRottenTime[node.row][node.col] + 1;

                    // update if better solution found
                    // prune the search space. We traverse through this path only if better solution
                    // found
                    if (currentMin < minRottenTime[nextRow][nextCol]) {
                        minRottenTime[nextRow][nextCol] = currentMin;
                        queue.add(new Node(nextRow, nextCol));
                    }

                }
            }
        }

    }

    public boolean isWithinBounds(int row, int col) {
        if (row >= 0 && row < nRows && col >= 0 && col < nCols)
            return true;

        return false;

    }

    private class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String args[]) {
        // sample input 1
        int[][] inputArray = {
                { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        BFSRottenOrangesLeetcode994 ob = new BFSRottenOrangesLeetcode994();
        System.out.println(ob.orangesRotting(inputArray));
    }

}

/*
 * 
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange.
 * If this is impossible, return -1.
 * 
 * Example 1:
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * 
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never
 * rotten,
 * because rotting only happens 4-directionally.
 * Example 3:
 * 
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer
 * is just 0.
 * 
 * 
 * Basically, the idea of my solution is to iterate over the input and for each
 * rotten orange,
 * search outwards using Breadth-First-Search to find all fresh oranges and
 * update their minRottenTime value
 * if the current distance is less than the already computed distance.
 * 
 * An important part of this solution is to make sure to check whether or not an
 * already computed distance is
 * less than the current distance before adding it to the search queue. This is
 * because if the already computed
 * distance is less than the current distance then it's impossible the current
 * path will lead
 * to a lower number of days to rott that given orange.
 * 
 * If you do not include the above step, then your solution will probably Exceed
 * the Time Limit as
 * you will do a lot of extra computation.
 * 
 * The last thing to mention, is that if any fresh orange can not be reached by
 * a rotten orange, then the
 * minRottenTime for that orange will be null. In this case, you must return -1
 * as the prompt states.
 * 
 * Time Complexity - O((M * N))
 * Space Complexity - O(M * N)
 */
