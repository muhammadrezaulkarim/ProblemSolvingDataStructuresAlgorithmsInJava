import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
public class prob784 {
	
	boolean flag[][]=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();

	
	int addRow[]={-1,-1,-1,0,0,1,1,1};
	int addCol[]={-1,0,1,-1,1,-1,0,1};
	int p=0;
  StringBuilder[] a=null;
	public void processInput()
	{
		//Scanner sc=new Scanner(System.in);
	  Scanner sc=null;
	  
/*		try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		int count=0;
		int testCase=	sc.nextInt();
		String[] temp=null;
		int cas=0,i=0,j=0;
		String x=null;
		sc.nextLine();
		
		while (cas<testCase)
		{
			cas++;
			count++;
			sb.delete(0, sb.length());
		p=0;
			while(true)
			{
			  x=sc.nextLine();
			  
			
			  sb.append(x);
			  sb.append("#");
			  p++;
			  
			  if(x.charAt(0)=='_')
				  break;
			
			}
			
			temp=sb.toString().split("#");
			
			a=new StringBuilder[temp.length];
			
			for(i=0;i<a.length;i++)
				a[i]=new StringBuilder(temp[i]);
			

			int eagleCount=0,level=0;
			int rowStart=0,colStart=0;
			
		//	p--;

			for(i=0;i<p;i++)
			{
				for(j=0;j<a[i].length();j++)
				{
					level=0;
					nodecount=0;
					if(a[i].charAt(j)=='*')
					{
					
										
						rowStart=i;
						colStart=j;
				        a[i].setCharAt(colStart,' ');
						break;
						
					}
					
				}
			}
			DFS(rowStart,colStart,level);
			
			for(i=0;i<p;i++)
			{
				System.out.println(a[i].toString());
			}
			
			//System.out.printf("Image number %d contains %d war eagles.\n",count,eagleCount);
		}
			
	}
	
	public void DFS(int row,int col,int level)
	{
		int nextCol=0,nextRow=0;
	
		
	//	flag[row][col]=true;
		a[row].setCharAt(col,'#');
		
		level++;
			nodecount++;
			
		for(int i=0;i<8;i++)
		{
			nextRow=row+addRow[i];
			nextCol=col+addCol[i];
			
			if(nextRow>=0 && nextRow<p )
			{
				if(nextCol>=0 && nextCol<a[nextRow].length() )
				{
				
					if( a[nextRow].charAt(nextCol)==' ')
					{
						DFS(nextRow,nextCol,level);
					}
				}
			}
		}

	}
	
	
	
	
	public static void main(String args[])
	{
		prob784  ob =new prob784();
		ob.processInput();
	}

}
