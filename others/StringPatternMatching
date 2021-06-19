/*
String Pattern Matching

Prefix: A prefix of a string S is any substring that starts from the beginning of S and ends at any position of S. 

Suffix: A suffix of a string S is any substring that starts from any position of S and ends at the end of S. 

Proper Prefix: A proper prefix is any prefix that is not equal to the full string S.

Proper Suffix: A proper suffix is any suffix that is not equal to the full string S.

Example:

For the word ACA we have the following proper prefixes: A, AC, ACA and the suffixes: A, CA, ACA. Thus, the longest proper prefix that is equal to the suffix is ACA. 

*/
 
public class StringPatternMatching
{
    
    public int longestProperPrefix(String targetStr) 
    {
          int length=targetStr.length();
          int mid=targetStr.length()/2;
          
          // edge cases
          if(length < 2){
               return 0;
          }
          
          // edge cases 
          if(length == 2)
          {
            if(targetStr.charAt(0) == targetStr.charAt(1))
              return 1;
            else
              return 0;
          }
          
          //start from the mid point of the string
          for(int i=mid;i>=0;i--)
          {
              
              String prefix=targetStr.substring(0,i+1); // we need to consider characters upto i
              
              // make sure the suffix is of same length as the current prefix
              String suffix=targetStr.substring(length-prefix.length());
              
              if(suffix.isEmpty() || prefix.isEmpty())
                    return 0;
            
              
              if(suffix.equals(prefix))
                  return suffix.length();
              
          }
          
        return 0;
    }
    
   // LSP array contains the information about the “Longest Proper Prefix which is also Suffix"
   
   //we will consider the pattern W to be zero-based indexed, and store the LPS values inside the array starting 
   // from index 0. In other words, for each index i in [0, length(W)-1],  we’ll store the LPS of the range [0, i]
   
    // for pattern "aabaaba", the lps array output is:  0 1 0 1 2 3 4
   
    public int [] longestProperPrefixArray(String targetStr) 
    {
        int [] lpsArray = new int[targetStr.length()];
        
        
        for(int i=0; i<targetStr.length();i++)
            lpsArray[i] = longestProperPrefix(targetStr.substring(0,i+1)); // the last index is exclusive
            
        return lpsArray;
        
    }
    
    /*
    The problem with the naive pattern matching approach is that when it discovers a mismatch, it moves to the next position in the target text T, and starts comparing the pattern W from the beginning. The KMP algorithm performs some analysis on the pattern W before trying to find its occurrences in the text T.
    
    Instead of moving one symbol forward in a target text (T)
    and starting from the very beginning of a pattern string, Knuth Morris Pratt algorithm uses 
    LPS to continue from exactly the same place where the mismatch occurred 
    
    If we find a mismatch at index j, we need to find the second-longest matching prefix of the word W
    
    */
    
    public boolean Knuth_Morris_Pratt(String str, String pattern, int [] lpsArray)
    {
        int i=0, j=0;
        
        while(i < str.length())
        {
           // Suppose at some step we were on the ith index inside the text T and the jth index inside the pattern W. This means that currently, we were able to match the prefix of length j from the word W
            
            //If we find a mismatch at index j, we need to find the second-longest matching prefix of the word W,
            // which is LPS[j-1].
            
            while(j >=0 && str.charAt(i) != pattern.charAt(j))
            {
                if(j == 0)  // for edge case 0, there is no second best. so we reset the index to -1 (previous index)
                    j = -1;
                else
                    j = lpsArray[j-1];
            }
                
            i++;
            j++;
            
            
            if (j == pattern.length())
                return true;
        }
        
        return false;
    }

    public static void main(String []args)
    {
        StringPatternMatching sol = new StringPatternMatching();
        
        String targetString = "xxaabaaba";
        String pattern = "aabaaba";
        //String pattern = "tabaaba";
        
        int [] lpsArray = sol.longestProperPrefixArray(pattern);
        
        System.out.print("LPS Array: ");
        for(int i=0; i<lpsArray.length; i++)
            System.out.print(" " + lpsArray[i]);
            
        System.out.println();
        
        System.out.println(sol.Knuth_Morris_Pratt(targetString, pattern, lpsArray));
    }
}
