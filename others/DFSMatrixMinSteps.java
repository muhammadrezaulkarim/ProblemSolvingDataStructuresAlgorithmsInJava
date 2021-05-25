import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class DFSMatrixMinSteps {
	
	boolean flag[][]=null;
	String num1Str=null,x=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();
	
	int addRow[]={-1,1,0,0};
	int addCol[]={0,0,-1,1};
	int p=0,q=0,max=0;

    // sample input 1
	String [] a = {"11000","01100","00501","10001","01011"};
	
    // sample input 2
	 //String [] a = {"11000","11100","51001","10001","01011"};
	
	// String [] a = {"11000","11100","11151","10001","01011"};

	 
    
    int minGlobalSteps = Integer.MAX_VALUE;
	Queue<Node> queue=new LinkedList<Node>();
    
	public void x()
	{

		int fromBase,toBase;
		BigInteger num1=null;
		
		   int count=0,testCases=0;
		
           int cas=0;
			

           //5 by 5 square matrix  ( a sample input)
	        
            p=a.length;
	         
	     	flag=new boolean[p][p];
	        
            
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
			

			DFS(0,0,-1);
			//BFS(0,0,-1);
			System.out.println("Minimum Steps: " + minGlobalSteps);
	

		
			
	}
	
	public void DFS(int row,int col,int level)
	{
		int nextCol=0,nextRow=0;
	
		// set visited to true
		flag[row][col]=true;
		
		level++;
		nodecount++;
		
		if (a[row].charAt(col)=='5')
		{
			System.out.println(level);
			if (level < minGlobalSteps)
			{
		
				flag[row][col]=false;
				minGlobalSteps = level;
			    return;
			}
		}
			
		// determine the adjacent cells which are considered as children
		for(int i=0;i<4;i++)
		{
			nextRow = row + addRow[i];
			nextCol = col + addCol[i];
			
			//must be within the boundary
			if(nextCol>=0 && nextCol<p && nextRow>=0 && nextRow<p )
			{
				// if not already visited and the cell is filled
				if(flag[nextRow][nextCol]==false && (a[nextRow].charAt(nextCol)=='1' || a[nextRow].charAt(nextCol)=='5'))
				{
					DFS(nextRow,nextCol,level);
				}
			}
		}
		
		flag[row][col]=false;

	}
	
	public void BFS(int row,int col,int level)
	{
		nodecount++;

		Node root =new Node();
		root.rowPos = row;
		root.colPos = col;
		root.level = 0;
		
		queue.add(root); //add the root node
		
		flag[row][col]=true;
		
		while(!queue.isEmpty())
		{		

			Node node = queue.remove();

			
			if (a[node.rowPos].charAt(node.colPos)=='5')
			{
				System.out.println( node.level);
				if (node.level < minGlobalSteps)
				{
			
					flag[row][col]=false;
					minGlobalSteps = node.level;
				    //return;
				}
			}
				
			// determine the adjacent cells which are considered as children
			for(int i=0;i<4;i++)
			{
				int nextRow=node.rowPos + addRow[i];
				int nextCol=node.colPos + addCol[i];
				
				//must be within the boundary
				if(nextCol>=0 && nextCol<p && nextRow>=0 && nextRow<p )
				{
					// if not already visited and the cell is filled
					if(flag[nextRow][nextCol]==false && (a[nextRow].charAt(nextCol)=='1' || a[nextRow].charAt(nextCol)=='5'))
					{
						Node node1 =new Node();
						node1.rowPos = nextRow;
						node1.colPos = nextCol;
						node1.level = node.level + 1;
						
						queue.add(node1); //add the root node
						flag[nextRow][nextCol]=true;
						
					}
				}
			}
		}

	}
	
	
	
	
	public static void main(String args[])
	{
		DFSMatrixMinSteps ob=new DFSMatrixMinSteps();
		ob.x();
	}
	
	class Node
	{
		int rowPos, colPos, level;
	}

}

/*
 * 
 * Consider a two-dimensional grid of cells, each of which may be reachable
or not reachable from a particular cell. Your job is to find the minimum steps needed to reach a destination cell (marked as 5) on the grid
starting from top left position in the grid. In general, from a grid position you can move either left, right,top,bottom position.
However, some cells are nor reachable from a cell (marked as 0). Reachable cells are marked as 1.


Input
The grid is given as a set of strings, each composed of 0’s and 1’s. The ‘1’ indicates that the cell is
reachable and ‘0’ indicates the cell is not reachable. The strings should be converted into the grid format.
The largest grid that should be considered is a 25×25 grid.

Output
The output is the minimum number of steps required to reach the destination cell.

Output
The output is the minimum steps required to reach the destination cell


Sample Input 1
11000
01100
00501
10001
01011

Sample Output 1
4

Sample Input 2
11000
11100
51001
10001
01011

Sample Output 2
2

Sample Input 3
11000
11100
11151
10001
01011

Sample Output 3
3

*/

