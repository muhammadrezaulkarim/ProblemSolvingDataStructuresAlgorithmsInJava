// Bellman-Ford's single source shortest path implementation

import java.util.*;
import java.lang.*;
import java.io.*;
 
public class ShortestPathBellmanFord {
   
    // represent a weighted edge
    class Edge {
        
        int src;
        int dest;
        int weight;
        
        Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    };
    
     
    // Creates a connected, directed and weighted graph 
    // with V vertices and E edges
    class Graph
    {
         
        int V = 0;
        int E = 0;
        Edge edge[];

        Graph(int v, int e)
        {
            this.V = v;
            this.E = e;
            
            edge = new Edge[e];
        }
    }

 
    // The main function that finds shortest distances from src
    // to all other vertices
    void ShortestPathBellmanFord( Graph graph, int src)
    {
        int V = graph.V;
        int E = graph.E;
        int dist[] = new int[V];
 
        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        
        //set the distance to source to itself to 0
        dist[src] = 0;
 
        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                
                    dist[v] = dist[u] + weight;
            }
        }
 
        // Step 3: check for negative-weight cycles. The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        // path, then there is a cycle.
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            
            
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
            {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        
        
        printDistance(dist, V);
    }
 
    // A utility function used to print the solution
    void printDistance(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
    
    public Graph createGraph()
    {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph
 
        Graph graph = new Graph(V, E);
 
        // add edges
        graph.edge[0] = new Edge(0,1,-1);
        graph.edge[1] = new Edge(0,2,4);
        graph.edge[2] = new Edge(1,2,3);
        graph.edge[3] = new Edge(1,3,2);
        graph.edge[4] = new Edge(1,4,2);
        graph.edge[5] = new Edge(3,2,5);
        graph.edge[6] = new Edge(3,1,1);
        graph.edge[7] = new Edge(4,3,-3);
        
        return graph;
        
    }
 
    // Driver method to test above function
    public static void main(String[] args)
    {
        
        ShortestPathBellmanFord sol = new ShortestPathBellmanFord();
        sol.ShortestPathBellmanFord(sol.createGraph(), 0);
    }
}
