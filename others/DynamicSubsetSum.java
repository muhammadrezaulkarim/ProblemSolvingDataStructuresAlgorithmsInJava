//There is a subset A of n positive integers and a value sum. 
//Find whether or not there exists any subset of the given set, 
//the sum of whose elements is equal to the given value of sum


public class DynamicSubsetSum 
{
	public static boolean [][] solutionExists = null;
	
    public static void main(String[] args) 
    {
    	int array[] = {92, 40, 63, 51, 36,41,41,42};
    	int targetSum = 154;
    	
    
    	
    	DynamicSubsetSum  ob = new DynamicSubsetSum();
        System.out.println(ob.subsetSum(array, array.length,targetSum));
    }
    
    boolean subsetSum(int array[],int n, int targetSum)
    {
    	solutionExists = new boolean[n +1][targetSum+1];
    	
        //solutionExists[i][j] indicates whether there is a subset of sum j in the subarray array[0....i-1]
     
        int i=0,j=0;
     
        //for sum=0, there is always a subset possible (the empty set)
        for(i=0;i<=n;i++)
        	solutionExists[i][0]=true;
     
        //if there are no elements in the array, no subset is possible for a non-zero sum
        for(j=1;j<=targetSum;j++)
        	solutionExists[0][j]=false;
     
        //i represents the number of elements of array considered
        for(i=1;i<=n;i++)
        {
            //j represents the sum of subset being searched for
            for(j=1;j<=targetSum;j++)
            {
                //if using i-1 elements, there is a subset of desired sum no need to search further
                if(solutionExists[i-1][j]==true)
                	solutionExists[i][j]=true;
     
                else
                {
                    //if value of current element is greater than the required sum
                    //this element cannot be considered
                    if(array[i-1]>j)
                    	solutionExists[i][j]=false;
                        //check that after including this element, Is there any subset present for the remaining sum ie., j-array[i-1]
                    else
                    	solutionExists[i][j]=solutionExists[i-1][j-array[i-1]];
                }
            }
        }
     
        //return the overall result
        return solutionExists[n][targetSum];
    }

}
