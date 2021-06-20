import java.io.*;
import java.util.*;

public class MathUglyNumber {
  
    ArrayList<Integer> uglyList = new  ArrayList<Integer>();
    int MAX_UGLY_NUMBER = 100000;
  
    public void generateUglyNumbers()
    {
      
      uglyList.add(1); // by definition 1 is an ugly number
      
      for(int i=2; i <=29; i++)
      {
        // if divisible by other prime numbers, they are not ugly number
        if(i%7==0 || i%11==0 || i%13==0 || i%17 ==0 || i% 19 == 0 || i%23 ==0 || i%29==0)
          continue;
        
        if(i%2 ==0 || i%3==0 || i%5==0)
        {
          uglyList.add(i);
        }
      }
      
      // this loop covers from 30 and above
      for(int i=1; i<=MAX_UGLY_NUMBER; i=i*2)
      {
        
        for(int j=1; i*j<=MAX_UGLY_NUMBER; j=j*3)
        {
            for(int k=1; i*j*k<=MAX_UGLY_NUMBER; k=k*5)
            {
              if(!uglyList.contains(i*j*k)) // avoid duplicate entries
              {
                uglyList.add(i*j*k);
              }
            }
        }
        
      } 
      
     Collections.sort(uglyList);
      
    }
  
    public int nthUglyNumber(int n) {
        
      return uglyList.get(n-1);
    }
  
  public static void main(String[] args) {
    MathUglyNumber sb = new MathUglyNumber();
    sb.generateUglyNumbers();
    System.out.println(sb.nthUglyNumber(100));
    
  }
  
  /*
  
  Input  : n = 7
Output : 8

Input  : n = 10
Output : 12

Input  : n = 15
Output : 24

Input: n = 100
Output: 1536

Input  : n = 150
Output : 5832

*/
}
