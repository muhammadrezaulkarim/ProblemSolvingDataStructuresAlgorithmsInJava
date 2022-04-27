import java.io.*;
import java.util.*;


class GraphCelebrity {

  public boolean findCelebrity(int [][] array)
  {
    int n = array.length;

    int indegree [] = new int[n];
    int outdegree [] = new int[n];

    for(int i=0; i<array.length; i++) {
          for(int j=0; j<array.length; j++) {
              if(array[i][j] == 1)
              {
                indegree[j] = indegree[j] + 1;
                outdegree[i] = outdegree[i] + 1;
              }
          }
    }

    for(int i=0; i<array.length; i++)
      if(indegree[i] == n-1 && outdegree[i] == 0)
        return true;

    return false;
    
  }

  public static void main(String[] args) {  
    int acquintanceWithCelebrity [] [] = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0} };

    int acquintanceWithoutCelebrity [] [] =  { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 1, 0, 0},
           {0, 0, 1, 0} };

    GraphCelebrity ob = new GraphCelebrity();
    System.out.println(ob.findCelebrity(acquintanceWithCelebrity));
    System.out.println(ob.findCelebrity(acquintanceWithoutCelebrity));
  }
}

/*
In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party.
 Find the stranger (celebrity) in the minimum number of questions.
 
 We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise.
*/


