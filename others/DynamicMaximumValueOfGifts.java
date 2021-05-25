
public class DynamicMaximumValueOfGifts
{
	
    public static void main(String[] args) 
    {
		double [][] giftValues =
		{
			{ 1,10,3,8 },
			{ 12, 2, 9, 6 },
			{5, 7, 4, 11},
			{3,7,16,5}
		};
    	
		
    	DynamicMaximumValueOfGifts  ob = new DynamicMaximumValueOfGifts();
        System.out.println(ob.maxValueGifts(giftValues));
    }
    
    
    public double maxValueGifts(double [][] gifts)
    {
    	int rowCount = gifts.length;
		int colCount = gifts[0].length;
		
        //vector to store results
        double solution[][] = new double[rowCount][colCount];
     
        //solution[i][j]=maximum attainable value of gifts for the matrix of rows i and columns j only
        
		//initialize the first row
		for (int i = 0; i < rowCount; i++) 
		{
			if (i == 0 )
				solution[i][0] = gifts[i][0];
			else
			   solution[i][0] = solution[i-1][0] + gifts[i][0];
						
		}
		
		//initialize the first column
		for (int j = 0; j < colCount; j++) 
		{
			if (j == 0 )
				solution[0][j] = gifts[0][j];
			else
				solution[0][j] = solution[0][j-1] + gifts[0][j];
						
		}
		
     
        for(int i=1;i<rowCount;i++)
        {
            for(int j=1;j<colCount;j++)
            {
                //There are two ways to reach colums (i,j)
                //one from above and one from left, pick the one which gives more value 
            	solution[i][j]=Math.max(solution[i][j-1],solution[i-1][j])+gifts[i][j];
            }
     
        }
     
        return solution[rowCount-1][colCount-1];
    }

}

/*
 * 
 * 
 * You are given a matrix of order N*M. Each cell of the matrix has a gift of certain value.
Starting from the top-left cell, you have to reach the bottom-right cell of the matrix collecting gifts of the visited cells. 
 *  But you can visit either the cell below the current cell or the cell to right of current cell.
 *   Determine the maximum value of gifts you can collect.
 *   
 *   
Input:

1 10 3 8
12 2 9 6
5 7 4 11
3 7 16 5

Output:
maximum attainable value of gifts
53
 *   
 *   */
