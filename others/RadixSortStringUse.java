import java.util.Arrays;


public class RadixSortStringUse {

	
	public static void main(String args[])
	{
  
		RadixSortStringUse ob = new RadixSortStringUse();
		ob.TestRadixSort();
  	}
	
	public void TestRadixSort()
	{
		//String array[] = {"aag", "bbe", "eed", "ppf", "sssd", "aaa", "aad"}; 
		String array[] = {"a", "apple", "and", "ant", "ball", "boul", "xmas"}; 

		 //int array[] = {57,77,81,90};
		//int array[] = {5,5,5,5};
		//int array[] = {90,81,77,57};
		
		System.out.println("Before sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
		
		System.out.println();
		System.out.println();
		
		
		radixsort(array,array.length);
		
		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
	}
	
	   // The main function to that sorts arr[] of size n using 
    // Radix Sort 
    public static void radixsort(String arr[], int n) 
    { 
        // Find the maximum number to know number of digits 
        int m = getMaximum(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        
        // For string sorting, w ehave to start from the least significant letter (leftmost letter of each string)
        // number sorting also starts with least significant digit
        for (int pos = m-1; pos >=0; pos--) 
        	countSort(arr, n, pos); 
    }
    
    // A utility function to get maximum value in arr[] 
    public static int getMaximum(String arr[], int n) 
    { 
        int max = arr[0].length(); 
        for (int i = 1; i < n; i++) 
        {
            if (arr[i].length() > max) 
                max = arr[i].length(); 
        }
        return max; 
    } 
    
    public static int getBucketIndex(String str, int pos)
    {
    	int bucketIndex=-1;
    	
        if (pos < str.length())
      	  bucketIndex = str.charAt(pos);
        else
      	   bucketIndex = ' ' ;  // when no letter at a position, consider it as zero
       
        return bucketIndex;
       
    }
   
    // A function to do counting sort of arr[] according to 
    // the digit represented by exp. 
    public static void countSort(String arr[], int n, int pos) 
    { 
        String tempArray[] = new String[n]; // output array 
        int i; 
        // 10 buckets required for 10 individual digits (0, 1-9)
        int bucket[] = new int[256]; 
        //Arrays.fill(bucket,0); 

        int bucketIndex=-1;
        
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            bucket[getBucketIndex(arr[i],pos)]++; 
        
  
        //Modify the count array such that each element at each index stores the sum of previous counts (cumulative sum).
        //The modified count array indicates the position of each object in the output sequence.
        // for example, if bucket[1] contains 1 and  bucket[2] contains 5, means we have secured 5 positions in the output array for numbers with digit 1 and 2
        
        for (i = 1; i < 256; i++) 
        	bucket[i] += bucket[i - 1]; 
  
        // Output each object from the input sequence in the auxiliary array followed by decreasing its count by 1 starting from last index of the input array
        for (i = n - 1; i >= 0; i--) 
        { 
        	bucketIndex = getBucketIndex(arr[i],pos);
        	tempArray[bucket[ bucketIndex ] - 1] = arr[i]; 
            bucket[ bucketIndex ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = tempArray[i]; 
    } 
    
}
