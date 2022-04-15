import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreeKruskal 
{
	
    public static void main(String[] args) 
    {
      
        MinimumSpanningTreeKruskal ob = new MinimumSpanningTreeKruskal();
		ob.computeSpanningTree();
    }
    
    public void computeSpanningTree()
    {
    	int vertices = 5;
        Graph graph = new Graph(vertices);
         
        graph.insertEdge(0, 1, 4);
        graph.insertEdge(0, 2, 4);
        graph.insertEdge(0, 3, 6);
        graph.insertEdge(0, 4, 6);
        graph.insertEdge(1, 2, 2);
        graph.insertEdge(2, 3, 8);
        graph.insertEdge(3, 4, 9);
        
        
        graph.minSpanningTreeKruskal();
    }
    
    
	
    class Edge
    {
        int src;
        int dest;
        Double weight;

        public Edge(int src, int dest, double weight) 
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }   
    }

    class Graph 
    {
        int noOfVertices;
        List<Edge> edgeList = new ArrayList<>();

        Graph(int noOfVertices) 
        {
            this.noOfVertices = noOfVertices;
        }

        public void insertEdge(int source, int destination, int weight) 
        {
            Edge edge = new Edge(source, destination, weight);
            edgeList.add(edge); //add to total edges
        }
        
        public void minSpanningTreeKruskal()
        {

            //create a parent []
            int [] parents = new int[noOfVertices];

            // Set parents of each node to itself.
            for (int i = 0; i <noOfVertices ; i++) 
            {
                parents[i] = i;
            }

        	
	        //create a min priority queue
        	PriorityQueue<Edge> minPrioQueue = new PriorityQueue<>(edgeList.size(),new Comparator<Edge>(){
		            @Override
	            public int compare(Edge o1, Edge o2) {
	                return o1.weight.compareTo(o2.weight);
	            }
	        });
	        

            //add all the edges to priority queue, //sort the edges on weights
            for (int i = 0; i <edgeList.size() ; i++) {
            	minPrioQueue.add(edgeList.get(i));
            }     
            
            ArrayList<Edge> resultEdgeList = new ArrayList<>();

            double cost = 0;
            
            while(minPrioQueue.size()>0 )
            {
                Edge edge = minPrioQueue.poll();
                
		//union part of the union find algorithm
                //check if adding this edge creates a cycle, if x==y, cycle created
		    
                int x = findRoot(parents, edge.src);
                int y = findRoot(parents, edge.dest);

                if(x!=y)
                {
			
                    //add it to our final result
                	resultEdgeList.add(edge);
                	
                    parents[y] = x;  // update parent as part of union operation
                	
                    cost += edge.weight;
                }
            }
            
            //print MST
            System.out.println("Minimum Spanning Tree using Kruskal' algorithm: ");
            displayGraph(resultEdgeList);
            
            System.out.println(cost);
        }
	    
   /* The above union() and findSet() are naive and the worst case time complexity is linear O(n).
      The trees created to represent subsets can be skewed and can become like a linked list 
      The above operations can be optimized to O(Log n) in worst case. 
      The idea is to always attach smaller depth tree under the root of the deeper tree. This technique is called union by rank.
   */
    // Gets parent of node x.
    public int findRoot(int parents[], int x)
    {     
        while(parents[x] != x)
        {
           x =  parents[x];
        }
        
        return x;
    }

        public void displayGraph(ArrayList<Edge> edgeList)
        {
            for (int i = 0; i <edgeList.size() ; i++) 
            {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.src +
                        " destination: " + edge.dest +
                        " weight: " + edge.weight);
            }
        }
          
    }
    

}

/* For a graph with E edges and V vertices, 

the above algorithm will take O(EV) time as  findRoot takes O(V) time in case the graph is skewed.

1. Sort the edges by weight using a priority queue in O(E log V) time
2. Union-findRoot takes O(EV) time in case the graph is skewed. For each edge we need to do two 'find' operations and  one union (if cycle not created)
O(EV) is dominant term here

we can run Kruskal's algorithm in O(E log V) time if we improve findRoot to take O(logV) time using union by rank 

*/
