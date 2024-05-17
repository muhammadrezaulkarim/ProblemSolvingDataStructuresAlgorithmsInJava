import java.util.HashSet;
import java.util.Set;

class SlidingWindowWithoutRepeatingCharactersLeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int start = 0, end = 0, max = 0;

        Set<Character> uniqueCharacters = new HashSet<Character>();

        while (end < s.length()) {
            char c = s.charAt(end);

            if (uniqueCharacters.contains(c)) {
                uniqueCharacters.remove(s.charAt(start));
                start++; // increase start only if the current character violate condition
            } else {
                uniqueCharacters.add(c);
                max = Math.max(max, end - start + 1);
                end++; // increase end only if the current character does not violate any condition
            }
        }

        return max;
    }

    public static void main(String[] args) {
        SlidingWindowWithoutRepeatingCharactersLeetCode3 ob = new SlidingWindowWithoutRepeatingCharactersLeetCode3();
        System.out.println(ob.lengthOfLongestSubstring("abcabcbb"));
    }
}

/*
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * 
 * Example 1:
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
