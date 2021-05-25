public class BinarySearchUse
{
    private static final int EACH_BUCKET_SIZE = 10;
    
	public static void main(String args[])
	{
  
		BinarySearchUse  ob = new BinarySearchUse();
		ob.testBinarySearch();
  	}
	
	public void testBinarySearch()
	{

		int array[] = {5, 6, 7, 8, 9, 10};

		
		System.out.println("Numbers in the input array...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
		
		System.out.println();
		System.out.println();
		

		//bucketSortAscending(array);
		int index = binarySearch(array,7,0,array.length-1);
		System.out.println(index);
		
		index = binarySearch(array,1,0,array.length-1);
		System.out.println(index);
				
		

	}
	
	int binarySearch(int array[], int val, int low, int high)
	{
		if (low > high) 
			return -1; // returns -1 if not found
		
		int mid = (low +high)/2;
		
		if (array[mid] < val)
			return binarySearch(array,val,mid+1, high);
		else if (array[mid] > val)
			return binarySearch(array,val,low, mid-1);
		else
			return mid;
		
	}
}
