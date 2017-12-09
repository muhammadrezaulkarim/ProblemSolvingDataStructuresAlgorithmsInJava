import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
public class prob352 {
	
	boolean flag[][]=null;
	String num1Str=null,x=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();
	
	int addRow[]={-1,-1,-1,0,0,1,1,1};
	int addCol[]={-1,0,1,-1,1,-1,0,1};
	int p=0;
  String[] a=null;
	public void processInput()
	{
		Scanner sc=new Scanner(System.in);
	//Scanner sc=null;
	/*	try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

		int fromBase,toBase;
		BigInteger num1=null;
		
		int count=0;
		
		while (sc.hasNext())
		{
			count++;
			p=	sc.nextInt();
			
			flag=new boolean[p][p];
			a=new String[p];
			String x;
			int c=0;
	         sc.nextLine();
	         
			for(int i=0;i<p;i++)
			{
			  a[i]=sc.next();

			
			}
			
			for(int i=0;i<p;i++)
			{
				for(int j=0;j<p;j++)
				{
					flag[i][j]=false;
				}
			}
				
				
			
			
			int eagleCount=0,level=0;

			for(int i=0;i<p;i++)
			{
				for(int j=0;j<p;j++)
				{
					level=0;
					nodecount=0;
					if(flag[i][j]==false && a[i].charAt(j)=='1')
					{
						DFS(i,j,level);
						if(nodecount>0){
							eagleCount++;
					                 }
					}
				}
			}
			
			System.out.printf("Image number %d contains %d war eagles.\n",count,eagleCount);
		}
			
	}
	
	public void DFS(int row,int col,int level)
	{
		int nextCol=0,nextRow=0;
	
		
		flag[row][col]=true;
		level++;
			nodecount++;
			
		for(int i=0;i<8;i++)
		{
			nextRow=row+addRow[i];
			nextCol=col+addCol[i];
			
			if(nextCol>=0 && nextCol<p && nextRow>=0 && nextRow<p )
			if(flag[nextRow][nextCol]==false && a[nextRow].charAt(nextCol)=='1')
			{
				DFS(nextRow,nextCol,level);
			}
		}

	}
	
	
	
	
	public static void main(String args[])
	{
		prob352  ob =new prob352();
		ob.processInput();
	}

}
