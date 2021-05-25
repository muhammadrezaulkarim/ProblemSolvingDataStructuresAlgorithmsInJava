import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BFSAdjacencyMatrix
{
	boolean flag[]=null;
	boolean adjacencyMatrix[][]=null;
	int numOfRows=0, numOfColumns=0;
	Queue<Integer> queue=new LinkedList<Integer>();
	
	public void BFS(int root)
	{
		if(flag[root]==true)
			return; // already visited. so return
		
		queue.add(root); //add the root node
		flag[root]=true; // visited
		
		while(!queue.isEmpty())
		{		
			int col=0;
		
			int node=queue.remove();
			System.out.println("node:"+ node);
			//flag[node]=true;  // visited
			
			for(col=0; col<numOfColumns; col++)
			{
				//if(nextCol>=0 && nextCol<numOfColumns && nextRow>=0 && nextRow<numOfRows)
				if(adjacencyMatrix[node][col]==true && flag[col]==false && col!=node)
				{
					flag[col]=true;  // visited
					queue.add(col);
				}
			}
		}

	}
	
	public void BFSSearch()
	{
		
		for(int l=0;l<numOfRows;l++)
		{
			flag[l]=false; // set not visited
			
		}
		
		for(int l=0;l<numOfRows;l++) 
		{
			// for loop is required as for directed graphs some node
			// might not be accessible from others
			BFS(l);
		}
		
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
		BFSAdjacencyMatrix ob=new BFSAdjacencyMatrix();
		ob.getInput();
		ob.BFSSearch();
	}
	
	

}

