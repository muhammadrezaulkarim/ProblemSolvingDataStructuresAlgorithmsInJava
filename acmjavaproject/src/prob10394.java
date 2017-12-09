import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class prob10394
{
	public static BitSet bs;
	public static ArrayList primeList=new ArrayList();
	
/*	public static void Sieve(int UB)
	{
		  UB++;
		bs=new BitSet(UB);
	  
		bs.set(0, UB);
		bs.clear(0);
		bs.clear(1);
		int i=0,k=0;
		for(i=2;i<=UB;i++)
		{
			if(bs.get(i))
			{
				Primelist.add(i);
				//k=2;  //from second multiple
				for(k=2;k*i<=UB;k++)
					bs.clear(k*i);
							
			}
			
		}
		
		
		
	}*/
	
	public static void Sieve(int UB,int nPrime)
	{
		  UB++;
		bs=new BitSet(UB);
	  
		bs.set(0, UB);
		bs.clear(0);  //0 is not a prime
		bs.clear(1); // 0 is not a prime
		int i=0,k=0,count=0;
		int LastPrime=2,CurrentPrime=2;
		for(i=2;i<=UB;i++)
		{
			if(bs.get(i))
			{
				CurrentPrime=i;

				if(CurrentPrime==LastPrime+2)
				{
					primeList.add(CurrentPrime);
					count++;

				}
				
				//k=2;  //from second clear multiples
				for(k=2;k*i<=UB;k++)
					bs.clear(k*i);
				
				LastPrime=i;
							
			}
			
		}
		
	}
	
	public static void generateTwinPrime(int i)
	{
		int last=(Integer)primeList.get(i-1);
		int last2=last-2;
		
        System.out.println("("+last2+", "+last+")");
	}
	
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		  Sieve(20000000,0);
		while(sc.hasNext())
		{

	         int nPrime=sc.nextInt();
	       
	         generateTwinPrime(nPrime); 
	     
		}
	}

}