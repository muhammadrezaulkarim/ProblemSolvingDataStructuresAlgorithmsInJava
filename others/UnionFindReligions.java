import java.util.*;

public class UnionFindReligions
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
        
        processPair(2, 3);
        processPair(4, 5);
        processPair(4, 8);
        processPair(5, 8);

    }
    
    public void displayReligionCount()
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
        
        System.out.println("Different Religion Count: " + map.size());
    }
    
    public void processPair(int x, int y)
    {
            
        union(x, y);
    }
    
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
        UnionFindReligions ob = new UnionFindReligions();
        ob.input();
        ob.displayReligionCount();
    }
}

/*

There are so many different religions in the world today
that it is difficult to keep track of them all. You are
interested in finding out how many different religions
students in your university believe in.
You know that there are n students in your university (0 < n ≤ 50000). It is infeasible for you to
ask every student their religious beliefs. Furthermore,
many students are not comfortable expressing their beliefs. One way to avoid these problems is to ask m
(0 ≤ m ≤ n(n − 1)/2) pairs of students and ask them
whether they believe in the same religion (e.g. they
may know if they both attend the same church). From
this data, you may not know what each person believes
in, but you can get an idea of the upper bound of how
many different religions can be possibly represented on
campus. You may assume that each student subscribes
to at most one religion.


Input

The input consists of a number of cases. Each case
starts with a line specifying the integers n and m. The
next m lines each consists of two integers i and j, specifying that students i and j believe in the same religion. The students are numbered 1 to n. The end
of input is specified by a line in which n = m = 0.


Output

For each test case, print on a single line the case number (starting with 1) followed by the maximum
number of different religions that the students in the university believe in.


Sample Input:

10 9
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
10 4
2 3
4 5
4 8
5 8
0 0

Sample Output:

Case 1: 1
Case 2: 7


*/
