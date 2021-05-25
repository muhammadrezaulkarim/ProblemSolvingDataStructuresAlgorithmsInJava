public class DynamicMaximumSumSubMatrixACM108
{
	int resultRowCordinate =0;
	int resultColCordinate =0;
	
	int globalMaxSum = Integer.MIN_VALUE;
	int globalResultRowCordinate = 0;
	int globalResultColCordinate = 0;
	int globalP;
	int globalQ;
	
    public static void main(String[] args) 
    {
        
    	DynamicMaximumSumSubMatrixACM108  ob = new DynamicMaximumSumSubMatrixACM108();
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
		
		if (max > globalMaxSum)
		{
			globalMaxSum = max;
			globalResultRowCordinate = resultRowCordinate;
			globalResultColCordinate = resultColCordinate;
			globalP = P;
			globalQ = Q;
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
		
/*	    int[][] matrix =
		{
			{ 0, -2, -7, 0},
			{ 9, 2, -6, 2},
			{ -4, 1, -4, 1},
			{ -1, 8, 0, -2}
		};
*/


     
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		
		// try all P by Q values (minimum size 1 by 1)
		for (int i = 1; i <= rowCount; i++)
			for (int j = 1; j <= colCount; j++)
		         maximumSumSubMatrix(matrix, i, j);
		

		// print maximum sum sub-matrix
		for (int i = 0; i < globalP; i++)
		{
			for (int j = 0; j < globalQ; j++)
			{
				int row = i + globalResultRowCordinate - globalP + 1;
				int col = j + globalResultColCordinate - globalQ + 1;
				System.out.printf("%3d", matrix[row][col]);
			}

			System.out.println();
		}
		
		System.out.println();
		System.out.println(globalMaxSum);
	}

	
}

/*
 * 
  A problem that is simple to solve in one dimension is often much more difficult to solve in more than
one dimension. Consider satisfying a boolean expression in conjunctive normal form in which each
conjunct consists of exactly 3 disjuncts. This problem (3-SAT) is NP-complete. The problem 2-SAT
is solved quite efficiently, however. In contrast, some problems belong to the same complexity class
regardless of the dimensionality of the problem.

Given a 2-dimensional array of positive and negative integers, find the sub-rectangle with the largest
sum. The sum of a rectangle is the sum of all the elements in that rectangle. 
In this problem the subrectangle with the largest sum is referred to as the maximal sub-rectangle.

A sub-rectangle is any contiguous sub-array of size 1 × 1 or greater located within the whole array.

As an example, the maximal sub-rectangle of the array:

0 −2 −7 0
9 2 −6 2
−4 1 −4 1
−1 8 0 −2

is in the lower-left-hand corner:

9 2
−4 1
−1 8

and has the sum of 15.

Input
The input consists of an N × N array of integers.
The input begins with a single positive integer N on a line by itself indicating the size of the square
two dimensional array. 

This is followed by N2 integers separated by white-space (newlines and spaces).
These N2 integers make up the array in row-major order (i.e., all numbers on the first row, left-to-right,
then all numbers on the second row, left-to-right, etc.). N may be as large as 100. The numbers in the
array will be in the range [−127, 127].

Output
The output is the sum of the maximal sub-rectangle.


Sample Input
4
0 −2 −7 0
9 2 −6 2
−4 1 −4 1
−1 8 0 −2

Sample Output
15
 
 
 
 Input 1:
 	       0 -2 -7 0 
           9 2 -6 2
           -4 1 -4 1
          -1 8 0 -2
			
			
Output 1: 
			  9  2
			 -4  1
			 -1  8

     Sum: 15
           
           
Input 2:
  
            3, -4, 6, -5, 1
			1, -2, 8, -4, -2
			3, -8, 9, 3, 1
			-7, 3, 4, 2, 7
			-3, 7, -5, 7, -6


Output 2:

  6 -5  1
  8 -4 -2
  9  3  1
  4  2  7

sum = 30



/*
 * Matrix: formulas used
 * Given a M x N  matrix, calculate maximum sum submatrix of size P X Q

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
