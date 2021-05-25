import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BucketSortUse 
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
  
		BucketSortUse  ob = new BucketSortUse();
		ob.TestBucketSort();
  	}
	
	public void TestBucketSort()
	{

		 //Integer array[] = {50, 900, 4, 6, 5, 3,1,2,3,4};
		Integer array[] = {5, 5, 5, 4, 4, 4,1,1,1,4};
		//Integer array[] = {5, 6, 7, 8, 9};
		//Integer array[] = {5,5,5,5};
		 //Integer array[] = {9,8,7,5};
		
		System.out.println("Before sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
		
		System.out.println();
		System.out.println();
		

		bucketSortAscending(array);
		//bucketSortDescending(array);
		
		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
	}

    public static void bucketSortAscending(Integer[] numArray) 
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
        
        int numberOfBuckets = ((maxNumber - minNumber) / EACH_BUCKET_SIZE) + 1;
        
        //use minimum two buckets
        if (numberOfBuckets ==1)
        	numberOfBuckets++;
        
        //int numberOfBuckets = (maxNumber - minNumber);
        
      
        
        // add one arraylist for each bucket
        for (int i = 0; i < numberOfBuckets; i++) 
        {
        	bucketList.add(new ArrayList<Integer>());
        }
        
        
       // Distribute input array values into buckets
        for (int i = 0; i < numArray.length; i++) 
        {
        	// get a bucket index and insert the values
        	int bucketIndex = (numArray[i] - minNumber)/ numberOfBuckets;
        	
        	if (bucketIndex == numberOfBuckets)
         	   bucketIndex--;
        	
        	bucketList.get(bucketIndex).add(numArray[i]);
        }

        // first Sort each bucket and place the values back into the original input array
        int position = 0;
        for (int i = 0; i <bucketList.size(); i++) 
        {
          /*     Integer[] bucketArray = new Integer[bucketList.get(i).size()];
            bucketArray = bucketList.get(i).toArray(bucketArray);
            
            //InsertionSort.sort(bucketArray);  // you can use any sort here
            Arrays.sort(bucketArray);

            
            for (int j = 0; j < bucketArray.length; j++) 
            {
                array[currentIndex++] = bucketArray[j];
            }*/
            

            //Collections.sort(bucketList.get(i),Collections.reverseOrder());
        	if ( bucketList.size() > 0)
        	{
	        	Collections.sort(bucketList.get(i));
	           
	            for (int j = 0; j < bucketList.get(i).size(); j++) 
	            {
	            	numArray[position++] = bucketList.get(i).get(j);
	            }
        	}
        }
    }
    
    public static void bucketSortDescending(Integer[] numArray) 
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
        
        int numberOfBuckets = ((maxNumber - minNumber) / EACH_BUCKET_SIZE) + 1;
       //use minimum two buckets
        if (numberOfBuckets ==1)
        	numberOfBuckets++;
        
        // add one arraylist for each bucket
        for (int i = 0; i < numberOfBuckets; i++) 
        {
        	bucketList.add(new ArrayList<Integer>());
        }
        
        
       // Distribute input array values into buckets
        for (int i = 0; i < numArray.length; i++) 
        {
        	// get a bucket index and insert the values
        	int bucketIndex = (maxNumber - numArray[i])/ numberOfBuckets;
        	
        	if (bucketIndex == numberOfBuckets)
        	   bucketIndex--;
        			
         	bucketList.get(bucketIndex).add(numArray[i]);
        }

        // first Sort each bucket and place the values back into the original input array
        int position = 0;
        for (int i = 0; i <bucketList.size(); i++) 
        {
          /*     Integer[] bucketArray = new Integer[bucketList.get(i).size()];
            bucketArray = bucketList.get(i).toArray(bucketArray);
            
            //InsertionSort.sort(bucketArray);  // you can use any sort here, must be descending order
            Arrays.sort(bucketArray,,Collections.reverseOrder());

            
            for (int j = 0; j < bucketArray.length; j++) 
            {
                array[currentIndex++] = bucketArray[j];
            }*/
            
          	if ( bucketList.size() > 0)
        	{
	            Collections.sort(bucketList.get(i),Collections.reverseOrder());
	           
	            for (int j = 0; j < bucketList.get(i).size(); j++) 
	            {
	            	numArray[position++] = bucketList.get(i).get(j);
	            }
        	}
        }
    }

	
}
