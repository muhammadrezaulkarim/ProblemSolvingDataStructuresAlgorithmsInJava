import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class PrallelThreadPrimeNumbers 
{
	public static int NUMBER_OF_THREADS=Runtime.getRuntime().availableProcessors()*2;
	//public static int NUMBER_OF_THREADS=4;
	
	public static boolean [] inputArray=null;
	
	public void parallelThreadImplementation(final boolean[] inputArray, int startPos, int endPos) 
	{
		int totalSize= endPos - startPos + 1;
		int segmentSizeForEachThread=-1;
		
		double estimatedSize=totalSize / NUMBER_OF_THREADS;
		
		
		if( totalSize < NUMBER_OF_THREADS )
		{
			NUMBER_OF_THREADS=totalSize;
			segmentSizeForEachThread=1;
		}
		else
		{
			segmentSizeForEachThread = totalSize / NUMBER_OF_THREADS;
		}
		
		System.out.println("Number of threads used:" + NUMBER_OF_THREADS);
		
		Thread[] threadsArray = new Thread[NUMBER_OF_THREADS - 1];
		int offsetFromStartIndex = startPos;
		
		for (int i = 0; i < threadsArray.length - 1; i++) 
		{
			// Separate variable offsetFromStartIndex is required because of the final requirement
			final int fromIndex = offsetFromStartIndex;
			final int toIndex = fromIndex + segmentSizeForEachThread;
			
			threadsArray[i] = new Thread(new Runnable() 
			{
				@Override
				public void run() {
					converter(inputArray, fromIndex, toIndex);
				}
			});
			
			threadsArray[i].start();
			offsetFromStartIndex += segmentSizeForEachThread;
		}
		
		//perform rest of the operation on the main thread
		converter(inputArray, inputArray.length - segmentSizeForEachThread, inputArray.length);
		
		// wait for completion
		for (int i = 0; i < threadsArray.length  - 1; i++)
		{
			try 
			{
				threadsArray[i].join();
			} 
			catch (InterruptedException ignore) 
			{
				
			}
		
		}

		for (int i = startPos; i <= endPos; i++)
		{
			if(inputArray[i]==true)
				System.out.println(i + " is " +"Prime ");
		}
	}
	
	private void converter(boolean[] array, int fromIndex, int toIndex) 
	{
		//System.out.println("fromIndexIndex:" + fromIndex);
		  
	    for (int j = fromIndex; j < toIndex; j++)
	    {
	        array[j] = isPrime(j);
	       // System.out.println("Converted Number:" + array[j]);
	    }
	}
	
   private boolean isPrime(int num)
    {
        if (num % 2 == 0)
            return false;

        int divisorLimit = (int)Math.sqrt((int)num); // we have at least one divisior below square root of num 

        for (int i = 3; i <= divisorLimit; i += 2)
        {
            if (num % i == 0)
                return false;
        }

        return true;
    }
	
	public void inputArray()
	{
/*		System.out.println("Please enter numbers:");

		Scanner sc=null;
		ArrayList<Integer> tempArray=new ArrayList<Integer>();
		
		try 
		{
			sc=new Scanner(System.in);
			
			while(true)
			{
				int num=sc.nextInt();
				
				if(num==-999)
					break;
				
				tempArray.add(num);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		


		inputArray = new double[tempArray.size()];
		
		for(int i=0;i<inputArray.length;i++)
			inputArray[i]=tempArray.get(i);
		
		for(int i=0;i<inputArray.length;i++)
			System.out.println("Input:" + inputArray[i]);*/
		
	}
	
	
	public static void main(String args[])
	{

		
	    int minimum=3;
		int maximum=10000000;
		inputArray = new boolean[maximum+1];
		
		for(int i=0;i<inputArray.length;i++)
			inputArray[i]=false;
		
		
		PrallelThreadPrimeNumbers ob=new PrallelThreadPrimeNumbers();
		ob.inputArray();
		ob.parallelThreadImplementation(inputArray,minimum,maximum);
	}

}


