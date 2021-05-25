import java.util.ArrayList;
import java.util.BitSet;


public class PrimeSieve 
{

	public static BitSet bs;
	public static ArrayList primeList=new ArrayList();
	
	public static void main(String args[])
	{
  
		PrimeSieve ob = new PrimeSieve();
		ob.Sieve(20);
		
		int i = 0;
		i =i+1;

  	}
	
	public void Sieve(int UB)
	{
		UB++;
		bs = new BitSet(UB);
	  
		bs.set(0, UB);
		bs.clear(0);  //0 is not a prime
		bs.clear(1); // 1 is not a prime
		
		int i=0,k=0;
		
		for(i=2;i<=UB;i++)
		{
			if(bs.get(i))
			{
				primeList.add(i);
						
				//k=2;  //from second clear multiples
				for(k=2;k*i<=UB;k++)
					bs.clear(k*i);
							
			}
			
		}
		
	}

}
