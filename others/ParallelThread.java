import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class ParallelThread 
{
	public static int NTHREADS=4;
	public static double [] inputArray=null;
	
	public void parallelNumberConversion(final double[] array) 
	{
		Thread[] threads = new Thread[NTHREADS - 1];
		final int segmentLen = array.length / NTHREADS;
		
		int offset = 0;
		for (int i = 0; i < NTHREADS - 1; i++) 
		{
			final int from = offset;
			final int to = offset + segmentLen;
			threads[i] = new Thread(new Runnable() 
			{

				@Override
				public void run() {
					converter(array, from, to);
				}
			});
			
			threads[i].start();
			offset += segmentLen;
		}
		
		// do last segment on main thread
		converter(array, array.length - segmentLen, array.length);
		
		// wait for completion
		for (int i = 0; i < NTHREADS - 1; i++)
		{
			try 
			{
				threads[i].join();
			} 
			catch (InterruptedException ignore) 
			{
				
			}
		
		}
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println("Converted Number:" + array[i]);
		}
	}
	
	private void converter(double[] array, int from, int to) 
	{
		System.out.println("fromIndex:" + from);
		  
	    for (int j = from; j < to; j++)
	    {
	        array[j] = Math.log(j);
	       // System.out.println("Converted Number:" + array[j]);
	    }
	}
	
	public void inputArray()
	{
		System.out.println("Please enter numbers:");

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
			System.out.println("Input:" + inputArray[i]);
		
	}
	
	public static void main(String args[])
	{
		ParallelThread ob=new ParallelThread();
		ob.inputArray();
		ob.parallelNumberConversion(inputArray);
	}

}

