class DFSMinPathLeetcode1631 {
    int nRows, nCols;
    boolean[][] visited;
    int minEffort;

    public int minimumEffortPath(int[][] heights) {
        nRows = heights.length;
        nCols = heights[0].length;

        visited = new boolean[nRows][nCols];

        minEffort = Integer.MAX_VALUE;

        dfs(0, 0, heights, heights[0][0], Integer.MIN_VALUE);

        return minEffort;
    }

    public void dfs(int row, int col, int[][] heights, int prevHeight, int maxHeightDiff) {

        visited[row][col] = true;

        int currentHeightDiff = Math.abs(prevHeight - heights[row][col]);

        if (currentHeightDiff > maxHeightDiff)
            maxHeightDiff = currentHeightDiff;

        if (row == nRows - 1 && col == nCols - 1) {
            if (maxHeightDiff < minEffort)
                minEffort = maxHeightDiff;

            visited[row][col] = false;

            return;
        }

        int[] rowOffsets = { 0, 0, -1, 1 };
        int[] colOffsets = { -1, 1, 0, 0 };

        for (int i = 0; i < rowOffsets.length; i++) {
            int nextRow = row + rowOffsets[i];
            int nextCol = col + colOffsets[i];

            if (isWithinBounds(nextRow, nextCol) && !visited[nextRow][nextCol])
                dfs(nextRow, nextCol, heights, heights[row][col], maxHeightDiff);

        }

        visited[row][col] = false;
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
         * int[][] grid = {
         * {1,2,3},{3,8,4},{5,3,5}};
         */

        int[][] grid = {
                { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };

        DFSMinPathLeetcode1631 ob = new DFSMinPathLeetcode1631();
        System.out.println(ob.minimumEffortPath(grid));
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
