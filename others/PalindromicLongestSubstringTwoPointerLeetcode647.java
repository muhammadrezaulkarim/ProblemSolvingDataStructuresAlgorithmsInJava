public class PalindromicLongestSubstringTwoPointerLeetcode647 {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return "";

        String maxLengthPalindrome = "";

        int left = 0, right = 0;
        // check for odd length (1, 3, 5 ...) palindromes
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i;

            String palindrome = maxLengthPalindromeAtSpecificIndex(left, right, s);

            if (palindrome.length() > maxLengthPalindrome.length())
                maxLengthPalindrome = palindrome;
        }

        // check for even length (2, 4, 6 etc.) palindromes
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i + 1; // initialize differently

            String palindrome = maxLengthPalindromeAtSpecificIndex(left, right, s);

            if (palindrome.length() > maxLengthPalindrome.length())
                maxLengthPalindrome = palindrome;
        }

        return maxLengthPalindrome;
    }

    private String maxLengthPalindromeAtSpecificIndex(int left, int right, String s) {
        String maxLengthPalindrome = "";

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                //new palindrome
                String substr = s.substring(left, right + 1);

                if (substr.length() > maxLengthPalindrome.length())
                    maxLengthPalindrome = substr;

            } 
            else
                break; // no way we can get any more plindromes

            left--;
            right++;
        }

        return maxLengthPalindrome;
    }

    public static void main(String[] args) {
        //String str = "babad"; // expect bab or aba
        String str = "cbbd"; // expect bb
        PalindromicLongestSubstringTwoPointerLeetcode647 ob = new PalindromicLongestSubstringTwoPointerLeetcode647();
        System.out.println(ob.longestPalindrome(str));
    }
}

/*
 Given a string s, return the longest 
palindromic substring in s.


Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */
