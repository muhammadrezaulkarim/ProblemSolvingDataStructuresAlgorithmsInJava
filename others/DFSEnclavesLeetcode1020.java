class DFSEnclavesLeetcode1020 {
    int nRows, nCols;
    boolean[][] visited;

    public int numEnclaves(int[][] grid) {
        nRows = grid.length;
        nCols = grid[0].length;

        visited = new boolean[nRows][nCols];

        // call dfs from boundary cells only
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                if ((row == 0 || row == nRows - 1 || col == 0 || col == nCols - 1) && !visited[row][col]
                        && grid[row][col] == 1)
                    dfs(row, col, grid);
            }
        }

        int count = 0;

        // count the remaining 1's not reachable from boundary cells
        for (int row = 0; row < nRows; row++)
            for (int col = 0; col < nCols; col++)
                if (!visited[row][col] && grid[row][col] == 1)
                    count++;

        return count;
    }

    public void dfs(int row, int col, int[][] grid) {
        visited[row][col] = true;

        int[] rowOffsets = { 0, 0, -1, 1 };
        int[] colOffsets = { -1, 1, 0, 0 };

        for (int i = 0; i < rowOffsets.length; i++) {
            int nextRow = row + rowOffsets[i];
            int nextCol = col + colOffsets[i];

            if (nextRow >= 0 && nextRow < nRows && nextCol >= 0 && nextCol < nCols
                    && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol])
                dfs(nextRow, nextCol, grid);
        }

    }

    public static void main(String[] args) {
        int[][] grid = {
            { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };

        DFSEnclavesLeetcode1020 ob = new DFSEnclavesLeetcode1020();
        System.out.println(ob.numEnclaves(grid));
    }
}

/*
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and
 * 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent
 * (4-directionally) land cell or walking off the boundary of the grid.
 * 
 * Return the number of land cells in grid for which we cannot walk off the
 * boundary of the grid in any number
 * of moves.
 * 
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s,
 * and one 1 that is not enclosed because its on the boundary.
 * 
 * Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation: All 1s are either on the boundary or can reach the boundary.
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] is either 0 or 1.
 * 
 * 
 */
