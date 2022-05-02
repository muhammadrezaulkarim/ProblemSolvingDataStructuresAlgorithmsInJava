class DFSIslandsLeetcode200 {
    int islandCount = 0;
    boolean[][] visited;
    int nRows;
    int nCols;

    public int numIslands(char[][] grid) {
        nRows = grid.length;
        nCols = grid[0].length;

        visited = new boolean[nRows][nCols];

        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    islandCount++;
                    dfs(row, col, grid);
                }
            }
        }

        return islandCount;
    }

    public void dfs(int row, int col, char[][] grid) {
        visited[row][col] = true;

        int[] rowOffsets = { 0, 0, -1, 1 };
        int[] colOffsets = { -1, 1, 0, 0 };

        for (int i = 0; i < rowOffsets.length; i++) {
            int nextRow = row + rowOffsets[i];
            int nextCol = col + colOffsets[i];

            if (nextRow >= 0 && nextRow < nRows
                    && nextCol >= 0 && nextCol < nCols
                    && grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) {
                dfs(nextRow, nextCol, grid);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        DFSIslandsLeetcode200 ob = new DFSIslandsLeetcode200();
        System.out.println(ob.numIslands(grid));
    }
}

/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * 
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * 
 */
