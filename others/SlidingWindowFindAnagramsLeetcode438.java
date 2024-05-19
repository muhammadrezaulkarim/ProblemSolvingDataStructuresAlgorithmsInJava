import java.util.ArrayList;
import java.util.List;

public class SlidingWindowFindAnagramsLeetcode438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null)
            return result; // return empty list

        if (s.isEmpty() || p.isEmpty())
            return result; // return empty list

        int i = 0;
        int[] frequencyP = frequencyCount(p);
        while (i < s.length() - p.length() + 1) {
            int[] frequencySubstr = frequencyCount(s.substring(i, i+p.length()));

            if (isAnagram(frequencyP, frequencySubstr))
                result.add(i);

            i++;
        }

        return result;
    }

    private boolean isAnagram(int[] frequency1, int[] frequency2) {

        for (int i = 0; i < frequency1.length; i++) {
            if (frequency1[i] != frequency2[i])
                return false;
        }

        return true;
    }

    private int[] frequencyCount(String str) {
        int[] frequency = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            frequency[ch - 'a'] += 1;
        }

        return frequency;
    }

    public static void main(String[] args) {
        SlidingWindowFindAnagramsLeetcode438 ob = new SlidingWindowFindAnagramsLeetcode438();
        
        //String s = "cbaebabacd";
        //String p = "abc";

        String s = "abab";
        String p = "ab";

        System.out.println(ob.findAnagrams(s, p));
    }

}

/*
 
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 
Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 10^4
s and p consist of lowercase English letters.
 */
