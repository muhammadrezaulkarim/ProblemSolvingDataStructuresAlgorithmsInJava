
import java.util.*;

class MissingInteger {
    public int findMissingInteger(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
       
        for(int i=0; i<A.length; i++)
        {
            if(A[i] >=0)
                set.add(A[i]);
        }

        int smallestPositiveMissingInteger = 1;
        
        while(set.contains(smallestPositiveMissingInteger))
         smallestPositiveMissingInteger++;

         return smallestPositiveMissingInteger;
       
    }

    public static void main(String[] args) {
        MissingInteger ob = new MissingInteger();
        int nums[] = { 1, 3, 6, 4, 1, 2}; // expects 5
        //int nums[] = { 1, 2, 3}; // expects 4
       // int nums[] = {-1, -3}; // expects 1
        //int nums[] = {-1, -3, 0,1,5,5,11,11,13}; // expects 2

        System.out.println(ob.findMissingInteger(nums));
    }

    int nums[] = { 1, 4, 45, 6, 10, 8 };
}
/*For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1. */
