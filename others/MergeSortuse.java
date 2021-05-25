
public class MergeSortuse 
{
	  public static int array[] = {5, 9, 4, 6, 5, 3,1,2,3,4};
	  //public static int array[] = {5, 6, 7, 8, 9};
	  //public static int array[] = {5,5,5,5};
	  //public static int array[] = {9,8,7,5};
	  public static int tempArray [] = new int[array.length];
		 
	//Divide and conquer
	public static void main(String args[])
	{
  
		MergeSortuse ob = new MergeSortuse();
		ob.TestMergeSort();
  	}
	
	public void TestMergeSort()
	{

		
		System.out.println("Before sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
		
		System.out.println();
		System.out.println();
		
		
		mergeSortAscending(array,0,array.length-1);
		//mergeSortDescending(array,0,array.length-1);
		
		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
	}
	
	public static void mergeSortAscending(int[] numArray, int low, int high) 
	{
	    if (low < high)
	    {
		    int mid = (low + high) / 2;
	
		    mergeSortAscending(numArray,low, mid);
		    mergeSortAscending(numArray,mid+1, high);
		 
		    mergeAscending(numArray,low,mid,high);
	    }
	}
	
	public static void mergeAscending(int[] numArray, int low, int mid, int high) 
	{
		int pos = low;
		
		int leftPtr = low;
		int rightPtr = mid +1;
		
		while (leftPtr <= mid &&  rightPtr <= high) 
		{
		   if (numArray[leftPtr] <=  numArray[rightPtr])
		   {
			   tempArray[pos] = numArray[leftPtr];
			   leftPtr++;
		   }
		   else
		   {
			   tempArray[pos] = numArray[rightPtr];
			   rightPtr++;
		   }
		   pos++;
			   
		}
		
		// if something still not copied, copy them
		if (leftPtr <= mid)
		{
			for(int k=leftPtr;k<=mid;k++)
			{
				tempArray[pos] = numArray[k];
				pos++;
			}
		}
		// if something still not copied, copy them
		else
		{
		
			for(int k=rightPtr;k<=high;k++)
			{
				tempArray[pos] = numArray[k];
				pos++;
			}
		}
		
		//transfer from the temporary array to the original array
		for(int k=low;k<=high;k++)
		{
			numArray[k] = tempArray[k];
		}

	}
	
	public static void mergeSortDescending(int[] numArray, int low, int high) 
	{
	    if (low < high)
	    {
		    int mid = (low + high) / 2;
	
		    mergeSortDescending(numArray,low, mid);
		    mergeSortDescending(numArray,mid+1, high);
		 
		    mergeDescending(numArray,low,mid,high);
	    }
	}
	
	public static void mergeDescending(int[] numArray, int low, int mid, int high) 
	{
		int pos = low;
		
		int leftPtr = low;
		int rightPtr = mid +1;
		
		while (leftPtr <= mid &&  rightPtr <= high) 
		{
		   if (numArray[leftPtr] >=  numArray[rightPtr])
		   {
			   tempArray[pos] = numArray[leftPtr];
			   leftPtr++;
		   }
		   else
		   {
			   tempArray[pos] = numArray[rightPtr];
			   rightPtr++;
		   }
		   pos++;
			   
		}
		
		// if something still not copied, copy them
		if (leftPtr <= mid)
		{
			for(int k=leftPtr;k<=mid;k++)
			{
				tempArray[pos] = numArray[k];
				pos++;
			}
		}
		// if something still not copied, copy them
		else
		{
		
			for(int k=rightPtr;k<=high;k++)
			{
				tempArray[pos] = numArray[k];
				pos++;
			}
		}
		
		//transfer from the temporary array to the original array
		for(int k=low;k<=high;k++)
		{
			numArray[k] = tempArray[k];
		}

	}
}
