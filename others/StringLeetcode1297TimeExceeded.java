import java.util.*;

public class StringLeetcode1297TimeExceeded {
    Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
    Map<String, Integer> subStringCountMap = new HashMap<String, Integer>();

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        for (int len = minSize; len <= maxSize; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                String subStr = s.substring(i, i + len);

                if (isValidSubstring(subStr, maxLetters)) {
                    subStringCountMap.put(subStr, subStringCountMap.getOrDefault(subStr, 0) + 1);
                }
            }
        }

        int maxVal = 0;

        for (Map.Entry<String, Integer> entry : subStringCountMap.entrySet()) {

            maxVal = Math.max(maxVal, entry.getValue());
        }

        return maxVal;
    }

    public boolean isValidSubstring(String s, int maxLetters) {
        charCountMap.clear();

        System.out.println(s);

        for (int i = 0; i < s.length(); i++)
            charCountMap.put(s.charAt(i), charCountMap.getOrDefault(s.charAt(i), 0) + 1);

        if (charCountMap.size() <= maxLetters)
            return true;

        return false;

    }

    public static void main(String[] args) {
        String s = "aababcaab";

        StringLeetcode1297TimeExceeded ob = new StringLeetcode1297TimeExceeded();
        System.out.println("Maximum occurence substring:  " + ob.maxFreq(s, 2, 3, 4));
    }
}

/*
 * Given a string s, return the maximum number of ocurrences of any substring
 * under the following rules:
 * 
 * The number of unique characters in the substring must be less than or equal
 * to maxLetters.
 * The substring size must be between minSize and maxSize inclusive.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * Output: 2
 * Explanation: Substring "aab" has 2 ocurrences in the original string.
 * It satisfies the conditions, 2 unique letters and size 3 (between minSize and
 * maxSize).
 * Example 2:
 * 
 * Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * Output: 2
 * Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 */
