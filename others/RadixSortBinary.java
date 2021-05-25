import java.util.HashMap;
import java.util.HashMap;


/* can sort number from any base***/

public class RadixSortBinary {

	public static HashMap<Integer, String> mapper= new HashMap<Integer, String>();
    private static final int ORIGINAL_NUMBER_BASE = 2;
	
	public static void main(String args[])
	{
  
		RadixSortBinary ob = new RadixSortBinary();
		ob.TestRadixSort();
  	}
	
	public void TestRadixSort()
	{
		String arraystr[] = {"111", "001", "010", "011", "100", "101", "110","000"}; 
	    int array[] = new int[arraystr.length];

		 //int array[] = {57,77,81,90};
		//int array[] = {5,5,5,5};
		//int array[] = {90,81,77,57};
		

		
		
		System.out.println();
		System.out.println();
		
		for(int i=0;i<arraystr.length;i++)
		{
		  array[i] = getHashedValueForOtherNumberBase(arraystr[i]);
		  
		  mapper.put(array[i], arraystr[i]);
		}
		
		System.out.println("Before sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
		radixsortAscending(array,array.length);
		
/*		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");*/
		

		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(mapper.get(array[i]) + " ");
		
	}
	
	
public int getHashedValueForOtherNumberBase(String str)
{
	int val=0;
	int multi = 1;
	
	for(int i=str.length()-1;i>=0;i--)
	{
		val +=(str.charAt(i)-'0')*multi;
	    multi*=ORIGINAL_NUMBER_BASE;
	}
	    
	return val;
}

	
// The main function to that sorts arr[] of size n using 
// Radix Sort 
public static void radixsortAscending(int arr[], int n) 
{ 
  // Find the maximum number to know number of digits 
  int m = getMaximum(arr, n); 

  // Do counting sort for every digit. Note that instead 
  // of passing digit number, exp is passed. exp is 10^i 
  // where i is current digit number 
  
  // Repeat the loop for each digit of the maximum number found earlier. (trick applied: m/exp > 0 )
  for (int exp = 1; m/exp > 0; exp *= 10) 
  	countSortAscending(arr, n, exp); 
}

// A utility function to get maximum value in arr[] 
public static int getMaximum(int arr[], int n) 
{ 
  int max = arr[0]; 
  for (int i = 1; i < n; i++) 
  {
      if (arr[i] > max) 
          max = arr[i]; 
  }
  return max; 
} 

// A function to do counting sort of arr[] according to 
// the digit represented by exp. 
public static void countSortAscending(int arr[], int n, int exp) 
{ 
  int tempArray[] = new int[n]; // output array 
  int i; 
  // 10 buckets required for 10 individual digits (0, 1-9)
  int bucket[] = new int[10]; 
  //Arrays.fill(bucket,0); 

  // Store count of occurrences in count[] 
  for (i = 0; i < n; i++) 
  	bucket[ (arr[i]/exp)%10 ]++; 
  

  //Modify the count array such that each element at each index stores the sum of previous counts (cumulative sum).
  //The modified count array indicates the position of each object in the output sequence.
  // for example, if bucket[1] contains 1 and  bucket[2] contains 5, means we have secured 5 positions in the output array for numbers with digit 1 and 2
  
  for (i = 1; i < 10; i++) 
  	bucket[i] += bucket[i - 1]; 

  // Output each object from the input sequence in the auxiliary array followed by decreasing its count by 1 starting from last index of the input array
  for (i = n - 1; i >= 0; i--) 
  { 
  	tempArray[bucket[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
      bucket[ (arr[i]/exp)%10 ]--; 
  } 

  // Copy the output array to arr[], so that arr[] now 
  // contains sorted numbers according to curent digit 
  for (i = 0; i < n; i++) 
      arr[i] = tempArray[i]; 
} 

    
}

