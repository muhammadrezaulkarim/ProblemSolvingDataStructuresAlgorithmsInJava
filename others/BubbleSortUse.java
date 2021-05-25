
public class BubbleSortUse 
{
	/* 
	1. Set current to the index of first item in the array
	2. While more items in unsorted part of array:
		“Bubble up” the smallest item in the unsorted part causing intermediate swaps as needed
		Shrink the unsorted part of the array by incrementing current
	*/
	
	public static void main(String args[])
	{
  
		BubbleSortUse  ob = new BubbleSortUse();
		ob.TestBubbleSort();
  	}
	
	public void TestBubbleSort()
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
		

		bubbleSortAscending(array);
		//bubbleSortDescending(array);
		
		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
	}
	
	 
	 public static void bubbleUpAscending(int arr[], int startIndex, int endIndex)
	// Post: Adjacent pairs that are out of order have been switched
	// between values[startIndex]..values[endIndex] beginning at
	// values[endIndex]
	{
		for (int index = endIndex; index > startIndex; index--)
		{
			if (arr[index] < arr[index - 1])
			{
			   int temp = arr[index]; 
	           arr[index] = arr[index-1]; 
	           arr[index-1] = temp; 
			}
		}
	}
	 
	public static void bubbleSortAscending(int arr[])
		// Post: The elements in the array values are sorted
	{
		int current = 0;
		while (current < arr.length - 1)
		{
			bubbleUpAscending(arr, current, arr.length -1);
			current++;
		}
	}
	
	 public static void bubbleUpDescending(int arr[], int startIndex, int endIndex)
	// Post: Adjacent pairs that are out of order have been switched
	// between values[startIndex]..values[endIndex] beginning at
	// values[endIndex]
	{
		for (int index = endIndex; index > startIndex; index--)
		{
			if (arr[index] > arr[index - 1])
			{
			   int temp = arr[index]; 
	           arr[index] = arr[index-1]; 
	           arr[index-1] = temp; 
			}
		}
	}
	 
	public static void bubbleSortDescending(int arr[])
		// Post: The elements in the array values are sorted
	{
		int current = 0;
		while (current < arr.length - 1)
		{
			bubbleUpDescending(arr, current, arr.length -1);
			current++;
		}
	}
}
