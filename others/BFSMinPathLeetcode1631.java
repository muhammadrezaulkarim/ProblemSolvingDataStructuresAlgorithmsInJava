import java.util.Queue;
import java.util.LinkedList;

class BFSMinPathLeetcode1631 {
    int nRows, nCols;
    int[][] minEffort;

    public int minimumEffortPath(int[][] heights) {
        nRows = heights.length;
        nCols = heights[0].length;

        minEffort = new int[nRows][nCols];

        // effort needed to reach from [0,0] to current cell
        for (int i = 0; i < nRows; i++)
            for (int j = 0; j < nCols; j++)
                minEffort[i][j] = Integer.MAX_VALUE;

        minEffort[0][0] = 0; // set for start cell

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            int[] rowOffsets = { 0, 0, -1, 1 };
            int[] colOffsets = { -1, 1, 0, 0 };

            for (int i = 0; i < rowOffsets.length; i++) {
                int nextRow = node.row + rowOffsets[i];
                int nextCol = node.col + colOffsets[i];

                if (isWithinBounds(nextRow, nextCol)) {
                    int currentCellHeightDiff = Math.abs(heights[node.row][node.col] - heights[nextRow][nextCol]);
                    // maximum of effort needed to reach from [0,0] to current cell
                    // or effort needed to climb to next cell
                    int currentCellEffort = Math.max(minEffort[node.row][node.col], currentCellHeightDiff);

                    // we found better path (path that takes less effort)
                    // helps to prune the search space
                    if (currentCellEffort < minEffort[nextRow][nextCol]) {
                        minEffort[nextRow][nextCol] = currentCellEffort;
                        queue.add(new Node(nextRow, nextCol));
                    }

                }

            }

        }

        return minEffort[nRows - 1][nCols - 1];
    }

    public boolean isWithinBounds(int row, int col) {
        if (row >= 0 && row < nRows && col >= 0 && col < nCols)
            return true;

        return false;

    }

    public static void main(String[] args) {

        /*
         * int[][] grid = {
         * {4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9}
         * ,{6,4,10,6,10,9,4,6} };
         * 
         * /* int[][] grid = {
         * {1,2,3},{3,8,4},{5,3,5}};
         * 
         * 
         * int[][] grid = {
         * { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
         */

        int[][] grid = {
                { 1, 10, 6, 7, 9, 10, 4, 9 } };

        BFSMinPathLeetcode1631 ob = new BFSMinPathLeetcode1631();
        System.out.println(ob.minimumEffortPath(grid));
    }

    private class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

/*
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D
 * array of size rows x columns, where heights[row][col] represents the height
 * of cell (row, col). You are situated in the top-left cell, (0, 0), and you
 * hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,
 * 0-indexed). You can move up, down, left, or right, and you wish to find a
 * route that requires the minimum effort.
 * 
 * A route's effort is the maximum absolute difference in heights between two
 * consecutive cells of the route.
 * 
 * Return the minimum effort required to travel from the top-left cell to the
 * bottom-right cell.
 * 
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2
 * in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute
 * difference is 3.
 * 
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1
 * in consecutive cells, which is better than route [1,3,5,3,5].
 * 
 * 
 * 
 */
