
public class DynamicZeroOneKnapsack 
{
	
    public static void main(String[] args) 
    {
    	int weight[] = {2, 3, 4, 5};
    	int profit[] = {3, 4, 5, 6};
    	
    	int noOfItems = 4; // number of items
    	int knapsactCapacity = 5; //capacity of knapsack 

    
    	DynamicZeroOneKnapsack ob = new DynamicZeroOneKnapsack ();
        System.out.println(ob.knapsackDynamic(noOfItems, knapsactCapacity, weight, profit));
    }
    
    int knapsackDynamic(int n, int M, int w[], int p[])
    {
        int i,j;
     
        //create a matrix to memoize the values using dynamic programming
        int [][] knapsack = new int[n+1][M+1];
     
        //knapsack[i][j] denotes the maximum attainable value of items in knpasack with i available 
        //items and capacity of knapsack being j
     
        //initializing knapsack[0][j]=0 for 0<=j<=M because if there is no item, no value can be attained
        for(j=0;j<=M;j++)
            knapsack[0][j]=0;
     
        //initializing knapsack[i][0]=0 for 0<=i<=n, because in a bag of zero capacity, no item can be placed
        for(i=0;i<=n;i++)
            knapsack[i][0]=0;
     
        //now, filling the matrix in bottom up manner
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=M;j++)
            {
                //check if the weight of current item i is less than or equal to the capacity of sack,
                //take maximum of once including the current item and once not including
                if(w[i-1]<=j)
                {
                    knapsack[i][j]=Math.max(knapsack[i-1][j], p[i-1]+ knapsack[i-1][j-w[i-1]]);
                }
     
                //can not include the current item in this case
                else
                {
                    knapsack[i][j]=knapsack[i-1][j];
                }
            }
        }
     
     
        return knapsack[n][M];
     
     
    }

}

/*
 0 1 Knapsack Problem:
 Given weights and values of n items, put these items in a knapsack of capacity M to get the maximum total value in the knapsack.
Note that, you can select items, the sum of whose weight is less than or equal to the capacity of knapsack, W.


Problem Solution
The problem is to find a subset of items such that the sum of weight of all the items in the subset should be less than or equal to knapsack capacity
out of all subsets that satisfy criteria 1 above, the desired subset is the one in which the sum values of its items is maximum.
consider this example:

n=3
w[]=3 2 1
v[]=5 3 4

M=5

Create a matrix of order (n+1)*(M+1), ie. knapsack[n+1][M+1] 
knapsack[i][j]=maximum attainable value of items in the knapsack with i available items and capacity of knapsack being j.

Initialize:
knapsack[0][j]=0 for 0<=j<=M 
knapsack[i][0]=0 for 0<=i<=n 

Now, start filling the matrix row wise, following the given recursive formula:

knapsack[i][j]=	knapsack[i-1][j], if w[i]>j
max{knapsack[i-1][j], v[i]+knapsack[i-1][j-w[i]] } , if w[i]<=j

The time complexity of this solution is O(n*M).


Enter the no. of items 4
Enter the weight and price of all items
2 3
3 4
4 5
5 6
enter the capacity of knapsack  5
The maximum value of items that can be put into knapsack is 7

 * */
