import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;



public class matchstick {
	//BitSet flag=new BitSet();
	int M,N;
	int [][] pos;
	int count=0;
	int [] m={6,2,5,5,4,5,6,3,7,6};
	int min_required=2;
	BigInteger maxNum=BigInteger.ZERO;
	BigInteger minNum=new BigInteger("111111111111111111111111111");
	
	HashMap mp=new HashMap();
	StringBuilder res=new StringBuilder();
	public void knights()
	{
		//Scanner sc=new Scanner(System.in);
		
		Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	//	int M,N;
		int level=1;
		while(sc.hasNext())
		{
			M=sc.nextInt();
			res.delete(0,res.length());
			
			maxNum=BigInteger.ZERO;
			minNum=new BigInteger("111111111111111111111111111");
			
			count=0;
			//for(int i=0;i<M;i++)
			//	for(int j=0;j<M;j++)
			backtrack(M,level);
			
			System.out.println(	minNum+" "+maxNum);
		}
		
	}
	
	public void backtrack(int curmatch,int level)
	{
		if(curmatch==0)
		{
	      BigInteger val=new BigInteger(res.toString());
	      
	   //   System.out.println(val);
	      
	   //   if(val>	maxNum)
	      maxNum=val.max(maxNum);
	   
	      
	      minNum= (minNum==BigInteger.ZERO)? val:val.min(minNum);
			return;
			
		}
		
		boolean flag=false;
		for(int i=0;i<10;i++)
		{
			flag=false;
			if(i==0)
			{
			if(res.toString().isEmpty())
								continue;
			}
			if(m[i]<=curmatch)
			{
				res.append(i);
				flag=true;
				backtrack(curmatch-m[i],level+1);
				
			}
			if(flag)
			res.deleteCharAt(res.length()-1);
		}
	}
	
	public static void main(String args[] )
	{
		
		matchstick ob=new matchstick();
		ob.knights();
		
	}

	
	
	

}
