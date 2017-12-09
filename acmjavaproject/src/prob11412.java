//import java.io.File;
//import java.io.FileNotFoundException;

import java.util.Scanner;
public class prob11412 {
	
	boolean flag[]=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();
  StringBuilder[] a=null;
  int reply[][]=null;
  boolean match=false;
  String str="RGBYOV";
  
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
		}*/
		

	int total=sc.nextInt();
	sc.nextLine();
		
		int cases=0;
		while (cases<total)
		{
			sc.nextLine();
			cases++;
			sb.delete(0, sb.length());
			
			flag=new boolean[str.length()];
			
			a=new StringBuilder[2];
			
			reply=new int[2][2];
		
			for(int i=0;i<2;i++)
			{
				a[i]=new StringBuilder();
				a[i].append(sc.next());
				reply[i][0]=sc.nextInt();
				reply[i][1]=sc.nextInt();
			}
			
			for(int i=0;i<str.length();i++)
			{
				
					flag[i]=false;
				
			}
				
				
		//	if(cases>1)
			//	System.out.println();
				
	
					
		//			sb.delete(0, sb.length());
				//	if(flag[i][j]==false )
					//{
			  
			      //   for(int i=0;i<2;i++)
			      //   {
			        	 //count=0;
			        
			        	    match=false;
			        	    
			        	   for(int j=0;j<str.length();j++)
					       {
			            
					    	  match=permute(0,j,1);
					    	  
							   if(match)
							   {
						
								break;
							   }
					      }
			        // }
			         
			         if(match)
			        	 System.out.println("Possible");
			        	 
			         else
			        	 System.out.println("Cheat");
			        
			      //   System.out.println("Possible");
	
		
		//	if(count==0)
		//		System.out.printf("no walk of length %d\n",pathlength);
			
	/*		if(sc.hasNext())
			{
				sc.nextInt();
			}*/
			
			//System.out.printf("Image number %d contains %d war eagles.\n",count,eagleCount);
		}
			
	}
	
	public boolean permute(int guess,int index, int level)
	{
        boolean match=false;
		
		flag[index]=true;

		sb.append(str.charAt(index));
		
		if(level==a[guess].length())
		{
	
			int matchCount1=0,matchCount2=0;
			int unmatchCount1=0,unmatchCount2=0;
			
			for(int i=0;i<sb.length();i++)
			{
				if(a[0].charAt(i)==sb.charAt(i))
					matchCount1++;
				else
				{
					//String x=;
					if(sb.indexOf(a[0].substring(i,i+1))>-1)
					unmatchCount1++;
				}
				
				if(a[1].charAt(i)==sb.charAt(i))
					matchCount2++;
				else
				{
					//String x=;
					if(sb.indexOf(a[1].substring(i,i+1))>-1)
					unmatchCount2++;
				}
			}
			
			if(matchCount1==reply[0][0] && unmatchCount1==reply[0][1] && matchCount2==reply[1][0] && unmatchCount2==reply[1][1] )
			{
               match =true;
          // 	System.out.println(sb.toString());
    		//System.out.println(a[guess].toString());
			}
			else
				match =false;
			
			flag[index]=false;
			sb.deleteCharAt(sb.length()-1);
			//count++;
		
			return match;
		}

		
			
		for(int i=0;i<str.length();i++)
		{
			
			if(flag[i]==false)
			{
				match=permute(guess,i,level+1);
				if(match)
					break;
			}
		}
		
		//sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		flag[index]=false;
		
		return match;

	}
	
	
	
	
	public static void main(String args[])
	{
		prob11412  ob =new prob11412();
		ob.processInput();
	}

}
