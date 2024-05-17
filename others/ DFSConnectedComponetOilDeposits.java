public class DFSConnectedComponetOilDeposits {

    private int nRows, nCols;
    private boolean visited[][] = null;
    private int[] rowOffsets = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private int[] colOffsets = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public int numOilDeposits(char[][] grid) {
        nRows = grid.length;
        nCols = grid[0].length;

        int oilDeposit = 0;

        visited = new boolean[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (visited[i][j] == false && grid[i][j] == '@') {
                    oilDeposit++;

                    dfs(i, j, grid);
                }
            }
        }

        return oilDeposit;
    }

    public void dfs(int row, int col, char[][] grid) {
        int nextCol = 0, nextRow = 0;

        // set visited to true
        visited[row][col] = true;

        for (int i = 0; i < rowOffsets.length; i++) {
            nextRow = row + rowOffsets[i];
            nextCol = col + colOffsets[i];

            if (isWithinBounds(nextRow, nextCol)) {
                if (visited[nextRow][nextCol] == false && grid[nextRow][nextCol] == '@') {
                    dfs(nextRow, nextCol, grid);
                }
            }
        }

    }

    public boolean isWithinBounds(int row, int col) {
        if (row >= 0 && row < nRows && col >= 0 && col < nCols)
            return true;

        return false;
    }

    public static void main(String args[]) {
        /*
         * char[][] grid = {
         * { '*', '@', '*', '@', '*' },
         * { '*', '*', '@', '*', '*' },
         * { '*', '@', '*', '@', '*' }
         * };
         */

        /*
         * char[][] grid = {
         * { '@', '@', '*', '*', '*', '*', '@', '*' }
         * };
         */

        char[][] grid = {
                { '*', '*', '*', '*', '@' },
                { '*', '@', '@', '*', '@' },
                { '*', '@', '*', '*', '@' },
                { '@', '@', '@', '*', '@' },
                { '@', '@', '*', '*', '@' }
        };

        DFSConnectedComponetOilDeposits ob = new DFSConnectedComponetOilDeposits();
        System.out.println(ob.numOilDeposits(grid));
    }

}

/*
 * The GeoSurvComp geologic survey company is responsible for detecting
 * underground oil deposits.
 * GeoSurvComp works with one large rectangular region of land at a time, and
 * creates a grid that divides
 * the land into numerous square plots. It then analyzes each plot separately,
 * using sensing equipment to
 * determine whether or not the plot contains oil.
 * 
 * A plot containing oil is called a pocket. If two pockets are adjacent, then
 * they are part of the
 * same oil deposit. Oil deposits can be quite large and may contain numerous
 * pockets. Your job is to
 * determine how many different oil deposits are contained in a grid.
 * 
 * 
 * Input
 * Each character in the input grid corresponds to one plot, and is
 * either ‘*’, representing the absence of oil, or ‘@’, representing an oil
 * pocket.
 * 
 * 
 * Output
 * For each grid, output the number of distinct oil deposits. Two different
 * pockets are part of the same
 * oil deposit if they are adjacent horizontally, vertically, or diagonally. An
 * oil deposit will not contain
 * more than 100 pockets.
 * 
 */
