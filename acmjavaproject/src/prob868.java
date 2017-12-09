
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
public class prob868 {
	
	boolean flag[][]=null;
	int input[][]=null;
	//String num1Str=null,x=null;
	//int nodecount=0;
	int minlength;
	//StringBuilder sb=new StringBuilder();
	
	int addRow[]={0,0,-1,1};
	int addCol[]={-1,1,0,0};
	int p=0,q=0;
	int sx=0,sy=0;
	int ex=0,ey=0;
	int mx=0,my=0;
	
 // String[] a=null;
	public void x()
	{
		//Scanner sc=new Scanner(System.in);
	Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		int fromBase,toBase;
		BigInteger num1=null;
		
		int count=0;
		
		int num=0;
		int cases=sc.nextInt();
		sc.nextLine();
		
		int cs=0;
		
		while (cs<cases)
		{
		   count++;
		   sc.nextLine();
		   p=	sc.nextInt();
		   q=	sc.nextInt();
		   
		   input=new int[p][q];
		   flag=new boolean[p][q];
		 //  a=new String[p];

	      //   sc.nextLine();
	         
	     	for(int i=0;i<p;i++)
			{
				for(int j=0;j<q;j++)
				{
					num=sc.nextInt();
					input[i][j]=num;
				}
			}
				
			minlength=Integer.MAX_VALUE;
			sx=0;sy=0;
			ex=0;ey=0;
			mx=0;my=0;
				
			for(int i=0;i<p;i++)
			{
				for(int j=0;j<q;j++)
				{
					flag[i][j]=false;
				}
			}
				
				
			int eagleCount=0,level=0;

		
				for(int j=0;j<q;j++)
				{
					level=1;
				//	nodecount=0;
					
					if(input[0][j]==1)
					{
						sx=0;
						sy=j;
					//	ex=0;
						//ey=j;
						
						DFS(0,j,level,1,1);
						//if(nodecount>0){
						//	eagleCount++;
			                 
					}
				}
				
				mx++;
				my++;
				ex++;
				ey++;
				
				if(cs>0)
					System.out.println();
				
				if(minlength!=Integer.MAX_VALUE)
				{
				System.out.println(mx+" "+my);
				System.out.println(ex+" "+ey);
				}
				else
				{
					System.out.println();
				//	System.out.println();
				}
				
				cs++;
		
		}	
			//System.out.println(eagleCount);
		
			
	}
	
	public void DFS(int row,int col,int level,int sequence, int curval)
	{
		int nextCol=0,nextRow=0;
	    int nextval=0,nextseq=0;
		
		flag[row][col]=true;
		//level++;
			
		if(row==p-1)
		{
			 
		//  if(curval==sequence)
		//  {
			
				if(level<minlength)
				{
					minlength=level;
					mx=sx;
					my=sy;
					
					ex=row;
					ey=col;
					
				}
				
				else if(level==minlength)
				{
					int x=0;
					x++;
					if(row<ex ||(row==ex && col < ey ))
					//if(sx<mx )
					{
					   // minlength=level;
						mx=sx;
						my=sy;
						
						ex=row;
						ey=col;
					}
						
				
				}
		//  }
		  flag[row][col]=false;
		  return;
		}
			
			if(curval==sequence)
			{
				nextseq=sequence+1;
				nextval=1;
			}
			else
			{
				nextseq=sequence;
				nextval=curval+1;
			}
			
		for(int i=0;i<4;i++)
		{
			nextRow=row+addRow[i];
			nextCol=col+addCol[i];
			
			if(nextCol>=0 && nextCol<q && nextRow>=0 && nextRow<p )
			if(flag[nextRow][nextCol]==false && input[nextRow][nextCol]==nextval)
			{
				DFS(nextRow,nextCol,level+1,nextseq,nextval);
			}
		}
		
		
		flag[row][col]=false;

	}
	
	
	
	
	public static void main(String args[])
	{
		prob868  ob=new prob868();
		ob.x();
	}

}
