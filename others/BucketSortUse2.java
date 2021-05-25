import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;



public class BucketSortUse2
{
	/*
		1. Create N empty buckets
		2. Insert each element of the input array into one bucket based on a hashing rule
		3. Sort individual buckets using insertion sort (or any other sort)
		4. Concatenate all sorted buckets and place in the original array
	*/
	
    private static final int EACH_BUCKET_SIZE = 10;
    
	public static void main(String args[])
	{
  
		BucketSortUse2  ob = new BucketSortUse2();
		ob.TestBucketSort();
  	}
	
	public void TestBucketSort()
	{

		 //Integer array[] = {50, 900, 4, 6, 5, 3,1,2,3,4};
		Integer array[] = {5, 5, 5, 4, 4, 4,1,1,1,4,0,0,9,9,8,8,2,2};
		//Integer array[] = {5, 6, 7, 8, 9};
		//Integer array[] = {5,5,5,5};
		//Integer array[] = {9,8,7,5};
		
		System.out.println("Before sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
		
		System.out.println();
		System.out.println();
		

		bucketSortAscending(array);
		
		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
	}

    public void bucketSortAscending(Integer[] numArray) 
    {
        if (numArray.length == 0)
            return;
        

        // Determine minimum and maximum values
        Integer minNumber = numArray[0];
        Integer maxNumber = numArray[0];
        for (int i = 1; i < numArray.length; i++) {
            if (numArray[i] < minNumber) {
            	minNumber = numArray[i];
            } else if (numArray[i] > maxNumber) {
            	maxNumber = numArray[i];
            }
        }

        // Initialise buckets
        ArrayList<ArrayList<Integer>> bucketList = new  ArrayList<ArrayList<Integer>>();
        

        //create one bucket for each possible number 
        // add one arraylist for each bucket
        for (int i = 0; i <= maxNumber; i++) 
        {
        	bucketList.add(new ArrayList<Integer>());
        }
        
        HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();
 
       // Distribute input array values into buckets
        for (int i = 0; i < numArray.length; i++) 
        {
        	// for bucket sort
        	bucketList.get(numArray[i]).add(numArray[i]);
        	
            //use a hash map to store frequency, unnecessary though
        	if(mymap.containsKey(numArray[i]))
        	{
        		mymap.put(numArray[i], mymap.get(numArray[i])+1);
            }
        	else{
            	mymap.put(numArray[i], 1);
            }
        }
        
        
    	System.out.println("Frequency extracted from a hash map...");
        //maintain a heap of size k. 
        for(Map.Entry<Integer, Integer> entry: mymap.entrySet())
        {
        	System.out.println("Number:" + entry.getKey() + " Frequency:" + entry.getValue());
        }
        
        System.out.println();
        
        
        // use it to construct max heap
        PriorityQueue<NumberFrequencyPair> maxHeap = new PriorityQueue<>(new Comparator<NumberFrequencyPair>(){
       	 
            @Override
            public int compare(NumberFrequencyPair o1, NumberFrequencyPair o2) {
                return o2.frequency.compareTo(o1.frequency);
            }
        });
  
        // use it to construct mean heap
/*        PriorityQueue<NumberFrequencyPair> maxHeap = new PriorityQueue<>(new Comparator<NumberFrequencyPair>(){
          	 
            @Override
            public int compare(NumberFrequencyPair o1, NumberFrequencyPair o2) {
                return o1.frequency.compareTo(o2.frequency);
            }
        });*/
 

        // first Sort each bucket and place the values back into the original input array
        int position = 0;
        
        int topK = 5;
 
        for (int i = 0; i <bucketList.size(); i++) 
        {
           
        	if ( bucketList.size() > 0)
        	{
        		
	            for (int j = 0; j < bucketList.get(i).size(); j++) 
	            {
	            	numArray[position++] = bucketList.get(i).get(j);
	            }
	            
	            maxHeap.add(new NumberFrequencyPair(i,bucketList.get(i).size()));
        	}
            
        }
        
           
		System.out.println("Frequency extracted from a priority queue...");
        Iterator queIterator1 = maxHeap.iterator();
        while (queIterator1.hasNext())
        {
        	NumberFrequencyPair ob=(NumberFrequencyPair)queIterator1.next();
        	System.out.println("Number:" + ob.number + " Frequency:" + ob.frequency);
        }
		
 /*       for(int i=1;i<=topK;i++)
        {
        	NumberFrequencyPair ob = maxHeap.poll();
        	System.out.println("Number:" + ob.number + " Frequency:" + ob.frequency);
        }*/
        
        System.out.println();
        
    }

    
    class NumberFrequencyPair implements Comparable<NumberFrequencyPair> 
    {
        Integer number;
        Integer frequency;
        
        public NumberFrequencyPair(Integer number, Integer frequency)
        {
            this.number=number;
            this.frequency=frequency;
        }
   	 
	    @Override
	    public int compareTo(NumberFrequencyPair o) {
	        return this.frequency.compareTo(o.frequency);
	    }
    }
    
/*    class NumberFrequencyPair implements Comparable<NumberFrequencyPair> 
    {
        Integer number;
        Integer frequency;
        
        public NumberFrequencyPair(Integer number, Integer frequency)
        {
            this.number=number;
            this.frequency=frequency;
        }
   	 
        @Override
	    public int compareTo(NumberFrequencyPair o) {
	        return this.frequency.compareTo(o.frequency);
	    }
    }*/
}
