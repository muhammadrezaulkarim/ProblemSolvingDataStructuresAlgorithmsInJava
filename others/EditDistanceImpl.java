/*
The Levenshtein (Edit) distance is a measure of dissimilarity between two Strings.
Mathematically, given two Strings x and y, the distance measures the minimum number of character edits required to transform x into y.

Typically three type of edits are allowed:

Insertion of a character c
Deletion of a character c
Substitution of a character c with c‘

Example: If x = ‘shot' and y = ‘spot', the edit distance between the two is 1 because ‘shot' can be converted to ‘spot' by substituting ‘h‘ to ‘p‘.

Let's take two Strings x and y of lengths m and n respectively. We can denote each String as x[1:m] and y[1:n].

We know that at the end of the transformation, both Strings will be of equal length and have matching characters at each position. So, if we consider the first character of each String, we've got three options:

Substitution:
Determine the cost (D1) of substituting x[1] with y[1]. The cost of this step would be zero if both characters are same. If not, then the cost would be one
After the above step, we know that both Strings start with the same character. Hence the total cost would now be the sum of the cost of step 1.1 and the cost of transforming the rest of the String x[2:m] into y[2:n]

Insertion:
Insert a character in x to match the first character in y, the cost of this step would be one
After the above step, we have processed one character from y. Hence the total cost would now be the sum of the cost of step 2.1 (i.e., 1) and the cost of transforming the full x[1:m] to remaining y (y[2:n])

Deletion:
Delete the first character from x, the cost of this step would be one
After the above step, we have processed one character from x, but the full y remains to be processed. The total cost would be the sum of the cost of 3.1 (i.e., 1) and the cost of transforming remaining x to the full y

The next part of the solution is to figure out which option to choose out of these three. Since we do not know which option would lead to minimum cost at the end, we must try all options and choose the best one.

*/

public class EditDistanceImpl {

   public static int editDist(String x, String y) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (x.isEmpty()) {
            return y.length();
        }

           // If second string is empty, the only option is to
        // remove all characters of first string
        if (y.isEmpty()) {
            return x.length();
        } 

        int substitution = editDist(x.substring(1), y.substring(1)) 
         + costOfSubstitution(x.charAt(0), y.charAt(0));
         
        int insertion = editDist(x, y.substring(1)) + 1;
        
        int deletion = editDist(x.substring(1), y) + 1;

        return min(substitution, insertion, deletion);
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
    
    // Driver Code
    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";
 
        System.out.println(editDistDynamic(
            str1, str2));
    }

    public static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }
   
   /* On analyzing the recursive calls, we observe that the arguments for sub-problems are suffixes of the original Strings. 
      This means there can only be m*n unique recursive calls (where m and n are a number of suffixes of x and y). Hence the 
      complexity of the optimal solution should be quadratic, O(m*n).

Lets look at some of the sub-problems (according to recurrence relation defined in section #4):

Sub-problems of D(x[1:m], y[1:n]) are D(x[2:m], y[2:n]), D(x[1:m], y[2:n]) and D(x[2:m], y[1:n])
Sub-problems of D(x[1:m], y[2:n]) are D(x[2:m], y[3:n]), D(x[1:m], y[3:n]) and D(x[2:m], y[2:n])
Sub-problems of D(x[2:m], y[1:n]) are D(x[3:m], y[2:n]), D(x[2:m], y[2:n]) and D(x[3:m], y[1:n])
   */
   
   public static int editDistDynamic(String x, String y) {
    int[][] dp = new int[x.length() + 1][y.length() + 1];

    for (int i = 0; i <= x.length(); i++) {
        for (int j = 0; j <= y.length(); j++) {
            if (i == 0) {
                dp[i][j] = j;
            }
            else if (j == 0) {
                dp[i][j] = i;
            }
            else {
                dp[i][j] = min(dp[i - 1][j - 1] 
                 + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
                  dp[i - 1][j] + 1, 
                  dp[i][j - 1] + 1);
            }
        }
    }

    return dp[x.length()][y.length()];
}


}
