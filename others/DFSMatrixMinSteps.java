import java.util.*;

public class DFSMatrixMinSteps {

    boolean flag[][] = null;
    int n_row = 0;
    int n_col = 0;

    // StringBuilder sb=new StringBuilder();

    // sample input 1
    // String [] inputArray = {"11000","01100","00501","10001","01011"};

    // sample input 2
    // String [] inputArray = {"11000","11100","51001","10001","01011"};

    // sample input 3
    String[] inputArray = { "11000", "11100", "11151", "10001", "01011" };

    Queue<Node> queue = new LinkedList<Node>();

    public void run() {

        n_row = inputArray.length;
        n_col = inputArray[0].length();

        flag = new boolean[n_row][n_col];

        // initilize the visit flag

        for (int i = 0; i < n_row; i++)
            for (int j = 0; j < n_row; j++)
                flag[i][j] = false;

        // enable these two lines for BFS search
        Node root = new Node(0, 0, 0);
        int minSteps = BFS(root);

        // int minSteps = DFS(0, 0, 0, Integer.MAX_VALUE);
        System.out.println("Minimum Steps: " + minSteps);
    }

    public int DFS(int row, int col, int depth, int minSteps) {

        flag[row][col] = true;

        if (inputArray[row].charAt(col) == '5') {
            if (depth < minSteps) {
                minSteps = depth;
                // make the cell containing '5' false
                // so that it can be visited from other nodes again
                // not part of normal DFS search
                // special tweek for this search problem

                flag[row][col] = false;
                return minSteps;
            }

        }

        int[] addRow = { -1, 1, 0, 0 };
        int[] addCol = { 0, 0, -1, 1 };

        // find adjacent cells including the destination cell containg '5'
        for (int i = 0; i < addRow.length; i++) {
            int nextRow = row + addRow[i];
            int nextCol = col + addCol[i];

            if (nextRow >= 0 && nextRow < n_row && nextCol >= 0 && nextCol < n_col) {
                // destination cell '5' is considered as adjacent cell as well
                if ((inputArray[nextRow].charAt(nextCol) == '1' || inputArray[nextRow].charAt(nextCol) == '5')
                        && !flag[nextRow][nextCol]) {
                    int steps = DFS(nextRow, nextCol, depth + 1, minSteps);

                    if (steps < minSteps)
                        minSteps = steps;
                }
            }

        }

        // for graph search, the same node can be reached from
        // different parent nodes. so for DFS set it to false so that
        // it can be reached from different parent nodes
        flag[row][col] = false;

        return minSteps;

    }

    public int BFS(Node root) {
        int minSteps = Integer.MAX_VALUE;

        queue.add(root);
        flag[root.row][root.col] = true;

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (inputArray[node.row].charAt(node.col) == '5') {
                if (node.level < minSteps) {
                    minSteps = node.level;
                    // make the cell containing '5' false
                    // so that it can be visited from other nodes again
                    // not part of normal DFS search
                    // special tweek for this search problem
                    flag[node.row][node.col] = false;

                }

            }

            int[] addRow = { -1, 1, 0, 0 };
            int[] addCol = { 0, 0, -1, 1 };

            // find adjacent
            for (int i = 0; i < addRow.length; i++) {
                int nextRow = node.row + addRow[i];
                int nextCol = node.col + addCol[i];

                if (nextRow >= 0 && nextRow < n_row && nextCol >= 0 && nextCol < n_col) {
                    // destination cell '5' is considered as adjacent cell as well
                    // otherwise we cannot inspect it
                    if (inputArray[nextRow].charAt(nextCol) == '1' || inputArray[nextRow].charAt(nextCol) == '5') {
                        if (!flag[nextRow][nextCol]) // if not visited
                        {
                            Node child = new Node(nextRow, nextCol, node.level + 1);
                            flag[node.row][node.col] = true;
                            queue.add(child);
                        }
                    }
                }

            }

        }

        return minSteps;

    }

    public static void main(String args[]) {
        DFSMatrixMinSteps ob = new DFSMatrixMinSteps();
        ob.run();
    }

    class Node {
        int row;
        int col;
        int level;

        public Node(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
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
