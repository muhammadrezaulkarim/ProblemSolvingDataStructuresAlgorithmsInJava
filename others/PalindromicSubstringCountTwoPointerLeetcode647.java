public class PalindromicSubstringCountTwoPointerLeetcode647 {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int left = 0, right = 0;
        // check for odd length (1, 3, 5 ...) palindromes
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i;

            count+=countPalindrome(left, right, s);
        }

        // check for even length (2, 4, 6 etc.) palindromes
        for (int i = 0; i < s.length(); i++) {
            left = i;
            right = i + 1;  //initialize differently

            count+=countPalindrome(left, right, s);
        }

        return count;
    }

    private int countPalindrome(int left, int right, String s)
    {
        int count = 0;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right))
                count++;
            else
                break; // no way we can get any more plindromes

            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "aaa"; // expect 6
       // String str = "abc"; // expect 3
        PalindromicSubstringCountTwoPointerLeetcode647 ob = new PalindromicSubstringCountTwoPointerLeetcode647();
        System.out.println(ob.countSubstrings(str));
    }
}

/*
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.
 */
