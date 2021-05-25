import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MathPrimeFactor 
{
       HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
       public static BitSet bs;
       public static ArrayList<Integer> primeList=new ArrayList<Integer>();
    
	   public static void main(String args[])
	   {
		      int number;
		      Scanner sc = new Scanner(System.in);
		      System.out.println("Enter a number ::");
		      number = sc.nextInt();
		      
		      MathPrimeFactor ob = new MathPrimeFactor();
		      //ob.findPrimeFactor(number);
		      ob.findPrimeFactorEfficient(number);
		      ob.printFactorCounts();
		      
	   }
	   
	   public void findPrimeFactorEfficient(int number)
	   {
		      
		      sieve(number);  // stores the number in prime list
		      
		      for(int j = 0; j< primeList.size(); j++) 
		      {
		    	 int primeNum = primeList.get(j);
		    	  
		         while(number%primeNum == 0) 
		         {
		        	incrementFactorCount(primeNum);
		        	
		            System.out.println(primeNum+" ");
		            number = number/primeNum;
		         }
		      }
		      
		      if(number >=2) 
		      {
		    	 incrementFactorCount(number);  // this is also a factor
		         System.out.println(number);
		      }
	   }
	   
	   
	   public void findPrimeFactor(int number)
	   {
		      
		      // by generating the prime numbers in advance we can make it more efficient
		      for(int i = 2; i< number; i++) 
		      {
		         while(number%i == 0) 
		         {
		        	incrementFactorCount(i);
		        	
		            System.out.println(i+" ");
		            number = number/i;
		         }
		      }
		      
		      if(number >=2) 
		      {
		    	 incrementFactorCount(number);  // this is also a factor
		         System.out.println(number);
		      }
	   }
	   
	   public void incrementFactorCount(int factor)
	   {

            //use a hash map to store frequency, unnecessary though
	        if(frequencyMap.containsKey(factor))
	        {
	        	frequencyMap.put(factor, frequencyMap.get(factor)+1);
	        }
	        else
	        {
	           frequencyMap.put(factor, 1);
	        }
	         
	   }
	   
	   public void printFactorCounts()
	   {
		    System.out.println();
		    
		    System.out.println("Frequency extracted from a hash map...");
	        //maintain a heap of size k. 
	        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet())
	        {
	        	System.out.println("Factor:" + entry.getKey() + " Frequency:" + entry.getValue());
	        }
	        
	        System.out.println();
	   }
	   
		public void sieve(int UB)
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
