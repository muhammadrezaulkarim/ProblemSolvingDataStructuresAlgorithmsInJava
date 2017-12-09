/*import java.io.File;
import java.io.FileNotFoundException;*/
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class prob10098{
	
	//boolean flag[]=null;
	BitSet flag=null;
	String x=null;
	StringBuilder sb=new StringBuilder();
	StringBuilder output=new StringBuilder();
	String newline=System.getProperty("line.separator");
	
	public void prob10098()
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


		int cases=sc.nextInt();
		int c=1;
		char [] temp=null;
		int i=0;
		sc.nextLine();
		while (c<=cases)
		{
			x=	sc.next();
			temp=x.toCharArray();
			Arrays.sort(temp);
			x=String.valueOf(temp);
			
			output.delete(0, output.length());
			
		//	flag=new boolean[x.length()];
			flag=new BitSet(x.length());
			
		/*	for(i=0;i<x.length();i++)
			{
				flag[i]=false;
			}
			*/
				

			for(i=0;i<x.length();i++)
			{
			//	second parameter level=0;
				permute(i,0);
			}
			System.out.print(output.toString());
		
			// print a blank line before printing the outputs
				System.out.println();
			c++;
		}
			
	}
	
	public void permute(int k,int level)
	{
		flag.set(k);
		//flag[k]=true;
		sb.append(x.charAt(k));
		level++;
		
		if(level==x.length())
		{

			//System.out.println(sb.toString());
			if(output.toString().indexOf(sb.toString())==-1)
			output.append(sb.toString()+newline);
		//	flag[k]=false;
			flag.clear(k);
			sb.deleteCharAt(sb.length()-1);
			return;
		}
		
		
		for(int i=0;i<x.length();i++)
		{
		//	if(flag[i]==false )
			if(!flag.get(i))
			{
			permute(i,level);
			}
		}
		
		//flag[k]=false;
		flag.clear(k);
		sb.deleteCharAt(sb.length()-1);
		//level--;
	}
	
	
	
	
	public static void main(String args[])
	{
		 prob10098 ob=new  prob10098();
		ob.prob10098();
	}

}
