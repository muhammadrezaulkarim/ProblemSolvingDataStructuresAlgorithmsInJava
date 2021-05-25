
public class ShortestPathFloyd 
{
	public static int NO_OF_VERTICES = 4;
	
	public static void main(String args[])
	{
  
		ShortestPathFloyd  ob = new ShortestPathFloyd();
		ob.compute();
  	}
	
	public void compute()
	{
		int parent[][] = new int[NO_OF_VERTICES ][NO_OF_VERTICES];
		double distance[][] = new double[NO_OF_VERTICES ][NO_OF_VERTICES];
		
		
		for (int i=0;i<NO_OF_VERTICES;i++)
			for(int j=0;j<NO_OF_VERTICES;j++)
				distance[i][j] = Double.MAX_VALUE;  
		
		distance[0][0] = 0.0;  // set distnce to 0
		distance[0][1] = 5.0;
		distance[0][2] = Double.MAX_VALUE;  // not adjacent
		distance[0][3] = Double.MAX_VALUE;  // not adjacent
		
		distance[1][0] = 50.0;
		distance[1][1] = 0.0;  // set distance to 0
		distance[1][2] = 15.0;  
		distance[1][3] = 5.0;  
		
		distance[2][0] = 30.0;
		distance[2][1] =  Double.MAX_VALUE;;  // not adjacent
		distance[2][2] = 0.0;  // set distance to 0
		distance[2][3] = 15.0;  
		
		distance[3][0] = 15.0;
		distance[3][1] =  Double.MAX_VALUE;;  // not adjacent
		distance[3][2] = 5.0;  
		distance[3][3] = 0.0;  // set distance to 0
		
		floydShortestDynamicProgramming(parent, distance);
		
		System.out.println(distance[2][1]);
		System.out.println();
		printPath(2,1, parent);
			
	}
	
	public void floydShortestDynamicProgramming(int parent[][], double distance[][])
	{
		
		for (int i=0;i<NO_OF_VERTICES;i++)
			for(int j=0;j<NO_OF_VERTICES;j++)
				parent[i][j] = i;  //initialize the parent marix to find path
				
		
		for (int k=0;k<NO_OF_VERTICES;k++)
		{
		   for (int i=0;i<NO_OF_VERTICES;i++)
		   {
			  for(int j=0;j<NO_OF_VERTICES;j++)
			  {
				  if (i!=j)
				  {
					  if ( distance[i][k] + distance[k][j] < distance[i][j])
					  {
						  distance[i][j] = distance[i][k] + distance[k][j];
						  parent[i][j] = parent[k][j];
					  }
				  }
			  }
		   }
		}
		
	}
	
	
	public void printPath(int i, int j, int parent[][])
	{
		if(i!=j)
		{
			 printPath(i,parent[i][j],parent);
		}
		System.out.print(j + " ");
	}

}
