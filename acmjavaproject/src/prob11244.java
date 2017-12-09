import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
public class prob11244 {
	
	boolean flag[][]=null;
	String num1Str=null,x=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();
	
	int addRow[]={-1,-1,-1,0,0,1,1,1};
	int addCol[]={-1,0,1,-1,1,-1,0,1};
	int p=0,q=0;
  String[] a=null;
	public void prob389()
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
					if(flag[i][j]==false && a[i].charAt(j)=='*')
					{
						DFS(i,j,level);
						if(nodecount==1){
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
	
		
		flag[row][col]=true;
		level++;
			nodecount++;
			
		for(int i=0;i<8;i++)
		{
			nextRow=row+addRow[i];
			nextCol=col+addCol[i];
			
			if(nextCol>=0 && nextCol<q && nextRow>=0 && nextRow<p )
			if(flag[nextRow][nextCol]==false && a[nextRow].charAt(nextCol)=='*')
			{
				DFS(nextRow,nextCol,level);
			}
		}

	}
	
	
	
	
	public static void main(String args[])
	{
		prob11244 ob=new prob11244();
		ob.prob389();
	}

}
