import java.io.*;
import java.util.*;

class TopKMostFrequenciesStream {

  HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

  public void topKMostFrequenciesStream(int [] array, int k) {
    // One additional sloat added to store each incoming number in the stream
    int [] temp = new int[k+1];

    for(int i=0; i<temp.length; i++)
      temp[i] = Integer.MIN_VALUE;  // using MIN_VALUE will help us to use negative numbers as well

    for(int i=0; i<array.length; i++)
    {
      frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);

      // copy the new number at kth position
      temp[k] = array[i];

      // search whether same number already exists in the top k
      // if exists, starts from that index
      // if does not exist, start from last index where the number was copied
      int startIndex = findNumber(temp, array[i]);

      for(int j=startIndex; j>0; j--) {
        if (frequencyMap.getOrDefault(temp[j], 0) > frequencyMap.getOrDefault(temp[j-1], 0)) {
            swap(temp, j, j -1);
        }
        // If of equal frequency, sort the two numbers in ascending order
        else if (frequencyMap.getOrDefault(temp[j], 0) == frequencyMap.getOrDefault(temp[j-1], 0))
        {
          if(temp[j] < temp[j-1])
            swap(temp, j, j-1);
        }
      }

      // display top k numbers
      // we might not have K numbers at the beginning
      for(int j=0; j<k; j++)
      {
        if(temp[j] != Integer.MIN_VALUE)
          System.out.print(temp[j] + " ");
      }

      System.out.println();
    }
    
  }

   // function to search in top vector for element
  public int findNumber(int[] temp, int num) {
      for (int i = 0; i < temp.length; i++)
          if (temp[i] == num)
              return i;

      return temp.length;
  }

  public void swap(int [] temp, int i, int j)
  {
    int val = temp[i];
    temp[i] = temp[j];
    temp[j] = val;
  }


  public static void main(String[] args) {
    int [] input = {5, 2, 1, 3, 2} ;
    int k = 4;

    TopKMostFrequenciesStream ob = new TopKMostFrequenciesStream();
    ob.topKMostFrequenciesStream(input, k);
  }
}
/*
Given an array of n numbers. Your task is to read numbers from the array and keep at-most K numbers at the top (According to their decreasing frequency) every time a new number is read. We basically need to print top k numbers sorted by frequency when input stream has included k distinct elements, else need to print all distinct elements sorted by frequency.

Input 1: arr[] = {5, 2, 1, 3, 2} 
k = 4 

Output:

5
2 5
1 2 5
1 2 3 5
2 1 3 5

Input 2: arr[] = {5, 2, 1, 3, 4} 
k = 4 

Output:
5
2 5
1 2 5
1 2 3 5
1 2 3 4 

*/
