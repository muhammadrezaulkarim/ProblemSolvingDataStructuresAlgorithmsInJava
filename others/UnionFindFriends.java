import java.util.*;

public class UnionFindFriends
{
    public int [] set;
    
    public void input()
    {
        int noOfPeople = 10;
        
        set = new int[noOfPeople+1];
        
        // Initially each people will be in a disjoint set
        for(int i=1; i<set.length; i++)
           set[i] = i; 
        
        // process each friend pair
        /* ############ In the processPair(i,j) i must be less than j
        otherwise the union-find algorithm will not work  ########### */
        // duplicate pair is okay
        
        processPair(1, 2);
        processPair(1, 3);
        processPair(3, 4);
        
        processPair(4, 5);
        processPair(3, 5);
        processPair(4, 6);
        
        processPair(2, 5);
        processPair(1, 2);
        processPair(1, 7);
        
        processPair(1, 2);
        processPair(9, 10);
        processPair(8, 9); 

    }
    
    public void displaySetMemberCount()
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        
        for(int i=1;i<set.length;i++)
        {
            System.out.println("i:" + i + " set: " + set[i]);
            
            Integer val = map.get(set[i]);
            
            if (val == null)
                map.put(set[i], 1);
            else
                map.put(set[i], val + 1);
        }
        
        int maxGroupMembers = Integer.MIN_VALUE;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > maxGroupMembers)
                maxGroupMembers = entry.getValue();
        }
        
        System.out.println("Max group1 member size: " + maxGroupMembers);
    }
    
    public void processPair(int x, int y)
    {
            
        union(x, y);
    }
    
   /* The above union() and findSet() are naive and the worst case time complexity is linear O(n).
      The trees created to represent subsets can be skewed and can become like a linked list 
      The above operations can be optimized to O(Log n) in worst case. 
      The idea is to always attach smaller depth tree under the root of the deeper tree. This technique is called union by rank.
   */
    
    public void union(int x, int y)
    {
        int setX = findSet(x);
        int setY = findSet(y);
        
        // merge into the same set
        if(setX != setY)
            set[setY] =  setX;
    }
    
    public int findSet(int x)
    {
        // find the root of the equivalent set containing x
        
        if(set[x] == x)
            return x;
        
        while(set[x] != x)
        {
         x = set[x];
        }
        
        return x;
    }
    
    public static void main(String [] args)
    {
        UnionFindFriends ob = new UnionFindFriends();
        ob.input();
        ob.displaySetMemberCount();
    }
}

/*

There is a town with N citizens. It is known that some pairs of people are friends. According to the famous saying that “The friends of my friends are my friends, too” it follows that if A and B are friends and B and C are friends then A and C are friends, too.

Your task is to count how many people there are in the largest group of friends

Input:

Input consists of several datasets. The first line of the input consists of a line with the number of test
cases to follow.
The first line of each dataset contains tho numbers N and M, where N is the number of town’s
citizens (1 ≤ N ≤ 30000) and M is the number of pairs of people (0 ≤ M ≤ 500000), which are known
to be friends. Each of the following M lines consists of two integers A and B (1 ≤ A ≤ N, 1 ≤ B ≤ N,
A ̸= B) which describe that A and B are friends. There could be repetitions among the given pairs.

Output:

The output for each test case should contain (on a line by itself) one number
denoting how many people
there are in the largest group of friends on a line by itself.

Sample Input:

2
3 2
1 2
2 3
10 12
1 2
3 1
3 4
5 4
3 5
4 6
5 2
2 1
7 1
1 2
9 10
8 9

Sample Output:
3
7

*/
