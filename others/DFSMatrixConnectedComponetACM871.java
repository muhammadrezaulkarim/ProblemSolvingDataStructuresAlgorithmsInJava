import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
public class DFSMatrixConnectedComponetACM871 {
	
	boolean flag[][]=null;
	String num1Str=null,x=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();
	
	int addRow[]={-1,-1,-1,0,0,1,1,1};
	int addCol[]={-1,0,1,-1,1,-1,0,1};
	int p=0,q=0,max=0;
    String[] a=null;
    
	public void x()
	{
	Scanner sc=new Scanner(System.in);
	
/*	Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

		int fromBase,toBase;
		BigInteger num1=null;
		
		   int count=0,testCases=0;
		
           int cas=0;
			
			// read number of cases
            testCases=	sc.nextInt();
		    sc.nextLine();
	        String x=null;
	        
	        /* Sample Input
	        1
	        11000
	        01100
	        00101
	        10001
	        01011 */
	         
			while(cas<testCases)
			{
			cas++;
			sc.nextLine();
			       
		

	        // read first row of the input matrix
	        x =sc.next();
	        p=x.length();
	         
	     	flag=new boolean[p][p];
			
	     	a=new String[p];
			
			a[0]=x;
	        
			// read subsequent rows of the input matrix
			for(int i=1;i<p;i++)
			{
			  a[i]=sc.next();
			}
			
			// initilize the visit flag
			for(int i=0;i<p;i++)
			{
				for(int j=0;j<p;j++)
				{
					flag[i][j]=false;
				}
			}
				
			max=0;		
			int eagleCount=0,level=0;

			// run the main algorithm
			for(int i=0;i<p;i++)
			{
				for(int j=0;j<p;j++)
				{
					level=0;
					nodecount=0;
					
					// if not visited and set to 1 (1 indicates filled cell)
					if(flag[i][j]==false && a[i].charAt(j)=='1')
					{
						DFS(i,j,level);
						
						// keep track of the max blob size
						if(nodecount>0 && nodecount>max)
						{
							max=nodecount;
					    }
					}
				}
			}
			
			
			
			if(cas>1)
				System.out.println();
				
				System.out.println(max);
				
				

			}
		
			
	}
	
	public void DFS(int row,int col,int level)
	{
		int nextCol=0,nextRow=0;
	
		// set visited to true
		flag[row][col]=true;
		
		level++;
		nodecount++;
			
		// determine the adjacent cells which are considered as children
		for(int i=0;i<8;i++)
		{
			nextRow=row+addRow[i];
			nextCol=col+addCol[i];
			
			//must be within the boundary
			if(nextCol>=0 && nextCol<p && nextRow>=0 && nextRow<p )
			{
				// if not already visited and the cell is filled
				if(flag[nextRow][nextCol]==false && a[nextRow].charAt(nextCol)=='1')
				{
					DFS(nextRow,nextCol,level);
				}
			}
		}

	}
	
	
	
	
	public static void main(String args[])
	{
		DFSMatrixConnectedComponetACM871 ob=new DFSMatrixConnectedComponetACM871();
		ob.x();
	}

}

/*
 * 
 * Consider a two-dimensional grid of cells, each of which may be empty
or filled. Filled cells form blobs. The filled cells that are connected
form the same bigger blob. Two cells are said to be connected if
they are adjacent to each other horizontally, vertically, or diagonally.
There may be several blobs on the grid. Your job is to find the largest
blob (in terms of number of cells) on the grid.

Write a program that determines the size of the largest blob for
a given set of blobs.

Input
The input begins with a single positive integer on a line by itself
indicating the number of the cases following, each of them as described below. This line is followed by a blank line, and there is also
a blank line between two consecutive inputs.
The grid is given as a set of strings, each composed of 0’s and 1’s. The ‘1’ indicates that the cell is
filled and ‘0’ indicates an empty cell. The strings should be converted into the grid format.
The largest grid that sould be considered is a 25×25 grid.

Output
For each test case, the output must follow the description below. The outputs of two consecutive cases
will be separated by a blank line.
The output is the size of the largest blob found on the grid.

Output
For each test case, the output must follow the description below. The outputs of two consecutive cases
will be separated by a blank line.
The output is the size of the largest blob found on the grid.

Sample Input
1
11000
01100
00101
10001
01011

Sample Output
5
*/
