
public class QuickSortUse 
{
	/* 
	 * Divide and conquer:
	1. Choose an element from the list as pivot (can be chosen at random). Use pivot to divide the list into two sub-lists.
	2. For sorting in ascending order, Reorder all the elements around the pivot – the ones with smaller value are placed before it, 
	and all the elements greater than the pivot after it. After this step, the pivot is in its final position. 
	3. Apply steps 1 and 2 recursively to both sub-lists on the left and right of the pivot.
   */
	
	public static void main(String args[])
	{
  
		QuickSortUse  ob = new QuickSortUse();
		ob.TestQuickSort();
  	}
	
	public void TestQuickSort()
	{
		 int array[] = {5, 9, 4, 6, 5, 3,1,2,3,4};
		//int array[] = {5, 6, 7, 8, 9};
		//int array[] = {5,5,5,5};
		//int array[] = {9,8,7,5};
		
		System.out.println("Before sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
		
		System.out.println();
		System.out.println();
		
		
		int begin = 0;
		int end = array.length -1;
		
		//quickSortAscending(array, begin, end);
		quickSortDesccending(array, begin, end);
		
		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
	}
	
	public static void quickSortAscending(int numArray[], int start, int end) {
	    
		if (start >= end) 
			return;
	    
	    int splitIndex = partitionAscending(numArray, start, end);
	    
	    //quickSortAscending(numArray, start, splitIndex-1);
	    quickSortAscending(numArray, splitIndex+1, end);
	    
	}
	
	
	private static int partitionAscending(int numArray[], int startIndex, int endIndex) 
	{
		
		int pivotValue = numArray[endIndex];
				
		int leftPointer = startIndex;
		int rightPointer = endIndex-1;
		
		
		while (true)
		{
			// increase the left pointer as long as it is less than the pivot
			while(numArray[leftPointer] <= pivotValue && leftPointer < endIndex)
				leftPointer++;
			
			// decrease the left pointer as long as it is greater than the pivot
			while(numArray[rightPointer] >= pivotValue && rightPointer > startIndex)
				rightPointer--;
			
			if (leftPointer >= rightPointer)
				break;
			else
			{
				int temp = numArray[leftPointer];
	            numArray[leftPointer] = numArray[rightPointer];
	            numArray[rightPointer] = temp;
			}
			
		}
		
		// restore pivot to the right place 
		int temp = numArray[leftPointer];
		numArray[leftPointer] = numArray[endIndex];
		numArray[endIndex] = temp;
		
		return leftPointer;
		
	}
	
	public static void quickSortDesccending(int numArray[], int start, int end) {
	    
		if (start >= end) 
			return;
	    
	    int splitIndex = partitionDescending(numArray, start, end);
	    
	    quickSortDesccending(numArray, start, splitIndex-1);
	    quickSortDesccending(numArray, splitIndex+1, end);
	    
	}
	
	
	private static int partitionDescending(int numArray[], int startIndex, int endIndex) 
	{
		
		int pivotValue = numArray[endIndex];
				
		int leftPointer = startIndex;
		int rightPointer = endIndex-1;
		
		
		while (true)
		{
			// increase the left pointer as long as it is less than the pivot
			while(numArray[leftPointer] >= pivotValue && leftPointer < endIndex)
				leftPointer++;
			
			// decrease the left pointer as long as it is greater than the pivot
			while(numArray[rightPointer] <= pivotValue && rightPointer > startIndex)
				rightPointer--;
			
			if (leftPointer >= rightPointer)
				break;
			else
			{
				int temp = numArray[leftPointer];
	            numArray[leftPointer] = numArray[rightPointer];
	            numArray[rightPointer] = temp;
			}
			
		}
		
		// restore pivot to the right place 
		int temp = numArray[leftPointer];
		numArray[leftPointer] = numArray[endIndex];
		numArray[endIndex] = temp;
		
		return leftPointer;
		
	}
}
