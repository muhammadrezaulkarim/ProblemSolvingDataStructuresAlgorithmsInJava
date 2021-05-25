
public class InsertionSortUse 
{
	
	public static void main(String args[])
	{
  
		InsertionSortUse ob = new InsertionSortUse();
		ob.TestInsertionSort();
  	}
	
	public void TestInsertionSort()
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
		

		insertionSort(array);
		//bubbleSortDescending(array);
		
		System.out.println("After sorting...");
		for(int i =0; i<array.length; i++ )
		  System.out.print(array[i] + " ");
		
	}
	
	   public void insertionSort(int[] array)
	   {
	         
	        int temp;
	        
	        for (int i = 1; i < array.length; i++) 
	        {
	            for(int j = i ; j > 0 ; j--)
	            {
	                if(array[j] < array[j-1])
	                {
	                    temp = array[j];
	                    array[j] = array[j-1];
	                    array[j-1] = temp;
	                }
	            }
	        }

	    }
}
