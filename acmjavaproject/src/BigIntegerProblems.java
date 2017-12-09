//import java.io.File;
//import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
public class BigIntegerProblems {
	
	
	
/*	public void prob10551()
	{
		Scanner sc=new Scanner(System.in);
		Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (true)
		{
		int base=	sc.nextInt();
		
		if(base==0)
			break;
		
		BigInteger p=sc.nextBigInteger(base);
		BigInteger m=sc.nextBigInteger(base);
		System.out.println(p.mod(m).toString(base));
			
		}
		
		
		
	}*/
	
/*	public void prob389()
	{
		Scanner sc=new Scanner(System.in);
		Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String num1Str=null,x=null;
		int fromBase,toBase,num1;
		while (sc.hasNext())
		{
		num1Str=	sc.next();
		
    	fromBase=sc.nextInt();
		toBase=sc.nextInt();

		num1=Integer.parseInt(num1Str,fromBase);
		

		
		x=Integer.toString(num1, toBase);
		
		if(x.length()>7)
			System.out.println("  ERROR");
		else
			System.out.printf("%7s\n",x.toUpperCase());
			
		}
		
		
		
	}*/
	
	
	
		public void prob10925()
		{
			Scanner sc=new Scanner(System.in);
/*			Scanner sc=null;
			try {
				sc = new Scanner(new File("input.txt"));
				//Scanner sc=new Scanner(System.in);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			int itemCount=0, fCount=0,i=0;
			
			BigInteger sum=BigInteger.ZERO;
			BigInteger num;
			int count=1;
			
			while (true)
			{
			itemCount=	sc.nextInt();
			fCount=sc.nextInt();
			
			if(itemCount==0 && fCount==0)
				break;
			sum=BigInteger.ZERO;
		
			    for(i=0;i<itemCount;i++)
			    {
					num=sc.nextBigInteger();
					sum=sum.add(num);
				
			    }
			    
				System.out.println("Bill #"+count+ " costs "+sum+": each friend should pay "+sum.divide(BigInteger.valueOf(fCount)));
				System.out.println();
				count++;
			}
			
			
			
		}
		
		public void prob10814()
		{
		Scanner sc=new Scanner(System.in);
	/*		Scanner sc=null;
			try {
				sc = new Scanner(new File("input.txt"));
				//Scanner sc=new Scanner(System.in);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			int itemCount=0, fCount=0,i=0;
			
			BigInteger num1, numAfterSub,lastDigit,temp;
			BigInteger five=new BigInteger("5");
			BigInteger seventeen=new BigInteger("17");
			BigInteger gcd;
			int count=0;
			
		//	count=	sc.nextInt();
	
			while (true)
			{
			    num1=sc.nextBigInteger();
			    
			    if(num1.equals(BigInteger.ZERO))
			    	break;
			    
			    lastDigit=num1.remainder(BigInteger.TEN);
	             
			    numAfterSub=num1.divide(BigInteger.TEN);
			    
			    lastDigit=lastDigit.multiply(five);
			    
			    numAfterSub=numAfterSub.subtract(lastDigit);
			    
			    numAfterSub=numAfterSub.remainder(seventeen);
		    
			    if(numAfterSub.equals(BigInteger.ZERO))
			    {
	
			    	System.out.println("1");
					i++;
				}
			    else
			    	System.out.println("0");
			    	
			}
			
			
		}
	
			public void prob623()
		{
			Scanner sc=new Scanner(System.in);
/*			Scanner sc=null;
			try {
				sc = new Scanner(new File("input.txt"));
				//Scanner sc=new Scanner(System.in);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
	
			BigInteger fact=BigInteger.ONE;
			int i=1,num1;
			while (sc.hasNext())
			{
				fact=BigInteger.ONE;
				num1=	sc.nextInt();
	
				for(i=2;i<=num1;i++)
				fact=fact.multiply(BigInteger.valueOf(i));
				
				 System.out.println(num1+"!");
				 System.out.println(fact.toString());
				
			}
			
			
			
		}
			
	
public void prob713()
{
	
	Scanner sc=new Scanner(System.in);
	/*			Scanner sc=null;
				try {
					sc = new Scanner(new File("input.txt"));
					//Scanner sc=new Scanner(System.in);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
		
				BigInteger num1,num2,rev1,rev2;
				int i=0;
				int count=sc.nextInt();
				StringBuilder sb1=new StringBuilder();
				StringBuilder sb2=new StringBuilder();
				while (i<count)
				{
		
					num1=	sc.nextBigInteger();
					num2=	sc.nextBigInteger();
					
					sb1.append(num1);
					sb1.reverse();
					sb2.append(num2);
					sb2.reverse();
					
					rev1=new BigInteger(sb1.toString());
					rev2=new BigInteger(sb2.toString());
		
					
				 System.out.println(rev1.add(rev2));
					 
					 i++;
					
				}
	
}
	
	public static void main(String args[])
	{
		BigIntegerProblems ob=new BigIntegerProblems();
		ob.prob623();
	}

}
