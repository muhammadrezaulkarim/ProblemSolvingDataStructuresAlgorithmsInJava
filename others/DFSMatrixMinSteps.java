import java.util.*;

public class DFSMatrixMinSteps {
    int nRows, nCols, destRow, destCol;
    int[][] minEffort;

    public int minimumEffortPath(String[] inputArray) {
        nRows = inputArray.length;
        nCols = inputArray[0].length();

        minEffort = new int[nRows][nCols];

        // effort needed to reach from [0,0] to current cell
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                minEffort[i][j] = Integer.MAX_VALUE;

                if (inputArray[i].charAt(j) == '5') {
                    destRow = i;
                    destCol = j;
                }
            }
        }

        minEffort[0][0] = 0; // set for start cell

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            System.out.println("current node. row:" + node.row + " col:" + node.col);

            int[] rowOffsets = { 0, 0, -1, 1 };
            int[] colOffsets = { -1, 1, 0, 0 };

            for (int i = 0; i < rowOffsets.length; i++) {
                int nextRow = node.row + rowOffsets[i];
                int nextCol = node.col + colOffsets[i];

                if (isWithinBounds(nextRow, nextCol)
                        && (inputArray[nextRow].charAt(nextCol) == '1' || inputArray[nextRow].charAt(nextCol) == '5')) {
                    int currentCellEffort = minEffort[node.row][node.col] + 1;

                    // we found better path (path that takes less effort)
                    // helps to prune the search space
                    if (currentCellEffort < minEffort[nextRow][nextCol]) {
                        minEffort[nextRow][nextCol] = currentCellEffort;
                        System.out.println("added node. row:" + nextRow + " col:" + nextCol);
                        queue.add(new Node(nextRow, nextCol));
                    }

                }

            }
        }

        return minEffort[destRow][destCol];
    }

    public boolean isWithinBounds(int row, int col) {
        if (row >= 0 && row < nRows && col >= 0 && col < nCols)
            return true;

        return false;

    }

    public static void main(String args[]) {
        // sample input 1
        String[] inputArray = { "11000", "01100", "00501", "10001", "01011" };

        // sample input 2
        // String [] inputArray = {"11000","11100","51001","10001","01011"};

        // sample input 3
        // String [] inputArray = {"11000","11100","11151","10001","01011"};

        DFSMatrixMinSteps ob = new DFSMatrixMinSteps();
        System.out.println(ob.minimumEffortPath(inputArray));
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
 * 
 * Consider a two-dimensional grid of cells, each of which may be reachable
 * or not reachable from a particular cell. Your job is to find the minimum
 * steps needed to reach a destination cell (marked as 5) on the grid
 * starting from top left position in the grid. In general, from a grid position
 * you can move either left, right,top,bottom position.
 * However, some cells are nor reachable from a cell (marked as 0). Reachable
 * cells are marked as 1.
 * Input
 * The grid is given as a set of strings, each composed of 0’s and 1’s. The ‘1’
 * indicates that the cell is
 * reachable and ‘0’ indicates the cell is not reachable. The strings should be
 * converted into the grid format.
 * The largest grid that should be considered is a 25×25 grid.
 * Output
 * The output is the minimum number of steps required to reach the destination
 * cell.
 * Output
 * The output is the minimum steps required to reach the destination cell
 * Sample Input 1
 * 11000
 * 01100
 * 00501
 * 10001
 * 01011
 * Sample Output 1
 * 4
 * Sample Input 2
 * 11000
 * 11100
 * 51001
 * 10001
 * 01011
 * Sample Output 2
 * 2
 * Sample Input 3
 * 11000
 * 11100
 * 11151
 * 10001
 * 01011
 * Sample Output 3
 * 5
 */
