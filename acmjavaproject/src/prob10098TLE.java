import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class prob10098TLE {
	
	boolean flag[]=null;
	String x=null;
	StringBuilder sb=new StringBuilder();
	
	public void prob10098TLE ()
	{
		Scanner sc=new Scanner(System.in);
	//Scanner sc=null;
/*		try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/


		int cases=sc.nextInt();
		int c=1;
		char [] temp=null;
		int i=0;
		while (c<=cases)
		{
			x=	sc.next();
			temp=x.toCharArray();
			Arrays.sort(temp);
			x=String.valueOf(temp);
			
			flag=new boolean[x.length()];
			
			
			for(i=0;i<flag.length;i++)
			{
				flag[i]=false;
			}
			
				
			// print a blank line before printing the outputs
			if(c>1)
				System.out.println();
			
			for(i=0;i<x.length();i++)
			{
			//	second parameter level=0;
				permute(i,0);
			}
			
			c++;
		}
			
	}
	
	public void permute(int k,int level)
	{
		flag[k]=true;
		sb.append(x.charAt(k));
		level++;
		
		if(level==x.length())
		{

			System.out.println(sb.toString());
			flag[k]=false;
			sb.deleteCharAt(sb.length()-1);
			return;
		}
		
		
		for(int i=0;i<x.length();i++)
		{
			if(flag[i]==false )
			{
			permute(i,level);
			}
		}
		
		flag[k]=false;
		sb.deleteCharAt(sb.length()-1);
		//level--;
	}
	
	
	
	
	public static void main(String args[])
	{
		prob10098TLE ob=new prob10098TLE();
		ob.prob10098TLE();
	}

}

