
public class DynamicLongestIncreasingSubsequence 
{
    public static void main(String[] args) 
    {
    	//int array[] = {92, 40, 63, 51, 36,41,41,42};
    	int array[] = {6, 2, 10, 0, 8, 4, 12, 1, 7, 3, 11, 1, 9, 5, 13};
    	
      	DynamicLongestIncreasingSubsequence ob = new DynamicLongestIncreasingSubsequence();
        System.out.println(ob.longestIncreasingSubsequence(array, array.length));
    }
    
    int longestIncreasingSubsequence(int array[], int n)
    { 
        int i, j;
     
        //create an array solution of size n 
        //solution[i]=longest increasing subsequence for the array array[0...i] by including array[i] in the subsequence at the end
     
        int solution[] = new int[n];
     
        //Since, we are definitely including array[i] for the calculation of solution[i], solution[i] will 
        //either be equal to 1 or greater than 1. so, initialize solution
        for(i=0;i<n;i++)
        	solution[i]=1;
     
     
        //now, we have to fill this solution array
     
        //we will calulate the value of solution[i] for every 1<=i<=n by checking whether any subsequence
        //solution[0], solution[1],...,solution[i-1] can fit before array[i] and then selecting the maximum out of them
        for(i=1;i<n;i++)
        {
            //for every i, we will check all values of 0<=j<i for subsequences solution[j] to which array[i]
            //could be appended and select the longest one
            for(j=0;j<i;j++)
            {
                //if the current element ie, the ith element has value greater than jth element, that
                //means a[i] can be appended after solution[j]
                //Since, we are interested in finding the longest of such subsequences, we will consider
                //only those values of solution[j] that are greater than or equal to solution[i]
                if(array[i]>array[j] && solution[i]<solution[j]+1)
                {
                	solution[i]=solution[j]+1;
                }
            }
        }
     
        //now, we have calculated all the values of solution[i] for 0<=i<n
        //The length of the longest increasing subsequence of the given array is the maximum of all
        //these values because the longest increasing subsequence can end with any element of the array
     
        //finding maximum element in solution array
        int max=0;
     
        for(i=0;i<n;i++)
        {
            if(solution[i]>max)
                max=solution[i];
        }
     
        return max;
     
     
    }

}

/*
 * 

 Given a sequence of n real numbers A(1) … A(n), determine a subsequence (not necessarily contiguous) of maximum length
 in which the values in the subsequence form a strictly increasing sequence Problem Solution.
 
 n=5
A[]={1, 4, 2, 4, 3}
Longest Increasing subsequece (LIS) = 3 formed by {1, 2, 3} or {1, 2, 4}


n=15
A[]={6, 2, 10, 0, 8, 4, 12, 1, 7, 3, 11, 1, 9, 5, 13}
LIS=5 formed by {2, 4, 7, 9, 13} or { 2, 4, 7, 11, 13}
 */
