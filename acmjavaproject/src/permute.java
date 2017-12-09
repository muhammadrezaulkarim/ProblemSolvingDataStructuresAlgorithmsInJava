import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class permute{
	
	boolean flag[]=null;
	String num1Str=null,x=null;
	int count=0;
	StringBuilder sb=new StringBuilder();
	
	public void prob389()
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

		
		while (sc.hasNext())
		{
			x=	sc.next();
			
			flag=new boolean[x.length()];
			
			for(int i=0;i<flag.length;i++)
			{
				flag[i]=false;
			}
			
			int count=0,level=0;
			for(int i=0;i<x.length();i++)
			{
				level=0;
				permute(i,level);
			}
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
		permute ob=new permute();
		ob.prob389();
	}

}
