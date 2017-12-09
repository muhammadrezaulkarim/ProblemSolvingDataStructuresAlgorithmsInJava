/*import java.io.File;
import java.io.FileNotFoundException;*/

import java.util.Scanner;
public class prob677 {
	
	boolean flag[]=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();
	int p=0;
	int pathlength=0;
	int count=0;
  StringBuilder[] a=null;
	public void processInput()
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

	
		
		int cases=0;
		while (sc.hasNext())
		{
			cases++;
			sb.delete(0, sb.length());
			p=	sc.nextInt();
			pathlength=	sc.nextInt();
			
			flag=new boolean[p];
			a=new StringBuilder[p];
		
			for(int i=0;i<p;i++)
			{
				a[i]=new StringBuilder();
				//int t=sc.nextInt();
				for(int j=0;j<p;j++)
				{
			      a[i].append(sc.nextInt());
				}
			
			}
			
			for(int i=0;i<p;i++)
			{
				
					flag[i]=false;
				
			}
				
				
			if(cases>1)
				System.out.println();
				
			
		

			count=0;
					
		//			sb.delete(0, sb.length());
				//	if(flag[i][j]==false )
					//{
						permute(0,0);
	
		
			if(count==0)
				System.out.printf("no walk of length %d\n",pathlength);
			
			if(sc.hasNext())
			{
				sc.nextInt();
			}
			
			//System.out.printf("Image number %d contains %d war eagles.\n",count,eagleCount);
		}
			
	}
	
	public void permute(int node, int level)
	{

		
		flag[node]=true;
	//	level++;
		//sb.append(" ");
		if(level==0)
			sb.append("(");
		sb.append(node+1);
		if(level<pathlength )
			sb.append(",");
		
		if(level==pathlength)
		{
			count++;
	/*		System.out.print("("+sb.charAt(0));
			for(int k=1;k<sb.length();k++)
			{
				System.out.print(","+sb.charAt(k));
			
			}*/
			sb.append(")");
			System.out.printf("%s\n",sb.toString());
			
			flag[node]=false;
			sb.delete(sb.length()-2,sb.length());
			return;
		}

		
			
		for(int i=0;i<a[node].length();i++)
		{
			
			if(flag[i]==false && a[node].charAt(i)=='1')
			{
				permute(i,level+1);
			}
		}
		
		//sb.deleteCharAt(sb.length()-1);
		sb.delete(sb.length()-2,sb.length());
		flag[node]=false;

	}
	
	
	
	
	public static void main(String args[])
	{
		prob677 ob =new prob677();
		ob.processInput();
	}

}
