import java.math.BigInteger;
import java.util.Scanner;


public class DFSAdjacencyMatrix 
{
	boolean flag[]=null;
	boolean adjacencyMatrix[][]=null;
	int numOfRows=0, numOfColumns=0;

	
	public void DFS(int node)
	{
		if(flag[node]==true)
			return; // already visited. so return
		
		int col=0;
	
		flag[node]=true;  // visited
		System.out.println("node:"+ node);
		
		for(col=0; col<numOfColumns; col++)
		{
			if(adjacencyMatrix[node][col]==true && flag[col]==false && col!=node)
			{
				DFS(col);
			}
		}

	}
	
	public void DFSSearch()
	{
		
		for(int l=0;l<numOfRows;l++)
		{
			flag[l]=false; // set not visited
			
		}
		
		for(int l=0;l<numOfRows;l++)  
			// for loop is required as for directed graphs some node
			// might not be accessible 
			DFS(l);
		
	}
	
	public void getInput()
	{
			Scanner sc=null;
			try 
			{
		
				sc=new Scanner(System.in);
				
				System.out.println("Enter number of rows and columns(e.g. 5 5)");
				System.out.println("Then enter adjaceny matrix entries, one line for each node (e.g. 0 1 0 0)");
				
				numOfRows=sc.nextInt();
				numOfColumns=sc.nextInt();
				sc.nextLine();
				
				adjacencyMatrix =new boolean[numOfRows][numOfColumns];
				flag=new boolean[numOfRows];
				
				for(int l=0;l<numOfRows;l++)
				{
					String line=sc.nextLine();
					//System.out.println(line);
					String [] entry=line.split(" ");
					
					//System.out.println(entry[0]);
								
					for(int k=0;k<numOfColumns;k++)
					{
						if(entry[k].equals("1"))
							adjacencyMatrix[l][k]=true; // set not visited
						else
							adjacencyMatrix[l][k]=false;
					}
				}
		
			} 
			catch (Exception e)
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
	}
	
	public static void main(String args[])
	{
		DFSAdjacencyMatrix ob=new DFSAdjacencyMatrix();
		ob.getInput();
		ob.DFSSearch();
	}
	
	

}
