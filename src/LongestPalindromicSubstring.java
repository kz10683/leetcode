
public class LongestPalindromicSubstring
{
    /**
     * Given a string s, find the longest palindromic substring in s. You may assume
     * that the maximum length of s is 1000.
     *
     * Example:
     *
     * Input: "babad"
     *
     * Output: "bab"
     *
     * Note: "aba" is also a valid answer. Example:
     *
     * Input: "cbbd"
     *
     * Output: "bb"
     */
    public static String longestPalindrome(String s)
    {
        if (s.isEmpty() || s.length() == 1)
        {
            return s;
        }

        // At each index i in s, we try and find the longest possible palindrome
        // expanding from that point. The helper method accomplishes this given two
        // indices. We know that each palindrome can have a "center" of x or xx.
        // Then, we just compare and grab the longest one

        String result = "";
        for (int i = 0; i < s.length() - 1; i++)
        {
            String str1 = getLongestPalindromeFromIndices(s, i, i);
            if (str1.length() > result.length())
            {
                result = str1;
            }

            String str2 = getLongestPalindromeFromIndices(s, i, i + 1);
            if (str2.length() > result.length())
            {
                result = str2;
            }
        }

        return result;
    }

    public static String getLongestPalindromeFromIndices(String s, int index1, int index2)
    {
        int start = index1;
        int end = index2;

        // Find the longest palindrome substring from given indices
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
        {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }

    public static void main(String[] args)
    {
        // System.out.println(getLongestPalindromeFromIndices("aba", 0, 2));
        // System.out.println(getLongestPalindromeFromIndices("abab", 1, 3));

        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ra"));
        System.out.println(longestPalindrome("racecar"));
    }

}
