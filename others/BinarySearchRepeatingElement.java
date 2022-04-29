import java.io.*;
import java.util.*;


class BinarySearchRepeatingElement {

  public int repeatingElementSearch(int [] array, int low, int high) {

      if (low > high)
          return -1;

      int mid = (low + high)/2;

      if (array[mid-1] == array[mid])
        return mid;

      
      // If mid is at proper position, repeating element is on the right side of the mid
      if (array[mid] == mid + 1)
        return repeatingElementSearch(array, mid+1, high);
      // If mid is not at proper position, repeating element is on the left side of the mid
      else
        return repeatingElementSearch(array, low, mid -1);

  }

  public static void main(String[] args) {
    int array [] = { 1, 2 , 3 , 4 , 4};

    BinarySearchRepeatingElement ob = new BinarySearchRepeatingElement();
    int index = ob.repeatingElementSearch(array, 0, array.length -1);
    System.out.println(array[index]);
  }
}

/* 
Given a sorted array of n elements containing elements in range from 1 to n-1 i.e. one element occurs twice, the task is to find the repeating element in an array.

Observation: If an element ‘X’ is repeating, then it must be at index ‘X-1’ and ‘X’ in the array. 

Examples : 

input : arr[] = {1, 2, 3, 3, 4, 5};
Output :  3

Input :  arr[] = { 1, 2 , 3 , 4 , 4}
Output :  4

Input :  arr[] = { 1 , 1 , 2 , 3 , 4}
Output :  1


Time Complexity : O(log n)
*/
