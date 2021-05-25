import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class DFSMatrixConnectedComponetACM572 {
	
	boolean flag[][]=null;
	String num1Str=null,x=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();
	
	int addRow[]={-1,-1,-1,0,0,1,1,1};
	int addCol[]={-1,0,1,-1,1,-1,0,1};
	int p=0,q=0;
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
		}*/
		

		int fromBase,toBase;
		BigInteger num1=null;
		
		int count=0;
		
		while (true)
		{
			count++;
		   p=	sc.nextInt();
		   q=	sc.nextInt();
		   
		   if(p==0 && q==0)
			   break;
			
			flag=new boolean[p][q];
			a=new String[p];

	         sc.nextLine();
	         
			for(int i=0;i<p;i++)
			{
			  a[i]=sc.next();
		
			}
			
			
			for(int i=0;i<p;i++)
			{
				for(int j=0;j<q;j++)
				{
					flag[i][j]=false;
				}
			}
				
				
			
			
			int eagleCount=0,level=0;

			for(int i=0;i<p;i++)
			{
				for(int j=0;j<q;j++)
				{
					level=0;
					nodecount=0;
					
					if(flag[i][j]==false && a[i].charAt(j)=='@')
					{
						DFS(i,j,level);
						
						if(nodecount>0)
						{
							eagleCount++;
					    }
					}
				}
			}
			
			System.out.println(eagleCount);
		}
			
	}
	
	public void DFS(int row,int col,int level)
	{
		int nextCol=0,nextRow=0;
	
		//set visited to true
		flag[row][col]=true;
		
		level++;
		nodecount++;
			
		for(int i=0;i<8;i++)
		{
			nextRow=row+addRow[i];
			nextCol=col+addCol[i];
			
			if(nextCol>=0 && nextCol<q && nextRow>=0 && nextRow<p )
			if(flag[nextRow][nextCol]==false && a[nextRow].charAt(nextCol)=='@')
			{
				DFS(nextRow,nextCol,level);
			}
		}

	}
	
	
	
	
	public static void main(String args[])
	{
		DFSMatrixConnectedComponetACM572 ob=new DFSMatrixConnectedComponetACM572();
		ob.x();
	}

}

/*
 The GeoSurvComp geologic survey company is responsible for detecting underground oil deposits.
GeoSurvComp works with one large rectangular region of land at a time, and creates a grid that divides
the land into numerous square plots. It then analyzes each plot separately, using sensing equipment to
determine whether or not the plot contains oil.

A plot containing oil is called a pocket. If two pockets are adjacent, then they are part of the
same oil deposit. Oil deposits can be quite large and may contain numerous pockets. Your job is to
determine how many different oil deposits are contained in a grid.

Input
The input file contains one or more grids. Each grid begins with a line containing m and n, the number
of rows and columns in the grid, separated by a single space. If m = 0 it signals the end of the input;
otherwise 1 ≤ m ≤ 100 and 1 ≤ n ≤ 100. Following this are m lines of n characters each (not counting
the end-of-line characters). Each character corresponds to one plot, and is either ‘*’, representing the
absence of oil, or ‘@’, representing an oil pocket.


Output
For each grid, output the number of distinct oil deposits. Two different pockets are part of the same
oil deposit if they are adjacent horizontally, vertically, or diagonally. An oil deposit will not contain
more than 100 pockets.

Sample Input
1 1
*
3 5
*@*@*
**@**
*@*@*
1 8
@@****@*
5 5
****@
*@@*@
*@**@
@@@*@
@@**@
0 0

Sample Output
0
1
2
2
 * */
