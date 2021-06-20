import java.io.*;
import java.util.*;


public class DynamicLargestSubMatrixWithOne {
    
public static final int nRow=6;
public static final int nCol=5;
  
int [] [] matrix =  {
   {0, 1, 1, 0, 1},
   {1, 1, 0, 1, 0},
   {0, 1, 1, 1, 0},
   {1, 1, 1, 1, 0},
   {1, 1, 1, 1, 1},
   {0, 0, 0, 0, 0}
};

    public int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

public void largestSubMatrixWithOne() 
{
   int [][] subMatrix = new int[nRow][nCol];
  
   int maxSize, iMax, jMax;

   for(int i = 0; i < nRow; i++)    //copy first row of matrix to sub matrix
      subMatrix[i][0] = matrix[i][0];

   for(int j = 0; j < nCol; j++)    //copy first column of matrix to sub matrix
      subMatrix[0][j] = matrix[0][j];

   for(int i = 1; i < nRow; i++) {
      for(int j = 1; j < nCol; j++) {
         if(matrix[i][j] == 1)    //find minimum of left, top and diagonal element + 1
            subMatrix[i][j] = min(subMatrix[i][j-1], subMatrix[i-1][j], subMatrix[i-1][j-1]) + 1;
         else
            subMatrix[i][j] = 0;    //if item is 0, put only 0
      }  
   }

   maxSize = subMatrix[0][0]; iMax = 0; jMax = 0;
   for(int i = 0; i < nRow; i++) {    //find the order of sub square matrix

      for(int j = 0; j < nCol; j++) {
         if(maxSize < subMatrix[i][j]) {

            maxSize = subMatrix[i][j];
            iMax = i;
            jMax = j;
         }      
      }                
   }  
 
   System.out.println("Largest Subsquare matrix with one: ");
   for(int i = iMax; i > iMax - maxSize; i--) {    //print the submatrix using max size
      for(int j = jMax; j > jMax - maxSize; j--) {
         System.out.print(matrix[i][j] + " ");
      }
     
      System.out.println();
   }
}  
 
  public static void main(String[] args) {
    DynamicLargestSubMatrixWithOne ob = new DynamicLargestSubMatrixWithOne();
    ob.largestSubMatrixWithOne();
  }
  
  /*
  Let the given binary matrix be Matrix[nRow][nCol]. 
  
  The idea of the algorithm is to construct an auxiliary size matrix subMatrix[][] in which each entry subMatrix[i][j] represents size of the square sub-matrix with all 1s 
  
  Find the maximum entry in subMatrix[nRow][nCol]

 Using the value and coordinates of maximum entry in subMatrix[][], print 
   sub-matrix of Matrix[][]
  
  */
}
