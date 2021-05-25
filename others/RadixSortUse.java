import java.util.Arrays;


public class RadixSortUse {
/* See bottom of the file for code */
	
/*
 * Example: sorting in ascending order
 * 
 * For simplicity, consider the data in the range 0 to 9. 
 * 
Input data: 1, 4, 1, 2, 7, 5, 2
  1) Take a count array to store the count of each unique object.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  2  0   1  1  0  1  0  0

  2) Modify the count array such that each element at each index 
  stores the sum of previous counts. 
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  4  4  5  6  6  7  7  7

The modified count array indicates the position of each object in 
the output sequence.
 
  3) Output each object from the input sequence followed by 
  decreasing its count by 1.
  Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
  Put data 1 at index 2 in output. Decrease count by 1 to place 
  next data 1 at an index 1 smaller than this index.
  
  The above process is repeated for all digit positions (Least significant digit to most significant digit of the maximum valued number)
  
Input Array:
{550,55, 92, 40, 63, 51, 36,41,41,42}

Iteration 1: exp = 1

Counting sort after sorting based on least significant digit:
State of the original array after sorting:

[550, 40, 51, 41, 41, 92, 42, 63, 55, 36]

Iteration 2: exp = 10
Counting sort after sorting based on second digit from right:
State of the original array after sorting:

[36, 40, 41, 41, 42, 550, 51, 55, 63, 92]

Iteration 2: exp = 100
Counting sort after sorting based on based on most significant digit::
State of the original array after sorting:

[36, 40, 41, 41, 42, 51, 55, 63, 92, 550]
  */
	
	
	public static void main(String args[])
	{
  
		RadixSortUse ob = new RadixSortUse();
		ob.TestRadixSort();
  	}
	
	public void TestRadixSort()
	{
		int array[] = {550,55, 92, 40, 63, 51, 36,41,41,42};
		 //int array[] = {57,77,81,90};
		//int array[] = {5,5,5,5};
		//int array[] = {90,81,77,57};
		
		System.out.println("Before sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
		
		System.out.println();
		System.out.println();
		
		
		radixsortAscending(array,array.length);
		
		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
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


