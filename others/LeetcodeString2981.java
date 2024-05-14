import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetcodeString2981 {
    Map<String, Integer> map = new HashMap<String, Integer>();

    public boolean isSpecial(String s) {
        Set<Character> uniqueCharacters = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++)
            uniqueCharacters.add(s.charAt(i));

        if (uniqueCharacters.size() == 1)
            return true;
        else
            return false;

    }

    public int maximumLength(String s) {

        if (s == null || s.isEmpty())
            return -1;

        if (s.length() <= 2)
            return -1;

        int lengthUpperBound =  s.length();
        int maxLength = -1;

        for (int len = 1; len <= lengthUpperBound; len++) {
            for (int j = 0; j <= (s.length() - len); j++) {
                String substr = s.substring(j, j + len);

                if (isSpecial(substr)) {
                    int substrCount = map.getOrDefault(substr, 0) + 1;
                    map.put(substr, substrCount);

                    if (substrCount >= 3) {
                        if (substr.length() > maxLength) {
                            maxLength = len;
                        }
                    }
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LeetcodeString2981 ob = new LeetcodeString2981();
        String s = "abcccccdddd"; //3
        // String s = "abcdef"; // -1
        //String s = "abcaba";  // Expected result = 1
        //String s = "aaaa";  // Expected result = 2
        //String s = "ttttt";  // Expected result = 3
        System.out.println(ob.maximumLength(s));
    }
}

/*
 * You are given a string s that consists of lowercase English letters.

A string is called special if it is made up of only a single character. For example, the string "abc" is not special, whereas the strings "ddd", "zz", and "f" are special.

Return the length of the longest special substring of s which occurs at least thrice, or -1 if no special substring occurs at least thrice.

A substring is a contiguous non-empty sequence of characters within a string.

 

Example 1:

Input: s = "aaaa"
Output: 2
Explanation: The longest special substring which occurs thrice is "aa": substrings "aaaa", "aaaa", and "aaaa".
It can be shown that the maximum length achievable is 2.
Example 2:

Input: s = "abcdef"
Output: -1
Explanation: There exists no special substring which occurs at least thrice. Hence return -1.
Example 3:

Input: s = "abcaba"
Output: 1
Explanation: The longest special substring which occurs thrice is "a": substrings "abcaba", "abcaba", and "abcaba".
It can be shown that the maximum length achievable is 1.
 
Input: s = "ttttt"
Output: 3

Input: s = "aaaa"
Output: 2

Constraints:

3 <= s.length <= 50
s consists of only lowercase English letters.
 */
