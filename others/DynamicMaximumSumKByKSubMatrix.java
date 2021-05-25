
public class DynamicMaximumSumKByKSubMatrix  
{
	int resultRowCordinate =0;
	int  resultColCordinate =0;
	
    public static void main(String[] args) 
    {
        
        DynamicMaximumSumKByKSubMatrix  ob = new DynamicMaximumSumKByKSubMatrix();
        ob.solve();
    }


// function to find maximum sum p x q sub-matrix
	public void maximumSumSubMatrix(int matrix[][], int P, int Q)
	{
		// M x N matrix
		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		// pre-process the input matrix such that sum[i][j] stores
		// sum of elements in matrix from (0, 0) to (i, j)
		int[][] cumulativeSum = new int[rowCount][colCount];
		cumulativeSum[0][0] = matrix[0][0];

		// pre-process first row
		for (int j = 1; j < colCount; j++) {
			cumulativeSum[0][j] = matrix[0][j] + cumulativeSum[0][j - 1];
		}

		// pre-process first column
		for (int i = 1; i < rowCount; i++) {
			cumulativeSum[i][0] = matrix[i][0] + cumulativeSum[i - 1][0];
		}

		// pre-process rest of the matrix
		for (int i = 1; i < rowCount; i++) {
			for (int j = 1; j < colCount; j++) {
				cumulativeSum[i][j] = matrix[i][j] + cumulativeSum[i - 1][j] + cumulativeSum[i][j - 1] - cumulativeSum[i - 1][j - 1];
			}
		}

		int maxSum, max = Integer.MIN_VALUE;
	

		// find maximum sum sub-matrix

		// start from cell (p- 1, q - 1) and consider each
		// submatrix of size p x q
		for (int i = P - 1; i < rowCount; i++)
		{
			for (int j = Q - 1; j < colCount; j++)
			{
				// Note (i, j) is bottom right corner coordinates of
				// square sub-matrix of size k

				maxSum = cumulativeSum[i][j];
				
				if (i - P >= 0) 
				{
					 maxSum -=  cumulativeSum[i - P][j];
				}

				if (j - Q >= 0) 
				{
					 maxSum -= cumulativeSum[i][j - Q];
				}

				if (i - P >= 0 && j -Q >= 0) 
				{
					 maxSum += cumulativeSum[i - P][j - Q];
				}

				if ( maxSum > max) 
				{
					max = maxSum;
	
					// set coordinates of bottom right corner of sub-matrix
					resultRowCordinate = i;
					resultColCordinate = j;
				}
			}
		}

		
	}

	public void solve()
	{
		// 5 x 5 matrix
		int[][] matrix =
		{
			{ 3, -4, 6, -5, 1 },
			{ 1, -2, 8, -4, -2 },
			{ 3, -8, 9, 3, 1 },
			{ -7, 3, 4, 2, 7 },
			{ -3, 7, -5, 7, -6 }
		};

		// sub-matrix size p by q
		int P = 3, Q = 2;


		 maximumSumSubMatrix(matrix, P, Q);

		// print maximum sum sub-matrix
		for (int i = 0; i < P; i++)
		{
			for (int j = 0; j < Q; j++)
			{
				int row = i + resultRowCordinate - P + 1;
				int col = j + resultColCordinate - Q + 1;
				System.out.printf("%3d", matrix[row][col]);
			}

			System.out.println();
		}
	}

	
}

/* Given a M x N  matrix, calculate maximum sum submatrix of size P X Q

Sample input:
		      3, -4, 6, -5, 1 
			  1, -2, 8, -4, -2 
			  3, -8, 9, 3, 1 
			  -7, 3, 4, 2, 7 
			  -3, 7, -5, 7, -6 
			  
Sample output:

When P=3, Q=3:

  8 -4 -2
  9  3  1
  4  2  7

When P=2, Q=2:
  9  3
  4  2


explanation:

The idea is to pre-process the matrix.  We take an auxiliary matrix cumulativeSum[][] where cumulativeSum[i][j] will store the sum of all the elements 
in the matrix from (0, 0) to (i, j). 


We can easily calculate the value of sum[i][j] in constant time using below relation

    cumulativeSum[i][j] = cumulativeSum[i][j-1] + cumulativeSum[i-1][j] + matrix[i][j] - cumulativeSum[i-1][j - 1]
    

Now to find maximum sum p x q  sub-matrix, we consider every sub-matrix of size p x q and calculate their sum in constant time by directly 
using below relation:


    submatrixSum = cumulativeSum[i][j] - cumulativeSum[i - p][j] - cumulativeSum[i][j - q] + cumulativeSum[i - p][j - q]


Here, (i, j) is bottom right corner coordinates of p x q  sub-matrix. Finally, we print the sub-matrix that has maximum sum.

*/