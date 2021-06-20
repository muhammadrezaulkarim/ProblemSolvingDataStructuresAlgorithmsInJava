/*
Longest Common Subsequence (LCS) problem:

LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

*/

public class DynamicLongestCommonSubsequence {
   
   public static int LCSDynamic(String x, String y) 
   {
    
    int[][] dp = new int[x.length() + 1][y.length() + 1];

    for (int i = 0; i <= x.length(); i++) 
    {
        for (int j = 0; j <= y.length(); j++) 
        {
            
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            
            else if (x.charAt(i-1) == y.charAt(j-1))
                dp[i][j] = dp[i-1][j-1] + 1;
            
            else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }

    return dp[x.length()][y.length()];
}

    // Driver Code
    public static void main(String args[])
    {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
 
        System.out.println(LCSDynamic(str1, str2));
    }

}
