import java.util.*;

public class ShortestPathDijkstra
{
  public static int NO_OF_VERTICES = 4;
  double distance[][] = new double[NO_OF_VERTICES ][NO_OF_VERTICES];
  
  
  public static void main(String args[])
  {
    ShortestPathDijkstra ob = new ShortestPathDijkstra();
    ob.compute();
    }
  
  public void compute()
  {
    
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
    
    double[] dist = dijkstraShortestGreedy(2, distance);
    
    System.out.println(dist[1]);
      
  }
  
  public double[] dijkstraShortestGreedy(int source, double distance[][])
  {
      
      PriorityQueue<VertexInfo> pq = new PriorityQueue<VertexInfo>(new Comparator<VertexInfo>()
      {
          public int compare(VertexInfo ob1, VertexInfo ob2)
          {
              return ob1.dist.compareTo(ob2.dist);
          }
      }
      );
      
      // stores the distance from the source vertex
      double [] dist = new double[NO_OF_VERTICES];
     
      // flag to make sure no vertex considered more than once
      boolean [] flag = new boolean[NO_OF_VERTICES];
    
      for(int v=0; v<NO_OF_VERTICES; v++)
         flag[v] = false;
        
      for(int v=0; v<NO_OF_VERTICES; v++)
         dist[v] = Double.MAX_VALUE;
        
      // important to initialize to 0
      dist[source] = 0;
         
      VertexInfo src = new VertexInfo(source, 0); // distnce from source to itself is 0
      pq.add(src);
      flag[source] = true; // set to true
      
      
      while(!pq.isEmpty())
      {
          
          // find the vertex with minimum distance from the source vertex
          VertexInfo u = pq.remove();
          
          for(int v=0; v<NO_OF_VERTICES; v++)
          {
                  
              if(distance[u.label][v] != Double.MAX_VALUE) // only if adjacent
              {
                //unconditionally update the distance from source to v
                // if a shorter path found through u
                
                if(u.dist + distance[u.label][v] < dist[v])
                      dist[v] = u.dist + distance[u.label][v];
                      
                  if(!flag[v]) // only if not already been considered add the neighbouring vertex
                  {
                    flag[v] = true;
                    
                    VertexInfo neighbour = new VertexInfo(v, dist[v]);
                    pq.add(neighbour);
                  }
              } 
          } 
          
      }  
    
    return dist;
     
  }
  
  class VertexInfo
  {
      int label;
      Double dist; // distance from the source node
      
      public VertexInfo(int label, double dist)
      {
          this.label = label;
          this.dist = dist;
      }
  }
}
