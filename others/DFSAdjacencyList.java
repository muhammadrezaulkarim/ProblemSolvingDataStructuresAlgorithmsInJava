import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DFSAdjacencyList 
{
	GraphOrTree gTree=null;
	
	
	public void DFS(Node node)
	{
		if(node.visited==true)
			return; // already visited. so return
		
		int col=0;
	
		node.visited=true;  // visited
		System.out.println("node:"+ node.id);
		
		for(col=0; col<node.childrenId.length; col++)
		{
			Node childNode=gTree.nodes[node.childrenId[col]];
			
			if( childNode.visited==false)
			{
				DFS(childNode);
			}
		}

	}
	
	public void DFSSearch()
	{
		
		for(int l=0;l<gTree.nodes.length;l++)  
			DFS(gTree.nodes[l]);
		
	}
		
	public void getInput()
	{
			Scanner sc=null;
			
			try 
			{
				sc=new Scanner(System.in);
				
				System.out.println("Enter number of nodes for the graph. Number id starts from 0)");
				System.out.println("Then enter adjaceny list entries, one line for each node.");
				System.out.println("Enter -1 for a node if no adacent node exists");
				int numOfNodes=sc.nextInt();
				sc.nextLine();
				
				
				gTree=new GraphOrTree();
				gTree.nodes =new Node[numOfNodes];
				
				//flag=new boolean[numOfNodes];
				
				for(int l=0;l<numOfNodes;l++)
				{
					String line=sc.nextLine();
					String [] entry=line.split(" ");
					
					Node node=new Node();
					node.id=l;
					node.visited=false;
					
					if(entry.length==1 && entry[0].equals("-1"))
						node.childrenId=new int[0];
					else
						node.childrenId=new int[entry.length];		
					
					for(int k=0;k<node.childrenId.length;k++)
					{
						node.childrenId[k]=Integer.parseInt(entry[k]);
					}
					
					gTree.nodes[l]=node;
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
		DFSAdjacencyList ob=new DFSAdjacencyList();
		ob.getInput();
		ob.DFSSearch();
	}
	
	
	
	class GraphOrTree
	{
		public Node[] nodes;
		
	}
	
	class Node
	{
		public int id;
		public boolean visited=false;
		public int [] childrenId;
	}

}
