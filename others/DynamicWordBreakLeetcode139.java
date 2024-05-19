import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DynamicWordBreakLeetcode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        // Initialize a boolean array to keep track of possible word breaks
        // solutionExists[i] is true if first i characters of the string can be
        // segmented into dictionary words
        boolean[] solutionExists = new boolean[s.length() + 1];

        // Empty string (string with first 0 charcter) is a valid segementation
        solutionExists[0] = true;

        // please note i and j representing first i and j characters in the string
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If the first j characters of the string can be broken into valid words, and
                // the substring from j to i is in the dictionary
                // Then, mark the solution for i as true
                if (solutionExists[j] && set.contains(s.substring(j, i))) {
                    solutionExists[i] = true;
                    break;
                }
            }
        }

        // The last entry tells if the entire string can be segmented or not
        return solutionExists[s.length()];
    }

    public static void main(String[] args) {
        DynamicWordBreakLeetcode139 ob = new DynamicWordBreakLeetcode139();
        String s = "leetcode";

        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(ob.wordBreak(s, wordDict)); // return True
    }
}

/*
 Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */
